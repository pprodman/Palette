
# 🔒 Pruebas de Seguridad

## Objetivo
Identificar vulnerabilidades en la aplicación y asegurar que los datos y la navegación están protegidos contra ataques.

## Casos de Prueba
### 1. Validación de Entrada de Datos
- Escenario: Intentos de inyección de código en `Intents` o datos de usuario.
- Prueba: 
  - Probar envíos de datos maliciosos en los `Intents`.
  - Validar que los datos son correctamente sanitizados.
- Resultado esperado: La aplicación debe rechazar entradas maliciosas.
@Test
fun testIntentDataSanitization() {
    val intent = Intent(ApplicationProvider.getApplicationContext(), PaletteActivity::class.java)
    intent.putExtra("image_url", "<script>alert('XSS')</script>")
    val scenario = ActivityScenario.launch<PaletteActivity>(intent)
    scenario.onActivity { activity ->
        val imageUrl = activity.intent.getStringExtra("image_url")
        assertFalse(imageUrl!!.contains("<script>"))
    }
}
```
