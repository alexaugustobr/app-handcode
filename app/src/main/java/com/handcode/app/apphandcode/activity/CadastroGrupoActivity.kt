package com.handcode.app.apphandcode.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.handcode.app.apphandcode.R
import kotlinx.android.synthetic.main.activity_cadastro_grupo.*
import kotlinx.android.synthetic.main.toolbar.*

class CadastroGrupoActivity : DebugActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_grupo)
        btnAddIntegrantes.setOnClickListener{
            cadastrarIntegrantes()
        }


        supportActionBar?.title = "Cadastro de Grupo"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun cadastrarIntegrantes() {
        val intent = Intent(context, CadastroIntegranteActivity::class.java)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id = item?.itemId

        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
