package br.com.douglasmotta.whitelabeltutorial.domain.usecase

import android.net.Uri
import br.com.douglasmotta.whitelabeltutorial.data.ProductRepository
import javax.inject.Inject


/**
 * Created on August.
 * year 2021 .
 */
class UploadProductImageUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : IUploadProductImageUseCase {

    override suspend fun invoke(imageUri: Uri): String {
        return productRepository.uploadProductImage(imageUri)
    }
}