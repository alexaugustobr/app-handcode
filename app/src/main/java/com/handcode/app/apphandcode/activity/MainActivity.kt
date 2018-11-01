package com.handcode.app.apphandcode.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.handcode.app.apphandcode.Prefs
import com.handcode.app.apphandcode.R
import com.handcode.app.apphandcode.model.AlunoNaoEncontradoException
import com.handcode.app.apphandcode.model.LoginService
import com.handcode.app.apphandcode.model.SenhaIncorretaException
import com.handcode.app.apphandcode.service.LocalStore
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        buttonLogin.setOnClickListener{
            onClickLogin()
            login(inputUsuario.text.toString(),inputSenha.text.toString())
        }
        progressBar.visibility = View.INVISIBLE

        buttonCadastrarGrupo.setOnClickListener{
            cadastrarGrupo()
        }

        /*var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Gerenciamento de OPE's"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)*/
        var lembrar = Prefs.getBoolean("lembrar")
        if (lembrar) {
            var lembrarNome  = Prefs.getString("lembrarNome")
            var lembrarSenha  = Prefs.getString("lembrarSenha")
            inputUsuario.setText(lembrarNome)
            inputSenha.setText(lembrarSenha)
            checkBoxLogin.isChecked = lembrar

        }

    }

    private fun cadastrarGrupo() {
        val intent = Intent(context, CadastroGrupoActivity::class.java)
        startActivity(intent)
    }

    fun onClickLogin() {

        val valorUsuario = inputUsuario.text.toString()
        val valorSenha = inputSenha.text.toString()

        // armazenar valor do checkbox
        Prefs.setBoolean("lembrar", checkBoxLogin.isChecked)
        // verificar se é para pembrar nome e senha
        if (checkBoxLogin.isChecked) {
            Prefs.setString("lembrarNome", valorUsuario)
            Prefs.setString("lembrarSenha", valorSenha)
        } else {
            Prefs.setString("lembrarNome", "")
            Prefs.setString("lembrarSenha", "")
        }
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
