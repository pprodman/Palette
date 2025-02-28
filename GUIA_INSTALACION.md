
# Guía de Instalación para Desarrolladores

## Índice
1. [Requisitos Previos](#1-requisitos-previos)
2. [Pasos para Configurar el Proyecto](#2-pasos-para-configurar-el-proyecto)
3. [Resolución de Problemas Comunes](#3-resolución-de-problemas-comunes)
4. [Estructura del Proyecto](#4-estructura-del-proyecto)

## **1. Requisitos Previos**
Antes de comenzar, asegúrate de tener instaladas las siguientes herramientas y dependencias en tu sistema:

1. **Android Studio:**
   - Versión 2022.3.1 o superior.
   - Descarga desde [aquí](https://developer.android.com/studio).

2. **JDK (Java Development Kit):**
   - Versión 17 o superior.
   - Descarga desde [aquí](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).

3. **Gradle:**
   - Versión 8.0 o superior.
   - Gradle se configura automáticamente al abrir el proyecto en Android Studio.

4. **Dependencias del Proyecto:**
   - Asegúrate de que las siguientes bibliotecas estén disponibles en tu proyecto:
     ```groovy
     implementation 'androidx.recyclerview:recyclerview:1.3.1'
     implementation 'androidx.palette:palette-ktx:1.0.0'
     ```

5. **Dispositivo o Emulador Android:**
   - Un dispositivo físico con Android 5.0 (API 21) o superior.
   - O un emulador configurado en Android Studio.

---

## **2. Pasos para Configurar el Proyecto**

### **Paso 1: Clonar el Repositorio**
1. Abre una terminal y ejecuta el siguiente comando para clonar el repositorio:
   ```bash
   git clone https://github.com/tuusuario/palette.git
   ```
2. Navega al directorio del proyecto:
   ```bash
   cd palette
   ```

### **Paso 2: Abrir el Proyecto en Android Studio**
1. Abre Android Studio.
2. Selecciona **"Open an Existing Project"** (Abrir un proyecto existente).
3. Navega hasta el directorio donde clonaste el repositorio y selecciona la carpeta `palette`.

### **Paso 3: Configurar las Dependencias**
1. Abre el archivo `build.gradle` del módulo `app` y verifica que las dependencias necesarias estén incluidas:
   ```groovy
   dependencies {
       implementation 'androidx.recyclerview:recyclerview:1.3.1'
       implementation 'androidx.palette:palette-ktx:1.0.0'
   }
   ```
2. Si faltan dependencias, Android Studio mostrará una advertencia. Haz clic en **"Sync Now"** para sincronizar el proyecto.

### **Paso 4: Configurar Recursos de Imágenes**
1. Asegúrate de que las imágenes utilizadas en el proyecto (`R.drawable.image1`, `R.drawable.image2`, etc.) estén presentes en la carpeta `res/drawable`.
2. Si deseas agregar nuevas imágenes, colócalas en la carpeta `res/drawable` y actualiza la lista de tarjetas en `MainActivity.kt`:
   ```kotlin
   items.add(Tarjeta(R.drawable.nueva_imagen))
   ```

### **Paso 5: Configurar Transiciones Compartidas**
1. Verifica que los recursos de transición estén correctamente configurados en la carpeta `res/transition`.
2. Ejemplo de archivo `slide.xml` (si no existe, créalo):
   ```xml
   <slide xmlns:android="http://schemas.android.com/apk/res/android"
       android:duration="300"
       android:slideEdge="right" />
   ```

### **Paso 6: Compilar el Proyecto**
1. En Android Studio, haz clic en **Build > Make Project** para compilar el proyecto.
2. Si hay errores, revisa el panel de mensajes y corrige los problemas indicados.

### **Paso 7: Ejecutar la Aplicación**
1. Conecta un dispositivo físico o inicia un emulador desde **AVD Manager** en Android Studio.
2. Selecciona el dispositivo en la barra superior de Android Studio.
3. Haz clic en **Run > Run 'app'** para instalar y ejecutar la aplicación.

---

## **3. Resolución de Problemas Comunes**

### **1. Error de Sincronización de Gradle**
- **Causa:** Versión incorrecta de Gradle o dependencias faltantes.
- **Solución:**
  - Actualiza Gradle en el archivo `gradle-wrapper.properties`:
    ```properties
    distributionUrl=https\://services.gradle.org/distributions/gradle-8.0-bin.zip
    ```
  - Asegúrate de que todas las dependencias estén correctamente configuradas.

### **2. Imágenes Faltantes**
- **Causa:** Las imágenes referenciadas en el código no están en la carpeta `res/drawable`.
- **Solución:**
  - Agrega las imágenes necesarias a la carpeta `res/drawable`.
  - Actualiza las referencias en `MainActivity.kt`.

### **3. Transiciones Compartidas No Funcionan**
- **Causa:** Falta el nombre de la transición compartida o el archivo de animación.
- **Solución:**
  - Verifica que el nombre de la transición coincida en ambos archivos XML y Kotlin:
    ```kotlin
    imageView.transitionName = getString(R.string.tran_image)
    ```

---

## **4. Estructura del Proyecto**
Aquí tienes una descripción detallada de la estructura del proyecto para facilitar la navegación:

```
palette/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/palette/
│   │   │   │   ├── adapter/
│   │   │   │   │   ├── CardsAdapter.kt
│   │   │   │   ├── model/
│   │   │   │   │   ├── Tarjeta.kt
│   │   │   │   ├── ui/
│   │   │   │   │   ├── MainActivity.kt
│   │   │   │   │   ├── PaletteActivity.kt
│   │   │   ├── res/
│   │   │   │   ├── drawable/
│   │   │   │   │   ├── image1.png
│   │   │   │   │   ├── image2.png
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── activity_palette.xml
│   │   │   │   │   ├── item_cards.xml
│   │   │   │   ├── transition/
│   │   │   │   │   ├── slide.xml
│   │   │   │   ├── values/
│   │   │   │   │   ├── strings.xml
│   ├── build.gradle
├── build.gradle
├── settings.gradle
```

---
