package com.example.orgsalura.ui.recycledview.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.orgsalura.R
import com.example.orgsalura.databinding.ProdutoItemBinding
import com.example.orgsalura.extentions.tentacarregarImagem
import com.example.orgsalura.model.Produto
import java.math.BigDecimal
import java.text.Format
import java.text.NumberFormat
import java.util.*

class RecyclerViewAdapter(
    private val context: Context,
    produtos : List<Produto>,
    var quandoClicaNoItemListener: (produto: Produto) -> Unit
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val produtos = mutableListOf<Produto>()

    inner class ViewHolder(binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        lateinit var produto: Produto
        private val title = binding.produtoItemTitle
        private val descricao = binding.produtoItemDescricao
        private val preco = binding.produtoItemPreco
        private var imagem = binding

        init {
            itemView.setOnClickListener{
                Log.i("click", "cliclou no item: ${produto.title}")
                if(::produto.isInitialized) {
                    quandoClicaNoItemListener(produto)
                }
            }
        }

        fun vinculation(produto: Produto) {
            title.text = produto.title
            descricao.text = produto.descricao
            preco.text = convertToMoneyCurrency(produto.preco)
            imagem.produtoItemImageView.tentacarregarImagem(produto.imagem)
        }
        private fun convertToMoneyCurrency(value : BigDecimal) : String {
            val numberFormat : NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            return numberFormat.format(value)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.vinculation(produtos[position])
    }

    override fun getItemCount(): Int = produtos.size

    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }

}
