package com.handcode.app.apphandcode.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.handcode.app.apphandcode.R
import kotlinx.android.synthetic.main.activity_cadastro_grupo.*
import kotlinx.android.synthetic.main.activity_cadastro_integrante.*
import kotlinx.android.synthetic.main.toolbar.*

class CadastroIntegranteActivity : AppCompatActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_integrante)
        buttonAddOutro.setOnClickListener{cadastrarIntegrantes()}
        buttonFinalizar.setOnClickListener{finalizar()}


        supportActionBar?.title = "Cadastro de Integrante"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun finalizar() {
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
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
