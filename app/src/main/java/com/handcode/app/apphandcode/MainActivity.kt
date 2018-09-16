package com.handcode.app.apphandcode

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.handcode.app.apphandcode.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        buttonLogin.setOnClickListener{
            val usuario = inputNome.text.toString()
            val senha   = inputSenha.text.toString()
            this.logar(usuario,senha)
        }
    }

    private fun logar(usuario: String, senha: String) {
        val intent = Intent(this, AlunoGrupoActivity::class.java)
        val params = Bundle()
        params.putString("usuario",usuario)
        intent.putExtras(params)
        startActivityForResult(intent,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            val result = data?.getStringExtra("result")
            Toast.makeText(context, "$result", Toast.LENGTH_LONG).show()
        }
    }

}
