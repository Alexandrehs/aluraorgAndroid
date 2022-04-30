package com.example.orgsalura.dao

import com.example.orgsalura.model.Produto

class ProdutosDAO {

    fun adiciona(produto : Produto) {
        produtos.add(produto)
    }

    fun listaTodos() : List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}