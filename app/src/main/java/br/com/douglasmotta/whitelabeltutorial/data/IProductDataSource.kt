package br.com.douglasmotta.whitelabeltutorial.data

import android.net.Uri
import br.com.douglasmotta.whitelabeltutorial.domain.model.Product


/**
 * Created on August.
 * year 2021 .
 */
interface IProductDataSource {
    suspend fun getProducts():List<Product>

    suspend fun uploadProductImage(imageUri: Uri):String

    suspend fun createProduct(product: Product):Product
}