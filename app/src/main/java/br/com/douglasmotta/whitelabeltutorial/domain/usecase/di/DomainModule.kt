package br.com.douglasmotta.whitelabeltutorial.domain.usecase.di

import br.com.douglasmotta.whitelabeltutorial.domain.usecase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


/**
 * Created on August.
 * year 2021 .
 */
@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {
    @Binds
    fun bindCreateProductUseCase(useCase: CreateProductUseCaseImpl): ICreateProductUseCase

    @Binds
    fun bindGetProductsUseCase(useCase: GetProductUseImpl): IGetProductUseCase

    @Binds
    fun bindUploadImageUseCase(useCase: UploadProductImageUseCaseImpl): IUploadProductImageUseCase

}