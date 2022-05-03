package com.example.orgsalura.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.orgsalura.R
import com.example.orgsalura.dao.ProdutosDAO
import com.example.orgsalura.databinding.ListaProdutosActivityBinding
import com.example.orgsalura.ui.recycledview.adapter.RecyclerViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity() {
    private lateinit var binding : ListaProdutosActivityBinding
    private val produtosDAO = ProdutosDAO()
    private val recyclerViewAdapter = RecyclerViewAdapter(
        context = this,
        produtosDAO.listaTodos(),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListaProdutosActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configuraAdapter()
        configuraFAB()
    }

    override fun onResume() {
        super.onResume()
        recyclerViewAdapter.atualiza(produtosDAO.listaTodos())
    }

    private fun configuraAdapter() {
        binding.listaProdutosActivityRecyclerView.adapter = recyclerViewAdapter
    }

    private fun configuraFAB() {
        binding.listaProdutosActivityFab.setOnClickListener {
            vaiParaFormulario()
        }
    }

    private fun vaiParaFormulario() {
        startActivity(Intent(this, FormularioProdutosActivity::class.java))
    }
}