package com.example.orgsalura.ui.recycledview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgsalura.R
import com.example.orgsalura.model.Produto

class RecyclerViewAdapter(
    private val context: Context,
    produtos : List<Produto>
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val produtos = mutableListOf<Produto>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vinculation(produto: Produto) {
            itemView.findViewById<TextView>(R.id.produto_item_title).text = produto.title
            itemView.findViewById<TextView>(R.id.produto_item_descricao).text = produto.descricao
            itemView.findViewById<TextView>(R.id.produto_item_preco).text = produto.preco.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.produto_item, parent, false)
        return ViewHolder(view)
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
