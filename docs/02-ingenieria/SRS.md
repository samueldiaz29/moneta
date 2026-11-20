# Software Requirements Specification (SRS)

| Campo | Valor |
|---|---|
| Identificador | MON-DOC-005 |
| Versión | 1.0 |
| Estado | Especificación inicial |
| Referencias | PRD, Backlog, Project Proposal |

## 1. Propósito

Especificar los requisitos funcionales y no funcionales que debe cumplir el MVP de Moneta.

## 2. Alcance del sistema

Aplicación web responsive con frontend React/TypeScript, backend Java/Spring Boot y persistencia PostgreSQL. El usuario registra manualmente información financiera. No existe conexión bancaria ni ejecución de pagos.

## 3. Actores

- **Visitante:** puede consultar páginas públicas y registrarse.
- **Usuario autenticado:** administra exclusivamente sus propios datos.
- **Administrador técnico:** acceso operativo restringido para mantenimiento; no debe consultar datos financieros de usuarios salvo procedimiento autorizado y auditado.

## 4. Requisitos funcionales

### Autenticación

- **MON-FR-001:** El sistema debe permitir crear una cuenta con correo y contraseña.
- **MON-FR-002:** El correo debe ser único normalizado.
- **MON-FR-003:** El sistema debe permitir iniciar sesión.
- **MON-FR-004:** El sistema debe proteger rutas y endpoints privados.
- **MON-FR-005:** El sistema debe permitir cerrar sesión.
- **MON-FR-006:** El sistema no debe almacenar contraseñas en texto plano.

### Cuentas

- **MON-FR-010:** El usuario debe poder crear cuentas financieras.
- **MON-FR-011:** El usuario debe poder consultar sus cuentas.
- **MON-FR-012:** El usuario debe poder editar datos descriptivos.
- **MON-FR-013:** El usuario debe poder archivar una cuenta.
- **MON-FR-014:** El sistema debe impedir operaciones sobre cuentas de otro usuario.
- **MON-FR-015:** El sistema debe impedir nuevos movimientos en cuentas archivadas.

### Movimientos

- **MON-FR-020:** El usuario debe registrar ingresos.
- **MON-FR-021:** El usuario debe registrar gastos.
- **MON-FR-022:** El usuario debe registrar transferencias.
- **MON-FR-023:** El usuario debe consultar movimientos paginados.
- **MON-FR-024:** El usuario debe filtrar movimientos por rango de fechas, cuenta, tipo y categoría.
- **MON-FR-025:** El usuario debe editar movimientos propios.
- **MON-FR-026:** El usuario debe eliminar/anular movimientos propios.
- **MON-FR-027:** El sistema debe actualizar saldos de forma atómica.
- **MON-FR-028:** Las transferencias no deben contabilizarse como ingresos ni gastos.
- **MON-FR-029:** El sistema debe validar que importe sea mayor que cero.

### Categorías

- **MON-FR-030:** El sistema debe proporcionar categorías iniciales.
- **MON-FR-031:** El usuario debe crear categorías propias.
- **MON-FR-032:** El sistema debe validar el tipo de categoría.
- **MON-FR-033:** El usuario solo puede utilizar categorías disponibles para él.

### Dashboard

- **MON-FR-040:** El sistema debe mostrar saldos por moneda.
- **MON-FR-041:** El sistema debe mostrar ingresos y gastos de un periodo.
- **MON-FR-042:** El sistema debe mostrar distribución de gastos por categoría.
- **MON-FR-043:** El sistema debe excluir transferencias de métricas de ingreso y gasto.

### P1 — recurrentes, presupuestos y reportes

- **MON-FR-050:** El usuario podrá registrar compromisos recurrentes.
- **MON-FR-051:** El sistema mostrará próximos vencimientos.
- **MON-FR-052:** El usuario podrá crear presupuestos por categoría y periodo.
- **MON-FR-053:** El sistema calculará consumo y saldo restante del presupuesto.
- **MON-FR-054:** El sistema mostrará reportes básicos por categoría y periodo.

## 5. Requisitos no funcionales

- **MON-NFR-001 Seguridad:** todo endpoint privado debe autenticar al usuario.
- **MON-NFR-002 Autorización:** toda consulta o mutación de datos financieros debe validar propiedad en el servidor.
- **MON-NFR-003 Contraseñas:** utilizar algoritmo adaptativo moderno (por ejemplo, Argon2id o BCrypt con parámetros adecuados); nunca cifrado reversible ni texto plano.
- **MON-NFR-004 Transporte:** producción debe utilizar HTTPS.
- **MON-NFR-005 Secretos:** credenciales y claves deben estar fuera del repositorio.
- **MON-NFR-006 Integridad:** las operaciones que alteren más de un saldo o registro deben ejecutarse en una transacción de base de datos.
- **MON-NFR-007 Precisión:** los importes deben representarse con decimal exacto, nunca `float`/`double`.
- **MON-NFR-008 Rendimiento:** como objetivo inicial, endpoints comunes deben responder en menos de 1 segundo en entorno de prueba con carga pequeña; medir antes de optimizar.
- **MON-NFR-009 Usabilidad:** formularios deben mostrar errores junto al campo y estados de carga/vacío/error.
- **MON-NFR-010 Compatibilidad:** interfaz usable en navegadores modernos y pantallas móviles.
- **MON-NFR-011 Mantenibilidad:** separar presentación, lógica de aplicación y persistencia.
- **MON-NFR-012 Observabilidad:** registrar errores técnicos sin registrar contraseñas, tokens ni datos financieros innecesarios.
- **MON-NFR-013 Respaldo:** definir procedimiento de backup y restauración antes de producción pública.
- **MON-NFR-014 Privacidad:** recopilar únicamente datos necesarios y publicar política de privacidad antes de abrir el registro público.

## 6. Reglas de negocio

- **MON-RN-001:** importe > 0.
- **MON-RN-002:** cada cuenta tiene propietario y moneda.
- **MON-RN-003:** ingreso: saldo posterior = saldo anterior + importe.
- **MON-RN-004:** gasto: saldo posterior = saldo anterior - importe.
- **MON-RN-005:** transferencia: origen - importe; destino + importe.
- **MON-RN-006:** las transferencias no se incluyen en ingresos ni gastos.
- **MON-RN-007:** no se permiten transferencias entre cuentas de monedas distintas en el MVP.
- **MON-RN-008:** no se permite operar sobre cuenta archivada.
- **MON-RN-009:** todo recurso privado debe pertenecer al usuario autenticado.
- **MON-RN-010:** los totales de monedas distintas no se suman.
- **MON-RN-011:** el saldo inicial es independiente de los movimientos posteriores.
- **MON-RN-012:** edición/eliminación debe revertir el efecto anterior y aplicar el nuevo de forma atómica.

## 7. Validaciones de entrada

- Correo: formato válido y longitud limitada.
- Contraseña: política mínima definida en implementación y UX.
- Importe: decimal positivo con escala compatible con moneda.
- Fecha: fecha válida y rango permitido por producto.
- Nombre de cuenta/categoría: obligatorio y longitud limitada.
- Descripción: opcional y longitud limitada.
- Identificadores: formato UUID recomendado.

## 8. Errores y respuestas

Usar códigos HTTP coherentes:
- `400` datos inválidos.
- `401` no autenticado.
- `403` autenticado sin autorización.
- `404` recurso inexistente o no visible para el usuario.
- `409` conflicto, por ejemplo correo duplicado.
- `422` regla de negocio incumplida, si se adopta este estándar.
- `500` error inesperado sin detalles internos expuestos.

## 9. Trazabilidad

| Requisito | Historia |
|---|---|
| MON-FR-001 a 006 | MON-US-001, MON-US-002 |
| MON-FR-010 a 015 | MON-US-010, MON-US-011 |
| MON-FR-020 a 029 | MON-US-020 a MON-US-023 |
| MON-FR-030 a 033 | MON-US-030 |
| MON-FR-040 a 043 | MON-US-040, MON-US-041 |
| MON-FR-050 a 054 | MON-US-050, MON-US-051, MON-US-060, MON-US-070 |

## 10. Pendientes de especificación

- Política exacta de saldo negativo.
- Monedas admitidas y escalas decimales.
- Zona horaria configurable o fija.
- Política de eliminación y auditoría.
- Expiración/renovación de tokens.
- Confirmación y recuperación de correo/contraseña.
- Retención y eliminación de datos personales.
