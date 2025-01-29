
# Pruebas de Integración

## Objetivo
Validar la correcta comunicación e interacción entre los diferentes componentes de la aplicación, asegurando que las actividades, adaptadores y transiciones funcionen sin errores.

## Casos de Prueba
1. **Comunicación entre `MainActivity` y `PaletteActivity`**
•	Escenario: El usuario selecciona una imagen en `MainActivity` y se abre `PaletteActivity`.
•	Prueba: 
o	Seleccionar una imagen de la lista.
o	Verificar que la `PaletteActivity` recibe el `Intent` con la imagen correcta.
o	Validar que la imagen se muestra correctamente en `PaletteActivity`.
o	Asegurar que la transición compartida funciona sin fallos.
•	Resultado esperado: `PaletteActivity` debe mostrar la imagen seleccionada sin errores y aplicar la paleta de colores correctamente.
2. **Integración de `RecyclerView` con `CardsAdapter`**
•	Escenario: `RecyclerView` debe mostrar todas las imágenes correctamente.
•	Prueba: 
o	Verificar que se crean todas las vistas necesarias en `RecyclerView`.
o	Asegurar que `onBindViewHolder()` asigna correctamente las imágenes.
o	Probar el evento `onClick` de cada imagen y su interacción con `PaletteActivity`.
•	Resultado esperado: Todas las imágenes deben mostrarse correctamente y responder al clic sin errores.
3. **Validación de `Palette` en `PaletteActivity`**
•	Escenario: `PaletteActivity` extrae los colores de la imagen seleccionada.
•	Prueba: 
o	Seleccionar diferentes imágenes y verificar que `Palette.from(bitmap).generate()` se ejecuta correctamente.
o	Validar que los colores extraídos se aplican a los elementos de la UI.
o	Comprobar que los valores nulos no causan fallos en la interfaz.
•	Resultado esperado: `PaletteActivity` debe actualizar los colores de la interfaz sin errores.
**Herramientas Recomendadas**
•	Espresso para pruebas de UI.
•	Mockito para pruebas unitarias de integración.
•	Logcat para analizar errores en la comunicación entre actividades.
•	Firebase Test Lab para probar en múltiples dispositivos.
