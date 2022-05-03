package com.example.orgsalura.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.orgsalura.dao.ProdutosDAO
import com.example.orgsalura.databinding.ActivityFormularioProdutosBinding
import com.example.orgsalura.model.Produto
import java.math.BigDecimal

class FormularioProdutosActivity : AppCompatActivity() {
    private lateinit var biding : ActivityFormularioProdutosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityFormularioProdutosBinding.inflate(layoutInflater)
        setContentView(biding.root)

        biding.activityFormularioProdutosButtonSave.setOnClickListener {
            val precoDigited = if (biding.activityFormularioProdutosPreco.text.toString().isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(biding.activityFormularioProdutosPreco.text.toString())
            }

            val produtosDAO = ProdutosDAO()

            produtosDAO.adiciona(
                Produto(
                    title = biding.activityFormularioProdutosTitle.text.toString(),
                    descricao = biding.activityFormularioProdutosDescricao.text.toString(),
                    preco = precoDigited
                ),
            )

            finish()
        }
    }
}