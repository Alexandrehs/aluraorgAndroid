package com.example.orgsalura.ui.dialog

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import coil.load
import com.example.orgsalura.databinding.CarregaImagemViewBinding
import com.example.orgsalura.extentions.tentacarregarImagem

class ImagemFormularioDialog (private val context : Context){

    fun mostra(urlPadrao: String? = null, quandoImagemCarregada: (imagem: String?) -> Unit) {
        val binding = CarregaImagemViewBinding.inflate(LayoutInflater.from(context)).apply {

            urlPadrao?.let {
                imagemDialog.tentacarregarImagem(urlPadrao)
                urlImagem.setText(urlPadrao)
            }

            buttonDialogCarrega.setOnClickListener{
                var url = urlImagem.text.toString()
                imagemDialog.load(url)
            }

            AlertDialog.Builder(context)
                .setView(root)
                .setPositiveButton("Confirmar") {_, _->
                    var url = urlImagem.text.toString()
                    Log.i("teste", "mostra: $url")
                    quandoImagemCarregada(url)
                }
                .setNegativeButton("Cancelar") {_, _->}
                .show()
        }
    }
}