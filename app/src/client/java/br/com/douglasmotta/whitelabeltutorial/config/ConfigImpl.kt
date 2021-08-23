package br.com.douglasmotta.whitelabeltutorial.config

import android.opengl.Visibility
import android.view.View
import javax.inject.Inject


/**
 * Created on August.
 * year 2021 .
 */
class ConfigImpl @Inject constructor() : Config {
    override val addButtonVisibility: Int = View.GONE

}