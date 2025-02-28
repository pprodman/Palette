# Test en la Aplicación

## Índice
1. [Pruebas Unitarias con JUnit y Mockito](#1-pruebas-unitarias-con-junit-y-mockito)
2. [Pruebas de Interfaz con Espresso](#2-pruebas-de-interfaz-con-espresso)
3. [Pruebas de Rendimiento](#3-pruebas-de-rendimiento)
4. [Pruebas en Dispositivos Reales](#4-pruebas-en-dispositivos-reales)
5. [Documentar Errores Encontrados y Mejoras Aplicadas](#5-documentar-errores-encontrados-y-mejoras-aplicadas)
   
---

## **1. Pruebas Unitarias con JUnit y Mockito**

Las pruebas unitarias verifican la lógica del negocio sin depender de componentes externos como la interfaz de usuario o bases de datos.

### **Ejemplo: Prueba de la Clase `Tarjeta`**
La clase `Tarjeta` es simple, pero podemos escribir una prueba unitaria para asegurarnos de que el constructor y los métodos funcionen correctamente.

#### **Archivo: `TarjetaTest.kt`**
```kotlin
package com.example.palette

import org.junit.Assert.assertEquals
import org.junit.Test

class TarjetaTest {

    @Test
    fun testTarjetaCreation() {
        val tarjeta = Tarjeta(R.drawable.image1)
        assertEquals(R.drawable.image1, tarjeta.imagen)
    }
}
```

### **Ejemplo: Prueba del Adaptador `CardsAdapter`**
Podemos usar **Mockito** para simular las dependencias del adaptador y probar su comportamiento.

#### **Archivo: `CardsAdapterTest.kt`**
```kotlin
package com.example.palette

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class CardsAdapterTest {

    private lateinit var adapter: CardsAdapter
    private lateinit var mockItems: List<Tarjeta>
    private lateinit var mockOnClick: (ImageView, Tarjeta) -> Unit

    @Before
    fun setUp() {
        mockItems = listOf(Tarjeta(R.drawable.image1), Tarjeta(R.drawable.image2))
        mockOnClick = mock()
        adapter = CardsAdapter(mockItems, mockOnClick)
    }

    @Test
    fun testItemCount() {
        assertEquals(2, adapter.itemCount)
    }

    @Test
    fun testViewHolderBinding() {
        val mockView = mock(View::class.java)
        val mockImageView = mock(ImageView::class.java)
        `when`(mockView.findViewById<ImageView>(R.id.image1)).thenReturn(mockImageView)

        val viewHolder = adapter.onCreateViewHolder(mockView as ViewGroup, 0)
        adapter.onBindViewHolder(viewHolder, 0)

        verify(mockOnClick).invoke(mockImageView, mockItems[0])
    }
}
```

---

## **2. Pruebas de Interfaz con Espresso**

Espresso es una herramienta de Google para realizar pruebas de interfaz de usuario (UI). Puedes usarlo para verificar que los elementos de la interfaz respondan correctamente a las interacciones del usuario.

### **Ejemplo: Prueba de Transición Compartida**
Verifica que al hacer clic en una imagen en `MainActivity`, se inicie `PaletteActivity` con la transición compartida.

#### **Archivo: `MainActivityTest.kt`**
```kotlin
package com.example.palette

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testImageClickStartsPaletteActivity() {
        Intents.init()

        // Simular clic en la primera imagen
        onView(withId(R.id.recview))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        // Verificar que se inicia PaletteActivity con el extra correcto
        Intents.intended(hasExtra("imageRes", R.drawable.image1))

        Intents.release()
    }
}
```

---

## **3. Pruebas de Rendimiento**

El análisis del consumo de memoria y CPU es crucial para garantizar que tu aplicación funcione de manera eficiente.

### **Herramientas Recomendadas**
- **Android Profiler:** Herramienta integrada en Android Studio para analizar el uso de memoria, CPU y energía.
- **LeakCanary:** Biblioteca para detectar fugas de memoria.

#### **Pasos para Analizar el Rendimiento**
1. Abre **Android Profiler** en Android Studio.
2. Ejecuta la aplicación en un dispositivo físico o emulador.
3. Monitorea:
   - **Memoria:** Detecta fugas de memoria o uso excesivo.
   - **CPU:** Identifica cuellos de botella en el rendimiento.
   - **Red:** Evalúa el uso de datos si tu aplicación realiza solicitudes HTTP.

---

## **4. Pruebas en Dispositivos Reales**

Probar en dispositivos reales es esencial para evaluar la compatibilidad con diferentes tamaños de pantalla, versiones de Android y hardware.

### **Pasos para Probar en Dispositivos Reales**
1. Conecta un dispositivo físico mediante USB y habilita **Depuración USB**.
2. Ejecuta la aplicación desde Android Studio:
   ```bash
   adb install app/build/outputs/apk/release/app-release.apk
   ```
3. Prueba las siguientes áreas:
   - **Compatibilidad:** Asegúrate de que la aplicación funcione en diferentes versiones de Android (API 21+).
   - **Pantallas:** Verifica que la interfaz se ajuste correctamente en dispositivos pequeños, medianos y grandes.
   - **Hardware:** Prueba en dispositivos con diferentes capacidades (p. ej., cámaras, sensores).

---

## **5. Documentar Errores Encontrados y Mejoras Aplicadas**

### **Errores Encontrados**
1. **Error de Transición Compartida:**
   - **Descripción:** La transición compartida no funcionaba correctamente en algunos dispositivos.
   - **Causa:** Falta de configuración de `transitionName` en el XML.
   - **Solución:** Añadir `android:transitionName` en el archivo `activity_palette.xml`.

2. **Fuga de Memoria:**
   - **Descripción:** Se detectó una fuga de memoria al cargar imágenes grandes.
   - **Causa:** Uso incorrecto de `BitmapFactory`.
   - **Solución:** Implementar un sistema de caché para imágenes usando bibliotecas como Glide o Picasso.

3. **Compatibilidad con API 21:**
   - **Descripción:** Algunas funciones no eran compatibles con dispositivos antiguos.
   - **Causa:** Uso de APIs introducidas en versiones más recientes.
   - **Solución:** Usar `Build.VERSION.SDK_INT` para verificar la versión del sistema antes de ejecutar ciertas funciones.

### **Mejoras Aplicadas**
1. **Optimización de Imágenes:**
   - Implementado un sistema de carga diferida para imágenes usando Glide.
2. **Ofuscación de Código:**
   - Habilitado ProGuard para reducir el tamaño del APK y proteger el código.
3. **Pruebas Automatizadas:**
   - Añadido un conjunto completo de pruebas unitarias e instrumentadas para mejorar la calidad del código.

---
