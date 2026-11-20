# Delivery Plan — Moneta MVP

| Campo | Valor |
|---|---|
| Identificador | MON-DOC-010 |
| Versión | 1.0 |
| Plazo objetivo | 8 semanas |
| Equipo | 1 desarrollador, apoyo de Product Manager |

## 1. Estrategia

Entregar un incremento funcional cada semana. Proteger primero integridad financiera y seguridad. El plan es una estimación para una persona; debe ajustarse tras revisar disponibilidad real y complejidad.

## 2. Fases

| Semana | Objetivo | Entregable |
|---|---|---|
| 1 | Cerrar decisiones, repositorio, setup, modelo inicial | Proyecto ejecutable y migración inicial |
| 2 | Registro, login y seguridad base | Flujo de acceso probado |
| 3 | Cuentas y categorías | CRUD y propiedad de recursos |
| 4 | Ingresos, gastos y transferencias | Ledger y saldos correctos |
| 5 | Historial, filtros y dashboard | Flujo financiero P0 |
| 6 | Pruebas, correcciones y UX responsive | P0 estable |
| 7 | P1: suscripciones y presupuestos si hay capacidad | Funciones P1 probadas |
| 8 | QA final, despliegue beta y feedback | MVP/beta publicado |

Si P0 no está estable al terminar semana 6, se pospone P1 y se usa semanas 7-8 para calidad, seguridad, documentación y beta.

## 3. Hitos

- **M0:** decisiones bloqueantes resueltas.
- **M1:** entorno local y pipeline básico.
- **M2:** autenticación funcional.
- **M3:** cuentas y categorías funcionales.
- **M4:** operaciones financieras consistentes.
- **M5:** dashboard e historial.
- **M6:** pruebas de seguridad y regresión.
- **M7:** beta privada desplegada.

## 4. Gestión del trabajo

- Mantener backlog priorizado.
- Elegir tareas pequeñas que puedan completarse en 1-2 días.
- Registrar bloqueos y decisiones.
- Revisar alcance semanalmente.
- No añadir funcionalidades sin retirar o posponer otra.
- Cada entrega debe cumplir Definition of Done.

## 5. Definition of Done

- Código compilable.
- Validaciones implementadas.
- Pruebas pertinentes aprobadas.
- Reglas de autorización probadas.
- Sin errores críticos conocidos.
- Documentación actualizada.
- Cambios versionados en Git.
- Variables de entorno y secretos correctamente gestionados.

## 6. Riesgos del cronograma

- Un solo desarrollador limita trabajo paralelo.
- Autenticación y seguridad pueden requerir más tiempo.
- El hosting gratuito puede presentar restricciones.
- Requisitos no validados pueden generar retrabajo.

## 7. Plan de contingencia

Si hay retraso:
1. Congelar nuevas funcionalidades.
2. Priorizar P0.
3. Eliminar P2 del release.
4. Posponer P1.
5. Mantener pruebas, seguridad y documentación.
6. Reducir el alcance, no la calidad de datos financieros.

## 8. Criterio de lanzamiento

Lanzar primero como beta privada con usuarios invitados. No abrir registro público hasta tener aislamiento de datos probado, política de privacidad, procedimiento de respaldo y canal para reportar errores.
