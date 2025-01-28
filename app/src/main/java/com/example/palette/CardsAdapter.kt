package com.example.palette

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adaptador personalizado para el RecyclerView que muestra tarjetas de imágenes.
 */
class CardsAdapter(
    private val items: List<Tarjeta>,
    private val onClick: (ImageView, Tarjeta) -> Unit
) : RecyclerView.Adapter<CardsAdapter.ViewHolder>() {

    /**
     * Crea una nueva vista para cada elemento en la lista.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_cards, parent, false)
    )

    /**
     * Vincula los datos del elemento en la posición dada con la vista.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], onClick)
    }

    /**
     * Devuelve el número total de elementos en la lista.
     */
    override fun getItemCount() = items.size

    /**
     * ViewHolder personalizado para cada elemento en la lista.
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView: ImageView = view.findViewById(R.id.image1)

        /**
         * Vincula los datos de la tarjeta con la vista.
         */
        fun bind(tarjeta: Tarjeta, onClick: (ImageView, Tarjeta) -> Unit) {
            imageView.setImageResource(tarjeta.imagen)
            itemView.setOnClickListener { onClick(imageView, tarjeta) }
        }
    }
}