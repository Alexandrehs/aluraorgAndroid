package com.example.orgsalura.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import coil.load
import com.example.orgsalura.R
import com.example.orgsalura.dao.ProdutosDAO
import com.example.orgsalura.databinding.ActivityFormularioProdutosBinding
import com.example.orgsalura.databinding.CarregaImagemViewBinding
import com.example.orgsalura.extentions.tentacarregarImagem
import com.example.orgsalura.model.Produto
import com.example.orgsalura.ui.dialog.ImagemFormularioDialog
import java.math.BigDecimal

class FormularioProdutosActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFormularioProdutosBinding
    private var url : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Cadastro de Produtos"
        binding = ActivityFormularioProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imagemFormulario.setOnClickListener {
            ImagemFormularioDialog(this).mostra(url) {
                imagem -> url = imagem
                binding.imagemFormulario.tentacarregarImagem(url)
            }
        }


        binding.activityFormularioProdutosButtonSave.setOnClickListener {
            val precoDigited = if (binding.activityFormularioProdutosPreco.text.toString().isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(binding.activityFormularioProdutosPreco.text.toString())
            }

            val produtosDAO = ProdutosDAO()

            produtosDAO.adiciona(
                Produto(
                    title = binding.activityFormularioProdutosTitle.text.toString(),
                    descricao = binding.activityFormularioProdutosDescricao.text.toString(),
                    preco = precoDigited,
                    imagem = url
                ),
            )

            finish()
        }
    }
}