package com.example.palette

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.palette.graphics.Palette

/**
 * Actividad que muestra una imagen con una paleta de colores.
 */
class PaletteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palette)

        // Configurar la Toolbar
        val toolbar = findViewById<Toolbar>(R.id.appbar)
        setSupportActionBar(toolbar)

        // Obtener referencias a las vistas
        val imageView = findViewById<ImageView>(R.id.image)
        val textLightVibrant = findViewById<TextView>(R.id.text_light_vibrant)
        val textMuted = findViewById<TextView>(R.id.text_muted)
        val textDarkMuted = findViewById<TextView>(R.id.text_dark_muted)
        val textLightMuted = findViewById<TextView>(R.id.text_light_muted)

        // Recibir imagen seleccionada
        val imageRes = intent.getIntExtra("imageRes", -1)
        if (imageRes != -1) {
            imageView.setImageResource(imageRes)

            // Generar Palette
            val bitmap = BitmapFactory.decodeResource(resources, imageRes)
            Palette.from(bitmap).generate { palette ->
                val vibrant: Palette.Swatch? = palette?.vibrantSwatch
                val darkvibrant: Palette.Swatch? = palette?.darkVibrantSwatch
                val lightvibrant: Palette.Swatch? = palette?.lightVibrantSwatch
                val muted: Palette.Swatch? = palette?.mutedSwatch
                val darkmuted: Palette.Swatch? = palette?.darkMutedSwatch
                val lightmuted: Palette.Swatch? = palette?.lightMutedSwatch

                // Aplicar colores
                if (vibrant != null) {
                    toolbar.setBackgroundColor(vibrant.rgb)
                    toolbar.setTitleTextColor(vibrant.titleTextColor)
                }
                if (darkvibrant != null) {
                    window.statusBarColor = darkvibrant.rgb
                }
                if (lightvibrant != null) {
                    textLightVibrant.setBackgroundColor(lightvibrant.rgb)
                }
                if (muted != null) {
                    textMuted.setBackgroundColor(muted.rgb)
                }
                if (darkmuted != null) {
                    textDarkMuted.setBackgroundColor(darkmuted.rgb)
                }
                if (lightmuted != null) {
                    textLightMuted.setBackgroundColor(lightmuted.rgb)
                }
            }
        }

        // Configurar la transición compartida
        imageView.transitionName = getString(R.string.tran_image) // Nombre de la transición
    }

    /**
     * Finalizar la actividad con una animación de salida. (SLIDE)
     */
    override fun finish() {
        super.finish()
        overridePendingTransition(0, R.transition.slide) // Animación de salida
    }
}