
# 🔄 Pruebas de Regresión

## Objetivo
Garantizar que los cambios en el código no afecten las funcionalidades previamente implementadas y que la aplicación siga funcionando correctamente después de cada actualización.

## Casos de Prueba
### 1. Revisión de la Navegación entre Actividades
- **Escenario**: El usuario navega entre `MainActivity` y `PaletteActivity`.
- **Prueba**:
  - Seleccionar varias imágenes en diferentes sesiones.
  - Verificar que la navegación sigue funcionando correctamente después de modificaciones.
  - Asegurar que la transición compartida no presenta fallos.
- **Resultado esperado**: La navegación entre actividades debe seguir operativa sin errores.
```kotlin
@Test
fun testActivityNavigationAfterChanges() {
    onView(withId(R.id.recview))
        .perform(RecyclerViewActions.actionOnItemAtPosition<CardsAdapter.ViewHolder>(1, click()))
    intended(hasComponent(PaletteActivity::class.java.name))
}
```
  
### 2. Comprobación del `RecyclerView` tras Cambios en el Adaptador
- **Escenario**: Se actualiza `CardsAdapter` con nuevas funciones o correcciones.
- **Prueba**:
  - Ejecutar `RecyclerView` y verificar que se cargan todas las imágenes.
  - Validar que la selección de imágenes sigue funcionando.
- **Resultado esperado**: `RecyclerView` debe seguir funcionando sin errores tras modificaciones en el adaptador.
```kotlin
@Test
fun testRecyclerViewAfterAdapterChanges() {
    onView(withId(R.id.recview)).check(matches(isDisplayed()))
    onView(withId(R.id.recview)).check(matches(hasMinimumChildCount(1)))
}
```

### 3. Validación de `Palette` después de Actualizaciones
- **Escenario**: Se realizan cambios en el procesamiento de la paleta de colores.
- **Prueba**:
  - Probar con múltiples imágenes antes y después de los cambios.
  - Comprobar que la extracción de colores sigue funcionando correctamente.
- **Resultado esperado**: `PaletteActivity` debe seguir mostrando los colores correctamente sin fallos.
```kotlin
@Test
fun testPaletteExtractionAfterUpdate() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.image2)
    val palette = Palette.from(bitmap).generate()
    assertNotNull(palette)
}
```

### 4. Pruebas Automáticas de UI
- **Escenario**: Se ejecutan pruebas automatizadas después de cada cambio en el código.
- **Prueba**:
  - Ejecutar pruebas con Espresso y UI Automator.
  - Validar que las interacciones siguen funcionando correctamente.
- **Resultado esperado**: Todas las pruebas automatizadas deben pasar sin errores.
```kotlin
@Test
fun testUIAutomatorChecks() {
    onView(withId(R.id.recview)).perform(RecyclerViewActions.scrollToPosition<CardsAdapter.ViewHolder>(5))
    onView(withId(R.id.recview)).perform(RecyclerViewActions.actionOnItemAtPosition<CardsAdapter.ViewHolder>(5, click()))
    intended(hasComponent(PaletteActivity::class.java.name))
}
```

### Herramientas Recomendadas
- Espresso para automatizar pruebas de UI.
- JUnit para pruebas unitarias.
- Firebase Test Lab para pruebas en múltiples dispositivos.
- Git Hooks para ejecutar pruebas antes de realizar commits.
