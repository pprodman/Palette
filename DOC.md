
---

# **Documentación Técnica de la Aplicación**

## Índice
1. [Descripción del Proyecto](#1.descripción-del-proyecto)
2. [Arquitectura utilizada](#arquitectura-utilizada)
3. [Diagrama de Clases y Estructura del Código](#diagrama-de-clases-y-estructura-del-código)
4. [Explicación de la Interfaz y Adaptación a Diferentes Pantallas](#explicación-de-la-interfaz-y-adaptación-a-diferentes-pantallas)
5. [Guía de Instalación para Otros Desarrolladores](#guía-de-instalación-para-otros-desarrolladores)
6. [Changelog con Mejoras y Versiones](#changelog-con-mejoras-y-versiones)

## **1. Descripción del Proyecto**

### **Objetivo**
La aplicación **Palette** tiene como objetivo principal explorar imágenes y generar paletas de colores dinámicas a partir de ellas. Esta herramienta es útil para diseñadores, desarrolladores y cualquier persona interesada en extraer colores de imágenes para su uso en proyectos visuales.

### **Funcionalidades Principales**
1. **Visualización de Imágenes:**
   - Los usuarios pueden navegar por una lista de imágenes en un `RecyclerView`.
   - Cada imagen se muestra en forma de tarjeta con una vista previa.

2. **Generación de Paletas de Colores:**
   - Al seleccionar una imagen, la aplicación genera una paleta de colores utilizando la biblioteca **Android Palette API**.
   - Los colores generados incluyen tonos vibrantes, oscuros, claros y apagados.

3. **Transiciones Compartidas:**
   - La aplicación implementa transiciones compartidas para mejorar la experiencia visual al navegar entre actividades.

4. **Interfaz Personalizada:**
   - La interfaz utiliza elementos modernos como `Toolbar` y animaciones de entrada/salida.

---

## **2. Arquitectura Utilizada**

### **Patrón MVVM (Model-View-ViewModel)**
El proyecto sigue el patrón **MVVM** para separar la lógica de negocio de la interfaz de usuario. Esto permite un código modular, escalable y fácil de mantener.

#### **Componentes del Patrón MVVM**
1. **Model:**
   - Representa los datos y la lógica de negocio.
   - Ejemplo: Clase `Tarjeta` que encapsula la información de las imágenes.

2. **View:**
   - Es la capa de la interfaz de usuario.
   - Ejemplo: Actividades (`MainActivity`, `PaletteActivity`) y adaptadores (`CardsAdapter`) que muestran los datos al usuario.

3. **ViewModel:**
   - No se ha implementado explícitamente un `ViewModel` en este proyecto, pero podría extenderse para manejar la lógica de generación de paletas en futuras versiones.

---

## **3. Diagrama de Clases y Estructura del Código**

### **Diagrama de Clases**
```plaintext
+-------------------+        +-------------------+
|     Tarjeta       |        |  CardsAdapter     |
+-------------------+        +-------------------+
| - imagen: Int     |<------>| - items: List<Tarjeta> |
+-------------------+        | - onClick: Function |
                             +-------------------+

+-------------------+        +-------------------+
|  MainActivity     |        |  PaletteActivity  |
+-------------------+        +-------------------+
| - RecyclerView    |        | - Toolbar         |
| - Toolbar         |        | - ImageView       |
| - Transitions     |        | - Palette Colors  |
+-------------------+        +-------------------+
```

### **Estructura del Código**
El proyecto sigue una estructura organizada basada en paquetes:
```
com.example.palette/
├── adapter/                # Adaptadores para RecyclerView
│   ├── CardsAdapter.kt
├── model/                  # Modelos de datos
│   ├── Tarjeta.kt
├── ui/                     # Interfaz de usuario (Activities)
│   ├── MainActivity.kt
│   ├── PaletteActivity.kt
├── utils/                  # Utilidades generales (si se añaden)
│   ├── Extensions.kt
```

---

## **4. Explicación de la Interfaz y Adaptación a Diferentes Pantallas**

### **Interfaz de Usuario**
La interfaz está diseñada siguiendo los principios de **Material Design** para garantizar una experiencia visual consistente y atractiva.

#### **Elementos Principales**
1. **Lista de Imágenes (`MainActivity`):**
   - Usa un `RecyclerView` para mostrar una lista dinámica de imágenes.
   - Cada elemento incluye una vista previa de la imagen.

2. **Detalles de la Imagen (`PaletteActivity`):**
   - Muestra la imagen seleccionada junto con una paleta de colores generada.
   - Los colores se aplican a diferentes elementos de la interfaz, como la barra de herramientas (`Toolbar`) y etiquetas de texto.

3. **Transiciones Compartidas:**
   - Las transiciones compartidas mejoran la experiencia visual al navegar entre actividades.

### **Adaptación a Diferentes Pantallas**
1. **Diseño Responsivo:**
   - Se usan `ConstraintLayout` y `LinearLayout` para garantizar que la interfaz se ajuste automáticamente a diferentes tamaños de pantalla.
   - Ejemplo: En tablets, la lista de imágenes y los detalles pueden mostrarse en paneles laterales.

2. **Compatibilidad con Orientaciones:**
   - Layouts específicos para orientación vertical y horizontal (`res/layout` y `res/layout-land`).

3. **Escalabilidad de Textos e Imágenes:**
   - Se utilizan dimensiones escalables (`sp` para texto y `dp` para imágenes) para adaptarse a diferentes densidades de pantalla.

---

## **5. Guía de Instalación para Otros Desarrolladores**

- [Guia de instalación](./GUIA_INSTALACION.md) 📖: Proporciona instrucciones detalladas sobre cómo instalar la aplicación.


---

## **6. Changelog con Mejoras y Versiones**

### **Versión 1.0.0**
- **Fecha:** [Fecha de lanzamiento]
- **Descripción:**
  - Versión inicial de la aplicación.
  - Funcionalidades principales implementadas: lista de imágenes, generación de paletas y transiciones compartidas.

### **Versión 1.1.0**
- **Fecha:** [Fecha de actualización]
- **Mejoras:**
  - Optimización del rendimiento en dispositivos de baja gama.
  - Corrección de errores menores en la interfaz.

### **Versión 1.2.0**
- **Fecha:** [Fecha de actualización]
- **Mejoras:**
  - Implementación de Material You para diseño dinámico.
  - Soporte para tablets y pantallas grandes.
  - Mejoras en la accesibilidad (compatibilidad con TalkBack).

---

### **Conclusión**
Esta documentación proporciona una visión completa de la aplicación **Palette**, desde su arquitectura hasta su instalación y mantenimiento. Si necesitas más detalles o tienes preguntas adicionales, no dudes en contactarme. ¡Gracias por revisar esta documentación! 🚀
