
# Pruebas de Seguridad

## Objetivo
Identificar vulnerabilidades en la aplicación y asegurar que los datos y la navegación están protegidos contra ataques.

## Casos de Prueba
1. **Validación de Entrada de Datos**
•	Escenario: Intentos de inyección de código en `Intents` o datos de usuario.
•	Prueba: 
o	Probar envíos de datos maliciosos en los `Intents`.
o	Validar que los datos son correctamente sanitizados.
•	Resultado esperado: La aplicación debe rechazar entradas maliciosas.
