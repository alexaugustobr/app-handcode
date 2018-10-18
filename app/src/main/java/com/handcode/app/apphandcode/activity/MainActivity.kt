package com.handcode.app.apphandcode.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.widget.Toast
import com.handcode.app.apphandcode.R
import com.handcode.app.apphandcode.model.AlunoNaoEncontradoException
import com.handcode.app.apphandcode.model.AlunoService
import com.handcode.app.apphandcode.model.LoginService
import com.handcode.app.apphandcode.model.SenhaIncorretaException
import com.handcode.app.apphandcode.service.EntregaService
import com.handcode.app.apphandcode.service.LocalStore
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : DebugActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        buttonLogin.setOnClickListener{
            login(inputUsuario.text.toString(),inputSenha.text.toString())
        }

        buttonCadastrarGrupo.setOnClickListener{
            cadastrarGrupo()
        }

        /*var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Gerenciamento de OPE's"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)*/

    }

    private fun cadastrarGrupo() {
        val intent = Intent(context, CadastroGrupoActivity::class.java)
        startActivity(intent)
    }

    private fun login(usuario : String, senha : String) {
        Thread {
            try {

                val tokenContainer = LoginService.logar(usuario, senha)

                val alunoAutenticado = LoginService.informacoesUsuarioAutenticado(tokenContainer)

                val params = Bundle()
                params.putString("usuario", usuario)

                LocalStore.data.put("token", tokenContainer)
                LocalStore.data.put("usuario", alunoAutenticado)

                LocalStore.data.get("token")
                val intent = Intent(context, PainelAlunoActivity::class.java)
                intent.putExtras(params)

                startActivity(intent)

                val nome = alunoAutenticado.nome
                runOnUiThread {
                    Toast.makeText(context, "Bem vindo $nome.", Toast.LENGTH_LONG).show()
                }
            } catch (e : AlunoNaoEncontradoException) {
                Log.getStackTraceString(e)
                e.printStackTrace()
                runOnUiThread {
                    Toast.makeText(context, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
                }
            } catch (e : SenhaIncorretaException) {
                Log.getStackTraceString(e)
                e.printStackTrace()
                runOnUiThread {
                    Toast.makeText(context, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
                }
            } catch (e : Exception) {
                Log.getStackTraceString(e)
                e.printStackTrace()
                runOnUiThread {
                    Toast.makeText(context, "Ocorreu um erro interno.", Toast.LENGTH_LONG).show()
                }

            }
        }.start()
    }

}
