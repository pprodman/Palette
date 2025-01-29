
# Pruebas de Volumen y Estrés

## Objetivo
Evaluar el rendimiento y estabilidad de la aplicación al manejar grandes volúmenes de datos e interacciones intensivas.

## Casos de Prueba
1. **Carga Masiva de Imágenes en `RecyclerView`**
•	Escenario: Se agregan cientos de imágenes a la lista.
•	Prueba: 
o	Cargar 500+ imágenes en `RecyclerView`.
o	Medir tiempos de carga y fluidez de desplazamiento.
o	Verificar que no se producen bloqueos o cierres inesperados.
•	Resultado esperado: `RecyclerView` debe seguir respondiendo sin caídas de rendimiento.
2. **Múltiples Navegaciones entre Actividades**
•	Escenario: El usuario navega repetidamente entre `MainActivity` y `PaletteActivity`.
•	Prueba: 
o	Realizar 100+ transiciones entre actividades en una sesión.
o	Evaluar el uso de memoria y posibles fugas.
•	Resultado esperado: La aplicación debe seguir operativa sin ralentización o cierres forzados.
