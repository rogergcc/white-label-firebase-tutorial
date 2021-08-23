package br.com.douglasmotta.whitelabeltutorial.config.di

import br.com.douglasmotta.whitelabeltutorial.config.Config
import br.com.douglasmotta.whitelabeltutorial.config.ConfigImpl
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
interface ConfigModule {

    @Binds
    fun bindConfig(config: ConfigImpl): Config
}