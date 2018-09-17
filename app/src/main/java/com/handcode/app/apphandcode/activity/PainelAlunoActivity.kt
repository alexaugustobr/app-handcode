package com.handcode.app.apphandcode.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.handcode.app.apphandcode.R

class PainelAlunoActivity : DebugActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_painel_aluno)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
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
            Toast.makeText(context, "Botão de configuracoes",
                    Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
