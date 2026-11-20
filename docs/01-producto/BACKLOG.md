# Product Backlog — Moneta

| Campo | Valor |
|---|---|
| Identificador | MON-DOC-004 |
| Versión | 1.0 |
| Estado | Backlog inicial |

## Convenciones

- **P0:** imprescindible para el MVP.
- **P1:** importante; se implementa si P0 está estable.
- **P2:** posterior al MVP.
- Los puntos son estimaciones relativas iniciales y deben revisarse por el desarrollador.
- Una historia se considera terminada cuando cumple criterios, tiene pruebas, revisión de código y documentación actualizada.

## Épica E01 — Acceso y perfil

### MON-US-001 — Crear cuenta (P0)

Como visitante, quiero registrarme para tener un espacio privado donde administrar mis finanzas.

Criterios:
- Correo válido y único.
- Contraseña cumple política mínima.
- La contraseña nunca se almacena en texto plano.
- Errores de validación claros.
- No se revela información sensible.

### MON-US-002 — Iniciar y cerrar sesión (P0)

Como usuario registrado, quiero acceder y salir de mi cuenta.

Criterios:
- Credenciales válidas permiten acceso.
- Credenciales inválidas no permiten acceso.
- Endpoints privados requieren autenticación.
- Cerrar sesión invalida o elimina la sesión/token según el mecanismo elegido.

## Épica E02 — Cuentas

### MON-US-010 — Crear cuenta financiera (P0)

Como usuario, quiero crear cuentas para separar el dinero que administro.

Criterios:
- Nombre obligatorio.
- Tipo de cuenta seleccionado.
- Moneda válida.
- Saldo inicial no negativo, salvo que se apruebe explícitamente permitir sobregiro.
- La cuenta queda asociada al usuario autenticado.

### MON-US-011 — Consultar y actualizar cuenta (P0)

Como usuario, quiero consultar y modificar los datos descriptivos de mis cuentas.

Criterios:
- Solo el propietario puede consultar o modificar.
- Una cuenta con historial no puede cambiar de moneda.
- Archivar impide nuevos movimientos, pero conserva historial.

## Épica E03 — Movimientos

### MON-US-020 — Registrar ingreso (P0)

Como usuario, quiero registrar ingresos para mantener actualizado el saldo de una cuenta.

Criterios:
- Importe mayor que cero.
- Cuenta y categoría pertenecen al usuario.
- El saldo aumenta exactamente por el importe.
- Se guarda fecha, importe, descripción y referencias.

### MON-US-021 — Registrar gasto (P0)

Como usuario, quiero registrar gastos para conocer mis egresos.

Criterios:
- Importe mayor que cero.
- Cuenta y categoría pertenecen al usuario.
- El saldo disminuye exactamente por el importe.
- Se aplican las reglas de saldo negativo definidas por producto.

### MON-US-022 — Registrar transferencia (P0)

Como usuario, quiero mover dinero entre mis cuentas sin contabilizarlo como ingreso o gasto.

Criterios:
- Cuenta origen y destino distintas.
- Ambas pertenecen al usuario.
- Misma moneda.
- Operación atómica.
- Saldo origen disminuye y destino aumenta por el mismo importe.
- No afecta totales de ingresos/gastos.

### MON-US-023 — Editar o eliminar movimiento (P0)

Como usuario, quiero corregir un movimiento registrado incorrectamente.

Criterios:
- Solo el propietario puede modificarlo.
- Al editar, se revierte el efecto anterior y se aplica el nuevo dentro de una transacción de base de datos.
- Al eliminar, el saldo se recalcula correctamente.
- Se evita que una operación parcial deje saldos inconsistentes.

## Épica E04 — Categorías

### MON-US-030 — Administrar categorías (P0)

Como usuario, quiero clasificar movimientos para entender mis hábitos.

Criterios:
- Categorías iniciales disponibles.
- El usuario puede crear categorías propias.
- Tipo de categoría compatible con ingreso o gasto.
- No se permite utilizar categorías de otro usuario.
- Una categoría usada no se elimina físicamente sin tratar sus movimientos.

## Épica E05 — Dashboard e historial

### MON-US-040 — Consultar dashboard (P0)

Como usuario, quiero ver un resumen de mis finanzas.

Criterios:
- Muestra saldo total por moneda, sin sumar monedas distintas.
- Muestra ingresos y gastos del periodo.
- Transferencias excluidas de ingresos/gastos.
- Solo incluye datos del usuario autenticado.
- Periodo seleccionable.

### MON-US-041 — Filtrar movimientos (P0)

Como usuario, quiero filtrar mis movimientos por fecha, cuenta, tipo y categoría.

Criterios:
- Filtros combinables.
- Paginación.
- Orden por fecha descendente por defecto.
- El resultado nunca incluye movimientos ajenos.

## Épica E06 — Suscripciones y recurrencias

### MON-US-050 — Registrar suscripción (P1)

Como usuario, quiero registrar servicios recurrentes para recordar sus próximos cobros.

Criterios:
- Nombre, importe, periodicidad y próxima fecha obligatorios.
- Estado activo/inactivo.
- Se muestra el próximo vencimiento.
- No se realiza ningún cobro.

### MON-US-051 — Consultar próximos pagos (P1)

Como usuario, quiero visualizar compromisos próximos para anticipar gastos.

Criterios:
- Rango temporal definido.
- Solo compromisos activos.
- Fechas calculadas según periodicidad documentada.

## Épica E07 — Presupuestos

### MON-US-060 — Crear presupuesto mensual (P1)

Como usuario, quiero definir un límite de gasto por categoría.

Criterios:
- Categoría de gasto.
- Periodo mensual.
- Límite positivo.
- Consumo calculado a partir de gastos, excluyendo transferencias.
- Se muestra restante y porcentaje utilizado.

## Épica E08 — Reportes y ahorro

### MON-US-070 — Reporte de gastos por categoría (P1)

Como usuario, quiero identificar las categorías con mayor gasto.

Criterios:
- Rango de fechas.
- Totales coherentes con historial.
- Transferencias excluidas.
- Datos aislados por usuario.

### MON-US-080 — Meta de ahorro (P2)

Como usuario, quiero definir una meta y registrar aportes para seguir mi progreso.

Criterios:
- Nombre, importe objetivo y fecha objetivo opcional.
- Aportes positivos.
- Progreso no supera el objetivo visualmente; el excedente se informa por separado.

## Definition of Done

- Criterios de aceptación cumplidos.
- Pruebas unitarias y de integración relevantes.
- Validación de autorización y propiedad de datos.
- Manejo de errores.
- Revisión de código.
- Documentación actualizada.
- Sin secretos en el repositorio.
