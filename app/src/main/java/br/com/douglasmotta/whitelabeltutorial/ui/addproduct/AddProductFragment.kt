package br.com.douglasmotta.whitelabeltutorial.ui.addproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.douglasmotta.whitelabeltutorial.databinding.AddProductFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddProductFragment : BottomSheetDialogFragment() {

    private var _binding:AddProductFragmentBinding?=null
    private val binding get() = _binding!!
    private lateinit var viewModel: AddProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AddProductFragmentBinding.inflate(inflater,container,false)
//        return inflater.inflate(R.layout.add_product_fragment, container, false)
        return binding.root
    }


}