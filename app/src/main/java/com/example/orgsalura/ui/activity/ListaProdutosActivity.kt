package com.example.orgsalura.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.orgsalura.R
import com.example.orgsalura.dao.ProdutosDAO
import com.example.orgsalura.ui.recycledview.adapter.RecyclerViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity() {
    private val produtosDAO = ProdutosDAO()
    private val recyclerViewAdapter = RecyclerViewAdapter(
        context = this,
        produtosDAO.listaTodos(),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_produtos_activity)
        configuraAdapter()
        configuraFAB()
    }

    override fun onResume() {
        super.onResume()
        recyclerViewAdapter.atualiza(produtosDAO.listaTodos())
    }

    private fun configuraAdapter() {
        findViewById<RecyclerView>(R.id.lista_produtos_activity_recyclerView).adapter = recyclerViewAdapter
    }

    private fun configuraFAB() {
        findViewById<FloatingActionButton>(R.id.lista_produtos_activity_fab).setOnClickListener {
            vaiParaFormulario()
        }
    }

    private fun vaiParaFormulario() {
        startActivity(Intent(this, FormularioProdutosActivity::class.java))
    }
}