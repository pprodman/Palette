package com.example.palette

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Actividad principal que muestra una lista de tarjetas con imágenes.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.appbar)
        setSupportActionBar(toolbar)

        // Crear lista de tarjetas
        val items = ArrayList<Tarjeta>()
        items.add(Tarjeta(R.drawable.image1))
        items.add(Tarjeta(R.drawable.image2))
        items.add(Tarjeta(R.drawable.image3))
        items.add(Tarjeta(R.drawable.image4))
        items.add(Tarjeta(R.drawable.image5))
        items.add(Tarjeta(R.drawable.image6))
        items.add(Tarjeta(R.drawable.image7))
        items.add(Tarjeta(R.drawable.image8))

        // Configurar RecyclerView
        val recView = findViewById<RecyclerView>(R.id.recview)
        // Mejorar el rendimiento
        recView.setHasFixedSize(true)
        // Usar un administrador para LinearLayout
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        // Configurar adaptador
        recView.adapter = CardsAdapter(items) { imageView, tarjeta ->

            // Iniciar PaletteActivity con transición compartida
            val intent = Intent(this, PaletteActivity::class.java).apply {
                putExtra("imageRes", tarjeta.imagen)
            }

            // Iniciar PaletteActivity con transición compartida
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                imageView,
                getString(R.string.tran_image)
            )

            startActivity(intent, options.toBundle())
        }
    }
}
