package br.com.douglasmotta.whitelabeltutorial.data.di

import br.com.douglasmotta.whitelabeltutorial.data.FirebaseProductDataSource
import br.com.douglasmotta.whitelabeltutorial.data.IProductDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Created on August.
 * year 2021 .
 */
@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Singleton
    @Binds
    fun bindProductDataSource(dataSource: FirebaseProductDataSource):IProductDataSource

//    @Binds
//    fun bindProductDataSource(dataSource: ServerProductDataSource):IProductDataSource //FROM NETWORK API WEB

}