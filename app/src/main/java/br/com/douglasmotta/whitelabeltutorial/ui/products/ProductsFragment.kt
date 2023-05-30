package br.com.douglasmotta.whitelabeltutorial.ui.products

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.fragment.findNavController
import br.com.douglasmotta.whitelabeltutorial.R
import br.com.douglasmotta.whitelabeltutorial.databinding.FragmentProductsBinding
import br.com.douglasmotta.whitelabeltutorial.domain.model.Product
import br.com.douglasmotta.whitelabeltutorial.util.PRODUCT_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment() {

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProductsViewModel by viewModels()

    private val productsAdapter = ProductsAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setListeners()
        observeNavBackStack()
        observeVMEvents()

        getProducts()
    }


    private fun setRecyclerView() {
        binding.recyclerProducts.run {
            setHasFixedSize(true)
            adapter = productsAdapter
        }
    }

    private fun setListeners() {
        with(binding) {
            swipeRefreshProducts.setOnRefreshListener {
                getProducts()
            }
            fabAdd.setOnClickListener {
                findNavController().navigate(R.id.action_productsFragment_to_addProductFragment)
            }
        }

    }

    private fun getProducts() {
        viewModel.getProducts()
    }

    private fun observeNavBackStack() {
        findNavController().run {
            val navBackStackEntry = getBackStackEntry(R.id.productsFragment)
            val savedStateHandle = navBackStackEntry.savedStateHandle
            val observer = LifecycleEventObserver { _, event ->
                if (event == Lifecycle.Event.ON_RESUME && savedStateHandle.contains(PRODUCT_KEY)) {
                    val product = savedStateHandle.get<Product>(PRODUCT_KEY)
                    val oldList = productsAdapter.currentList
                    val newList = oldList.toMutableList().apply {
                        add(product)
                    }
                    productsAdapter.submitList(newList)
                    binding.recyclerProducts.smoothScrollToPosition(newList.size - 1)
                    savedStateHandle.remove<Product>(PRODUCT_KEY)
                }
            }
            navBackStackEntry.lifecycle.addObserver(observer)

            viewLifecycleOwner.lifecycle.addObserver(LifecycleEventObserver { _, event ->
                if (event == Lifecycle.Event.ON_DESTROY) {
                    navBackStackEntry.lifecycle.removeObserver(observer)
                }
            })

        }
    }

    private fun observeVMEvents() {
        viewModel.productsData.observe(viewLifecycleOwner) { products ->
            binding.emptyState.root.visibility = View.GONE
            binding.swipeRefreshProducts.isRefreshing = false
            Log.e(Companion.TAG, "productsData observeVMEvents: $products")
            productsAdapter.submitList(products)
        }
        viewModel.addButtonVisibilityData.observe(viewLifecycleOwner) { visibility ->
            binding.fabAdd.visibility = visibility
        }
        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            binding.emptyState.root.visibility = View.VISIBLE
            binding.swipeRefreshProducts.isRefreshing = false
            binding.emptyState.lblEmptyMessage.text = message
            Log.d(Companion.TAG, "errorMessage observeVMEvents: $message")
            Toast.makeText(context, "e: $message", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        private const val TAG = "ProductsFragment"
    }

}