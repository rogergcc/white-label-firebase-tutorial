package br.com.douglasmotta.whitelabeltutorial.ui.products

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.douglasmotta.whitelabeltutorial.domain.model.Product
import br.com.douglasmotta.whitelabeltutorial.domain.usecase.IGetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created on August.
 * year 2021 .
 */

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: IGetProductUseCase
) : ViewModel() {

    private val _productsData = MutableLiveData<List<Product>>()
    val productsData: LiveData<List<Product>> = _productsData

    fun getProducts() = viewModelScope.launch {
        try {
            val products = getProductsUseCase()
            _productsData.value = products
        } catch (e: Exception) {
            Log.d("ProductsViewModel: ", e.toString())
        }
    }
}