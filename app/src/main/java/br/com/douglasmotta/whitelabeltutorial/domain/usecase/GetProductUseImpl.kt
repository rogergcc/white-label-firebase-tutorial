package br.com.douglasmotta.whitelabeltutorial.domain.usecase

import br.com.douglasmotta.whitelabeltutorial.data.ProductRepository
import br.com.douglasmotta.whitelabeltutorial.domain.model.Product
import javax.inject.Inject


/**
 * Created on August.
 * year 2021 .
 */
class GetProductUseImpl @Inject constructor(
    private val productRepository: ProductRepository
):IGetProductUseCase {
    override suspend fun invoke(): List<Product> {
        return productRepository.getProducts()
    }
}