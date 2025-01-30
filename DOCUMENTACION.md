
# Documentación del Proyecto

## 📌 Descripción
Este documento detalla la estructura del código del proyecto **CoffeeShop**, incluyendo las clases principales, su ubicación en el paquete y sus métodos esenciales.

---

## 📂 Paquete: `com.example.palette`

## Clases Principales

### 🏷️ `CardsAdapter`
- **Ubicación**: `com.example.palette`
- **Descripción**: Adaptador personalizado para `RecyclerView`, encargado de gestionar la lista de imágenes y manejar eventos de clic.
- **Métodos principales**:
  - `onCreateViewHolder(parent: ViewGroup, viewType: Int)`: Crea una nueva vista para un elemento de la lista.
  - `onBindViewHolder(holder: ViewHolder, position: Int)`: Asigna datos a la vista del elemento en la posición dada.
  - `getItemCount()`: Retorna el número total de elementos.

### 🏷️ `ViewHolder`
- **Ubicación**: Dentro de `CardsAdapter`
- **Descripción**: Contiene la referencia a la vista de cada elemento de la lista.
- **Métodos principales**:
  - `bind(tarjeta: Tarjeta, onClick: (ImageView, Tarjeta) -> Unit)`: Asigna datos y gestiona eventos de clic.

### 🏷️ `MainActivity`
- **Ubicación**: `com.example.palette`
- **Descripción**: Actividad principal que gestiona el `RecyclerView` y muestra la lista de tarjetas.
- **Métodos principales**:
  - `onCreate(savedInstanceState: Bundle?)`: Configura la interfaz y el RecyclerView.

### 🏷️ `PaletteActivity`
- **Ubicación**: `com.example.palette`
- **Descripción**: Actividad que recibe una imagen y genera una paleta de colores.
- **Métodos principales**:
  - `onCreate(savedInstanceState: Bundle?)`: Carga la imagen y extrae la paleta de colores.
  - `finish()`: Personaliza la animación de salida.

### 🏷️ `Tarjeta`
- **Ubicación**: `com.example.palette`
- **Descripción**: Representa una tarjeta con una imagen.
- **Atributos**:
  - `imagen: Int`: ID del recurso de la imagen.
