
# Pruebas de Regresión

## Objetivo
Garantizar que los cambios en el código no afecten las funcionalidades previamente implementadas y que la aplicación siga funcionando correctamente después de cada actualización.

## Casos de Prueba
1. **Revisión de la Navegación entre Actividades**
•	Escenario: El usuario navega entre `MainActivity` y `PaletteActivity`.
•	Prueba: 
o	Seleccionar varias imágenes en diferentes sesiones.
o	Verificar que la navegación sigue funcionando correctamente después de modificaciones.
o	Asegurar que la transición compartida no presenta fallos.
•	Resultado esperado: La navegación entre actividades debe seguir operativa sin errores.
2. **Comprobación del `RecyclerView` tras Cambios en el Adaptador**
•	Escenario: Se actualiza `CardsAdapter` con nuevas funciones o correcciones.
•	Prueba: 
o	Ejecutar `RecyclerView` y verificar que se cargan todas las imágenes.
o	Validar que la selección de imágenes sigue funcionando.
•	Resultado esperado: `RecyclerView` debe seguir funcionando sin errores tras modificaciones en el adaptador.
3. **Validación de `Palette` después de Actualizaciones**
•	Escenario: Se realizan cambios en el procesamiento de la paleta de colores.
•	Prueba: 
o	Probar con múltiples imágenes antes y después de los cambios.
o	Comprobar que la extracción de colores sigue funcionando correctamente.
•	Resultado esperado: `PaletteActivity` debe seguir mostrando los colores correctamente sin fallos.
4. **Pruebas Automáticas de UI**
•	Escenario: Se ejecutan pruebas automatizadas después de cada cambio en el código.
•	Prueba: 
o	Ejecutar pruebas con Espresso y UI Automator.
o	Validar que las interacciones siguen funcionando correctamente.
•	Resultado esperado: Todas las pruebas automatizadas deben pasar sin errores.
**Herramientas Recomendadas**
•	Espresso para automatizar pruebas de UI.
•	JUnit para pruebas unitarias.
•	Firebase Test Lab para pruebas en múltiples dispositivos.
•	Git Hooks para ejecutar pruebas antes de realizar commits.
