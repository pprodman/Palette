
# 📈 Pruebas de Volumen y Estrés

## Objetivo
Evaluar el rendimiento y estabilidad de la aplicación al manejar grandes volúmenes de datos e interacciones intensivas.

## Casos de Prueba
### 1. Carga Masiva de Imágenes en `RecyclerView`
- **Escenario**: Se agregan cientos de imágenes a la lista.
- **Prueba**:
  - Cargar 500+ imágenes en `RecyclerView`.
  - Medir tiempos de carga y fluidez de desplazamiento.
  - Verificar que no se producen bloqueos o cierres inesperados.
- **Resultado esperado**: `RecyclerView` debe seguir respondiendo sin caídas de rendimiento.
```kotlin
@Test
fun testRecyclerViewPerformance() {
    onView(withId(R.id.recview)).perform(RecyclerViewActions.scrollToPosition<CardsAdapter.ViewHolder>(499))
    onView(withId(R.id.recview)).check(matches(isDisplayed()))
}
```

### 2. Múltiples Navegaciones entre Actividades
- **Escenario**: El usuario navega repetidamente entre `MainActivity` y `PaletteActivity`.
- **Prueba**:
  - Realizar 100+ transiciones entre actividades en una sesión.
  - Evaluar el uso de memoria y posibles fugas.
- **Resultado esperado**: La aplicación debe seguir operativa sin ralentización o cierres forzados.
```kotlin
@Test
fun testRepeatedNavigation() {
    repeat(100) {
        onView(withId(R.id.recview))
            .perform(RecyclerViewActions.actionOnItemAtPosition<CardsAdapter.ViewHolder>(0, click()))
        pressBack()
    }
    onView(withId(R.id.recview)).check(matches(isDisplayed()))
}
```
