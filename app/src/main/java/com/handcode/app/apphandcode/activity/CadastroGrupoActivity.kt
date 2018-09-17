package com.handcode.app.apphandcode.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.handcode.app.apphandcode.R
import kotlinx.android.synthetic.main.activity_cadastro_grupo.*

class CadastroGrupoActivity : DebugActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_grupo)
        btnAddIntegrantes.setOnClickListener{
            cadastrarIntegrantes()
        }
    }

    private fun cadastrarIntegrantes() {
        val intent = Intent(context, CadastroIntegranteActivity::class.java)
        startActivity(intent)
    }
}
