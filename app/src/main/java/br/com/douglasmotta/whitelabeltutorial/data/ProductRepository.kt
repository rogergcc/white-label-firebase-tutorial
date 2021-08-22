package br.com.douglasmotta.whitelabeltutorial.data

import android.net.Uri
import br.com.douglasmotta.whitelabeltutorial.domain.model.Product
import javax.inject.Inject


/**
 * Created on August.
 * year 2021 .
 */
class ProductRepository @Inject constructor(
    private val dataSource: IProductDataSource
    ) {

    suspend fun getProducts():List<Product> = dataSource.getProducts()

    suspend fun uploadProductImage(imageUri: Uri):String = dataSource.uploadProductImage(imageUri)

    suspend fun createProduct(product: Product): Product = dataSource.createProduct(product)
}