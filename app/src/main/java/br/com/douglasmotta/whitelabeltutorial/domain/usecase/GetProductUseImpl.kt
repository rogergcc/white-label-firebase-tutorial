package br.com.douglasmotta.whitelabeltutorial.domain.usecase

import br.com.douglasmotta.whitelabeltutorial.data.ProductRepository
import br.com.douglasmotta.whitelabeltutorial.domain.model.Product


/**
 * Created on August.
 * year 2021 .
 */
class GetProductUseImpl(
    private val productRepository: ProductRepository
):IGetProductUseCase {
    override suspend fun invoke(): List<Product> {
        return productRepository.getProducts()
    }
}