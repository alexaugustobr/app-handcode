package com.handcode.app.apphandcode.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.handcode.app.apphandcode.R
import com.handcode.app.apphandcode.model.AlunoNaoEncontradoException
import com.handcode.app.apphandcode.model.AlunoService
import com.handcode.app.apphandcode.model.LoginService
import com.handcode.app.apphandcode.model.SenhaIncorretaException
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        buttonLogin.setOnClickListener{
            login(inputUsuario.text.toString(),inputSenha.text.toString())
        }

    }

    fun login(usuario : String, senha : String) {
        try {

            val alunoLogado = LoginService.logar(usuario, senha)

            val params = Bundle()
            params.putString("usuario", usuario)

            val intent = Intent(context, PainelAlunoActivity::class.java)
            intent.putExtras(params)

            startActivity(intent)

            val nome = alunoLogado.nome

            Toast.makeText(context, "Bem vindo $nome.", Toast.LENGTH_LONG).show()

        } catch (e : AlunoNaoEncontradoException) {
            Log.getStackTraceString(e)
            Toast.makeText(context, "Usuário ou senha incorretos" , Toast.LENGTH_LONG).show()
        } catch (e : SenhaIncorretaException) {
            Log.getStackTraceString(e)
            Toast.makeText(context, "Usuário ou senha incorretos" , Toast.LENGTH_LONG).show()
        } catch (e : Exception) {
            Log.getStackTraceString(e)
            Toast.makeText(context, "Ocorreu um erro interno.", Toast.LENGTH_LONG).show()
        }
    }

}
