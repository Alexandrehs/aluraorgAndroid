package com.example.orgsalura.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.orgsalura.R
import com.example.orgsalura.dao.ProdutosDAO
import com.example.orgsalura.model.Produto
import java.math.BigDecimal

class FormularioProdutosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_produtos)

        findViewById<Button>(R.id.activity_formulario_produtos_buttonSave).setOnClickListener {
            val precoDigited = if (findViewById<TextView>(R.id.activity_formulario_produtos_preco).text.toString().isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(findViewById<TextView>(R.id.activity_formulario_produtos_preco).text.toString())
            }

            val produtosDAO = ProdutosDAO()

            produtosDAO.adiciona(
                Produto(
                    title = findViewById<TextView>(R.id.activity_formulario_produtos_title).text.toString(),
                    descricao = findViewById<TextView>(R.id.activity_formulario_produtos_descricao).text.toString(),
                    preco = precoDigited
                ),
            )

            Log.i("FormularioProduto", "onCreate : ${produtosDAO.listaTodos()}")
            finish()
        }
    }
}