package br.com.douglasmotta.whitelabeltutorial.domain.usecase

import br.com.douglasmotta.whitelabeltutorial.domain.model.Product


/**
 * Created on August.
 * year 2021 .
 */
interface IGetProductUseCase {

    suspend operator fun invoke():List<Product>
}