package com.handcode.app.apphandcode.activity

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.handcode.app.apphandcode.R
import com.handcode.app.apphandcode.model.Entrega
import java.text.SimpleDateFormat

class EntregasAdapter (
        val entregas: List<Entrega>,
        val onClick: (Entrega) -> Unit): RecyclerView.Adapter<EntregasAdapter.EntregasViewHolder>(){

    class EntregasViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardTitulo: TextView
        val cardDataEntrega: TextView
        val cardDescricao: TextView
        val cardSituacaoEntega: TextView
        //var cardProgress: ProgressBar
        var cardView: CardView

        init {
            cardTitulo = view.findViewById<TextView>(R.id.cardTitulo)
            cardDataEntrega = view.findViewById<TextView>(R.id.cardDataEntrega)
            cardDescricao = view.findViewById<TextView>(R.id.cardDescricao)
            cardSituacaoEntega = view.findViewById<TextView>(R.id.cardSituacaoEntega)
            //cardProgress = view.findViewById<ProgressBar>(R.id.cardProgress)
            cardView = view.findViewById<CardView>(R.id.card_entregas)
        }

    }

    override fun getItemCount() = this.entregas.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntregasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_entregas, parent, false)

        val holder = EntregasViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: EntregasViewHolder, position: Int) {
        val context = holder.itemView.context

        val entrega = entregas[position]

        holder.cardTitulo.text = entrega.titulo

        if (entrega.dataEntrega != null) {
            holder.cardDataEntrega.text = "Prazo: " + entrega.dataEntrega
        }

        holder.cardDescricao.text = entrega.descricao
        holder.cardSituacaoEntega.text = entrega.status.toString()
        //holder.cardProgress.visibility = View.VISIBLE



        holder.itemView.setOnClickListener{onClick(entrega)}
    }

}