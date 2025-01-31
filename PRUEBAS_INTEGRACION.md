
# 🧪 Pruebas de Integración

## Objetivo
Validar la correcta comunicación e interacción entre los diferentes componentes de la aplicación, asegurando que las actividades, adaptadores y transiciones funcionen sin errores.

## Casos de Prueba
### 1. Comunicación entre `MainActivity` y `PaletteActivity`
- **Escenario**: El usuario selecciona una imagen en `MainActivity` y se abre `PaletteActivity`.
- **Prueba**:
  - Seleccionar una imagen de la lista.
  - Verificar que la `PaletteActivity` recibe el `Intent` con la imagen correcta.
  - Validar que la imagen se muestra correctamente en `PaletteActivity`.
  - Asegurar que la transición compartida funciona sin fallos.
- **Resultado esperado**: `PaletteActivity` debe mostrar la imagen seleccionada sin errores y aplicar la paleta de colores correctamente.
```kotlin
@get:Rule
var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

@Test
fun testNavigationToPaletteActivity() {
    onView(withId(R.id.recview))
        .perform(RecyclerViewActions.actionOnItemAtPosition<CardsAdapter.ViewHolder>(0, click()))
    intended(hasComponent(PaletteActivity::class.java.name))
}
```

### 2. Integración de `RecyclerView` con `CardsAdapter`
- **Escenario**: `RecyclerView` debe mostrar todas las imágenes correctamente.
- **Prueba**:
  - Verificar que se crean todas las vistas necesarias en `RecyclerView`.
  - Asegurar que `onBindViewHolder()` asigna correctamente las imágenes.
  - Probar el evento `onClick` de cada imagen y su interacción con `PaletteActivity`.
- **Resultado esperado**: Todas las imágenes deben mostrarse correctamente y responder al clic sin errores.
```kotlin
@Test
fun testRecyclerViewDisplaysItems() {
    onView(withId(R.id.recview)).check(matches(isDisplayed()))
    onView(withId(R.id.recview)).check(matches(hasMinimumChildCount(1)))
}
```

### 3. Validación de `Palette` en `PaletteActivity`
- **Escenario**: `PaletteActivity` extrae los colores de la imagen seleccionada.
- **Prueba**:
  - Seleccionar diferentes imágenes y verificar que `Palette.from(bitmap).generate()` se ejecuta correctamente.
  - Validar que los colores extraídos se aplican a los elementos de la UI.
  - Comprobar que los valores nulos no causan fallos en la interfaz.
- **Resultado esperado**: `PaletteActivity` debe actualizar los colores de la interfaz sin errores.
```kotlin
@Test
fun testPaletteColorExtraction() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.image1)
    val palette = Palette.from(bitmap).generate()
    assertNotNull(palette)
}
```

### Herramientas Recomendadas
- Espresso para pruebas de UI.
- Mockito para pruebas unitarias de integración.
- Logcat para analizar errores en la comunicación entre actividades.
- Firebase Test Lab para probar en múltiples dispositivos.
