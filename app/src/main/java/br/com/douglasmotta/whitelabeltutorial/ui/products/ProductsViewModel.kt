package br.com.douglasmotta.whitelabeltutorial.ui.products

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.douglasmotta.whitelabeltutorial.config.Config
import br.com.douglasmotta.whitelabeltutorial.domain.model.Product
import br.com.douglasmotta.whitelabeltutorial.domain.usecase.IGetProductUseCase
import com.google.firebase.firestore.FirebaseFirestoreException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created on August.
 * year 2021 .
 */

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: IGetProductUseCase,
    config: Config
) : ViewModel() {

    private val _productsData = MutableLiveData<List<Product>>(emptyList())
    val productsData: LiveData<List<Product>> = _productsData

    private val _addButtonVisibilityData = MutableLiveData(config.addButtonVisibility)
    val addButtonVisibilityData: LiveData<Int> = _addButtonVisibilityData

    private val _getProductsError = MutableLiveData<String>()
    val productsDataError: LiveData<String> = _getProductsError

    private val _errorMessage = MutableLiveData<String>()

    val errorMessage: LiveData<String> get() = _errorMessage


    fun getProducts() = viewModelScope.launch {
        try {

            val products = getProductsUseCase()
            _productsData.value = products
        } catch (e: FirebaseFirestoreException) {
            Log.d("ProductsViewModel", "getProducts 1: ${e.message}")
            Log.d("ProductsViewModel", "getProducts 2: ${e.toString()}")
            Log.d("ProductsViewModel", "getProducts 3: ${e.localizedMessage}")
            Log.d("ProductsViewModel", "getProducts 4: ${e.code}")
            Log.d("ProductsViewModel", "getProducts 5: ${e.cause}")
            _errorMessage.value = e.message
        } catch (e: Exception) {
            Log.d("ProductsViewModel : ", " Exception ${e.toString()}")
        }
    }

    data class ProductsUiState(
        val isLoading: Boolean,
        val failureReason: String?, // Not `showErrorDialog: Boolean`
        val searchQuery: String,
        val repos: List<Product> = emptyList()
    )
}
