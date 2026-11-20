# Test Plan — Moneta

| Campo | Valor |
|---|---|
| Identificador | MON-DOC-009 |
| Versión | 1.0 |
| Estado | Plan inicial |

## 1. Objetivo

Verificar que Moneta cumple requisitos funcionales, reglas financieras, seguridad y usabilidad básica antes de publicar una beta.

## 2. Niveles de prueba

### Unitarias

- Servicios de cálculo de saldos.
- Validaciones de importe, moneda y fechas.
- Reglas de transferencias.
- Cálculos del dashboard.
- Periodicidad de pagos recurrentes si entra en P1.

### Integración

- Repositorios con PostgreSQL.
- Transacciones de base de datos.
- Autenticación y autorización.
- Endpoints REST.
- Migraciones Flyway.

### Frontend

- Formularios y validaciones.
- Estados de carga, error y vacío.
- Filtros y paginación.
- Renderizado de importes y fechas.

### End-to-end

- Registro → crear cuenta → registrar ingreso → registrar gasto → consultar dashboard.
- Transferencia entre cuentas.
- Intento de acceder a recurso ajeno.
- Flujo de suscripción si P1 entra en alcance.

## 3. Casos de prueba prioritarios

| ID | Escenario | Resultado esperado |
|---|---|---|
| MON-TC-001 | Registrar usuario con correo válido | Cuenta creada |
| MON-TC-002 | Registrar correo duplicado | Conflicto controlado |
| MON-TC-003 | Login con credenciales incorrectas | Acceso denegado |
| MON-TC-004 | Crear cuenta con saldo inicial | Cuenta y saldo correctos |
| MON-TC-005 | Registrar ingreso positivo | Saldo aumenta |
| MON-TC-006 | Registrar gasto positivo | Saldo disminuye |
| MON-TC-007 | Registrar importe cero | Validación rechaza |
| MON-TC-008 | Transferir entre cuentas propias | Origen baja y destino sube |
| MON-TC-009 | Transferir a la misma cuenta | Validación rechaza |
| MON-TC-010 | Transferir entre monedas distintas | Validación rechaza |
| MON-TC-011 | Transferencia falla a mitad del proceso | Rollback completo |
| MON-TC-012 | Editar movimiento | Efecto anterior revertido y nuevo aplicado |
| MON-TC-013 | Eliminar/anular movimiento | Saldo corregido |
| MON-TC-014 | Consultar movimiento de otro usuario | Acceso denegado/no revelado |
| MON-TC-015 | Usar categoría de otro usuario | Operación rechazada |
| MON-TC-016 | Dashboard con transferencias | No suma transferencia como ingreso/gasto |
| MON-TC-017 | Dashboard con monedas distintas | Totales separados por moneda |
| MON-TC-018 | Cuenta archivada recibe movimiento | Operación rechazada |
| MON-TC-019 | Filtro de fechas | Solo devuelve rango solicitado |
| MON-TC-020 | Sesión expirada | Frontend solicita autenticación |

## 4. Invariantes financieras

Después de cada operación válida:

- El saldo calculado coincide con saldo inicial más movimientos.
- Una transferencia conserva el total entre cuentas de igual moneda.
- No se crean movimientos parciales.
- Ingreso y gasto afectan una sola cuenta.
- Transferencias no alteran el total global de dinero para la misma moneda.
- Editar o anular un movimiento produce el mismo resultado que reconstruir el ledger desde cero.

## 5. Seguridad

- Probar IDOR/BOLA: sustituir IDs por IDs de otro usuario.
- Probar endpoints sin autenticación.
- Probar manipulación de `userId`.
- Probar acceso a categorías, cuentas y movimientos ajenos.
- Verificar hash de contraseñas.
- Verificar ausencia de secretos en logs.
- Revisar CORS, CSRF y almacenamiento de tokens según la estrategia adoptada.
- Comprobar que mensajes de error no revelan stack traces.

## 6. Criterios de salida

- Todos los casos P0 aprobados.
- Cero defectos críticos o altos abiertos.
- Pruebas de aislamiento de datos aprobadas.
- Pruebas de integridad de saldos aprobadas.
- Migraciones ejecutadas en una base limpia.
- README permite ejecutar frontend y backend.
- Backup/restauración documentados antes de beta pública.

## 7. Datos de prueba

Usar datos ficticios. No cargar extractos bancarios ni datos financieros reales de terceros en entornos de prueba. Mantener fixtures reproducibles.
