# Distribución del Proyecto

## **1. Configurar el Proyecto para Distribución**

### **a) Generar un APK y un AAB Firmado con una Clave de Desarrollador**

#### **Paso 1: Crear un Keystore**
El keystore es un archivo que contiene las claves para firmar tu aplicación. Si no tienes uno, puedes crearlo con el siguiente comando:

```bash
keytool -genkeypair -v -keystore my-release-key.jks -keyalg RSA -keysize 2048 -validity 10000 -alias my-key-alias
```

Guarda el archivo `.jks` en un lugar seguro.

#### **Paso 2: Configurar `build.gradle` para Firma Automática**
Abre el archivo `build.gradle` del módulo `app` y configura la firma automática:

```groovy
android {
    signingConfigs {
        release {
            storeFile file("ruta/al/my-release-key.jks") // Ruta al archivo .jks
            storePassword "tu_contraseña_keystore"
            keyAlias "my-key-alias"
            keyPassword "claveSegura"
        }
    }

    buildTypes {
        release {
            signingConfig signingConfigs.release
            minifyEnabled true // Habilita la ofuscación de código
            shrinkResources true // Elimina recursos no utilizados
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}
```

#### **Paso 3: Generar el APK y AAB**
1. **Generar un APK:**
   Ejecuta el siguiente comando en la terminal:
   ```bash
   ./gradlew assembleRelease
   ```
   El archivo APK generado estará en:
   ```
   app/build/outputs/apk/release/app-release.apk
   ```

2. **Generar un AAB (Android App Bundle):**
   Ejecuta el siguiente comando:
   ```bash
   ./gradlew bundleRelease
   ```
   El archivo AAB generado estará en:
   ```
   app/build/outputs/bundle/release/app-release.aab
   ```

---

### **b) Optimizar el Archivo `AndroidManifest.xml` para Producción**

El archivo `AndroidManifest.xml` debe estar optimizado para producción. Aquí hay algunos ajustes clave:

1. **Eliminar Permisos Innecesarios:**
   Asegúrate de que solo los permisos necesarios estén declarados. Por ejemplo, si no usas internet, elimina:
   ```xml
   <uses-permission android:name="android.permission.INTERNET" />
   ```

2. **Desactivar Logs en Producción:**
   Asegúrate de que el atributo `android:debuggable` esté configurado como `false`:
   ```xml
   <application
       android:debuggable="false"
       android:allowBackup="false"
       android:icon="@mipmap/ic_launcher"
       android:label="@string/app_name"
       android:roundIcon="@mipmap/ic_launcher_round"
       android:supportsRtl="true"
       android:theme="@style/Theme.Palette">
   </application>
   ```

3. **Configurar Orientaciones y Pantallas:**
   Especifica las orientaciones y densidades de pantalla compatibles:
   ```xml
   <supports-screens
       android:smallScreens="true"
       android:normalScreens="true"
       android:largeScreens="true"
       android:xlargeScreens="true" />
   ```

---

### **c) Configurar el Archivo `build.gradle` para Minimizar el Tamaño del APK**

Para reducir el tamaño del APK, sigue estos pasos:

1. **Habilitar Ofuscación y Compresión:**
   En el archivo `build.gradle`, asegúrate de que las siguientes opciones estén habilitadas:
   ```groovy
   buildTypes {
       release {
           minifyEnabled true
           shrinkResources true
           proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
       }
   }
   ```

2. **Usar Split APKs:**
   Divide el APK por arquitecturas de CPU para reducir el tamaño:
   ```groovy
   android {
       splits {
           abi {
               enable true
               reset()
               include "armeabi-v7a", "arm64-v8a", "x86", "x86_64"
               universalApk false
           }
       }
   }
   ```

3. **Optimizar Recursos:**
   Usa herramientas como [TinyPNG](https://tinypng.com/) para comprimir imágenes antes de agregarlas al proyecto.

---

## **2. Probar la Instalación del Paquete**

### **a) En un Emulador**
1. Abre Android Studio y selecciona **AVD Manager**.
2. Crea o inicia un dispositivo virtual.
3. Instala el APK generado usando el comando:
   ```bash
   adb install app/build/outputs/apk/release/app-release.apk
   ```
4. Verifica que la aplicación funcione correctamente.

### **b) En un Dispositivo Real**
1. Conecta un dispositivo físico al PC mediante USB.
2. Habilita la opción **Depuración USB** en el dispositivo.
3. Instala el APK usando el mismo comando:
   ```bash
   adb install app/build/outputs/apk/release/app-release.apk
   ```
4. Prueba todas las funcionalidades de la aplicación.

---

## **Resumen de Pasos**

1. **Firma:** Genera un APK y AAB firmados con un keystore.
2. **Optimización:** Configura `AndroidManifest.xml` y `build.gradle` para producción.
3. **Minimización:** Reduce el tamaño del APK con ofuscación, compresión y split APKs.
4. **Pruebas:** Instala y prueba el paquete en un emulador y un dispositivo real.

