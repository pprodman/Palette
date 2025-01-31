
# 🎭 Pruebas de Uso

## Objetivo
Evaluar la usabilidad y experiencia del usuario para garantizar una interacción fluida e intuitiva.

## Casos de Prueba
### 1. Fluidez en la Navegación
- **Prueba**:
  - Medir tiempos de respuesta al cambiar de pantalla.
  - Verificar que los elementos de la UI son accesibles y comprensibles.
- **Resultado esperado**: La navegación debe ser intuitiva y sin demoras.
```kotlin
@Test
fun testNavigationSpeed() {
    val startTime = System.currentTimeMillis()
    onView(withId(R.id.recview))
        .perform(RecyclerViewActions.actionOnItemAtPosition<CardsAdapter.ViewHolder>(0, click()))
    onView(withId(R.id.imageView)).check(matches(isDisplayed()))
    val endTime = System.currentTimeMillis()
    assertTrue(endTime - startTime < 2000)
}
```

### 2. Accesibilidad
- **Prueba**:
  - Evaluar compatibilidad con lectores de pantalla.
  - Comprobar contrastes y tamaños de texto.
- **Resultado esperado**: La aplicación debe ser accesible para todos los usuarios.
```kotlin
@Test
fun testAccessibility() {
    onView(withContentDescription("Imagen de muestra")).check(matches(isDisplayed()))
    onView(withId(R.id.textView)).check(matches(withTextSize(greaterThan(12f))))
}
```
