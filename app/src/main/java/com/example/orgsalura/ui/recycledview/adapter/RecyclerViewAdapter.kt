package com.example.orgsalura.ui.recycledview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgsalura.R
import com.example.orgsalura.databinding.ProdutoItemBinding
import com.example.orgsalura.model.Produto

class RecyclerViewAdapter(
    private val context: Context,
    produtos : List<Produto>
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val produtos = mutableListOf<Produto>()

    class ViewHolder(binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val title = binding.produtoItemTitle
        private val descricao = binding.produtoItemDescricao
        private val preco = binding.produtoItemPreco
        fun vinculation(produto: Produto) {
            title.text = produto.title
            descricao.text = produto.descricao
            preco.text = produto.preco.toPlainString()
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
