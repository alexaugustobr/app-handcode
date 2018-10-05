package com.handcode.app.apphandcode.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.handcode.app.apphandcode.R
import kotlinx.android.synthetic.main.activity_cadastro_grupo.*
import kotlinx.android.synthetic.main.toolbar.*

class EntregasActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entregas)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Entregas"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()
    }

    private fun configuraMenuLateral(){
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        var menuLateral = findViewById<DrawerLayout>(R.id.layoutMenuLateral)

        var toogle = ActionBarDrawerToggle (
                this,
                menuLateral,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)

        menuLateral.addDrawerListener(toogle)
        toogle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.menu_lateral)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navPainelAluno -> {
                Toast.makeText(this, "Clicou", Toast.LENGTH_SHORT).show()
            }
        }


        val drawer = findViewById<DrawerLayout>(R.id.layoutMenuLateral)
        drawer.closeDrawer(GravityCompat.START)
        return true
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
}
