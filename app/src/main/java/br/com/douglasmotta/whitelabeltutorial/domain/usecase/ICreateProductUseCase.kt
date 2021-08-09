package br.com.douglasmotta.whitelabeltutorial.domain.usecase

import android.net.Uri
import br.com.douglasmotta.whitelabeltutorial.domain.model.Product


/**
 * Created on August.
 * year 2021 .
 */
interface ICreateProductUseCase {

    suspend operator fun invoke(description: String, price:Double, imageUrl: Uri):Product
}