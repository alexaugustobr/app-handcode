package com.handcode.app.apphandcode

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_aluno_grupo.*

class AlunoGrupoActivity : AppCompatActivity() {

    private val context: Context get() = this
    private var disciplinas = listOf<Disciplina>()
    var recyclerDisciplinas: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // código existente - omitido
        // configurar cardview
        recyclerDisciplinas = findViewById<RecyclerView>(R.id.recyclerDisciplinas)
        recyclerDisciplinas?.layoutManager = LinearLayoutManager(context)
        recyclerDisciplinas?.itemAnimator = DefaultItemAnimator()
        recyclerDisciplinas?.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
// task para recuperar as disciplinas
        taskDisciplinas()
    }

    fun taskDisciplinas() {
        disciplinas = DisciplinaService.getDisciplinas(context)
// atualizar lista
        recyclerDisciplinas?.adapter = DisciplinaAdapter(disciplinas) { onClickDisciplina(it) }
    }

    // tratamento do evento de clicar em uma disciplina
    fun onClickDisciplina(disciplina: Disciplina) {
        Toast.makeText(context, "Clicou disciplina ${disciplina.nome}", Toast.LENGTH_SHORT)
                .show()
    }

    private fun sair() {
        val returnIntent = Intent()
        returnIntent.putExtra("result", "Saída do BrewerApp")
        setResult(1, returnIntent)
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // infla o menu com os botões da ActionBar
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // id do item clicado
        val id = item?.itemId
        // verificar qual item foi clicado e mostrar a mensagem
        //Toast na tela
        // a comparação é feita com o recurso de id definido no xml
        if (id == R.id.action_buscar) {
            Toast.makeText(context, "Botão de buscar",
                    Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_atualizar) {
            Toast.makeText(context, "Botão de atualizar",
                    Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_config) {
            Toast.makeText(context, "Botão de configuracoes",
                    Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
