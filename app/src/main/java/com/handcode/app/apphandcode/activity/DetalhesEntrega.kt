package com.handcode.app.apphandcode.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.handcode.app.apphandcode.R
import com.handcode.app.apphandcode.model.Entrega
import com.handcode.app.apphandcode.service.EntregaService

import com.squareup.picasso.Picasso

class DetalhesEntrega : DebugActivity() {

    private val context: Context get() = this
    var entrega: Entrega? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entrega_activity)

        // recuperar onjeto de Disciplina da Intent
        entrega = intent.getSerializableExtra("entrega") as Entrega

        // configurar título com nome da Disciplina e botão de voltar da Toobar
        // colocar toolbar
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // alterar título da ActionBar
        supportActionBar?.title = entrega?.titulo

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        var texto = findViewById<TextView>(R.id.cardTitulo)
        texto.text = entrega?.titulo

        var dataEntrega = findViewById<TextView>(R.id.cardDataEntrega)
        dataEntrega.text ="Prazo: "+entrega?.dataEntrega

        var descricao = findViewById<TextView>(R.id.cardDescricao)
        descricao.text = entrega?.descricao

        var status = findViewById<TextView>(R.id.cardSituacaoEntega)
        status.text = entrega?.descricao

    }

    // método sobrescrito para inflar o menu na Actionbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // infla o menu com os botões da ActionBar
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.actionBuscar) {
            Toast.makeText(context, "Botão de buscar",
                    Toast.LENGTH_LONG).show()
        } else if (id == R.id.actionAtualizar) {
            Toast.makeText(context, "Botão de atualizar",
                    Toast.LENGTH_LONG).show()
        } else if (id == R.id.actionConfig) {
            val intent = Intent(context, ConfiguracoesActivity::class.java)
            startActivity(intent)
        } else if (id == R.id.actionSair) {
            val returnIntent = Intent()
            setResult(1, returnIntent)
            finish()
        } else if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    /*override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // id do item clicado
        val id = item?.itemId
        // verificar qual item foi clicado
        // remover a disciplina no WS
        if  (id == R.id.action_remover) {
            // alerta para confirmar a remeção
            // só remove se houver confirmação positiva
            AlertDialog.Builder(this)
                    .setTitle(R.string.app_name)
                    .setMessage("Deseja excluir a disciplina")
                    .setPositiveButton("Sim") {
                        dialog, which ->
                        dialog.dismiss()
                        taskExcluir()
                    }.setNegativeButton("Não") {
                        dialog, which -> dialog.dismiss()
                    }.create().show()
        }
        // botão up navigation
        else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }*/

    /*private fun taskExcluir() {
        if (this.entrega != null && this.entrega is Entrega) {
            // Thread para remover a disciplina
            Thread {
                EntregaService.delete(this.entrega as Entregas, context)
                runOnUiThread {
                    // após remover, voltar para activity anterior
                    finish()
                }
            }.start()
        }
    }*/

}