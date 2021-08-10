package br.com.douglasmotta.whitelabeltutorial.domain.usecase

import android.net.Uri


/**
 * Created on August.
 * year 2021 .
 */
interface IUploadProductImageUseCase {

    suspend operator fun invoke(imageUri: Uri):String
}