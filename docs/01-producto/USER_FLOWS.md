# User Flows — Moneta

| Campo | Valor |
|---|---|
| Identificador | MON-DOC-003 |
| Versión | 1.0 |
| Estado | Propuesta |

## 1. Registro y primera configuración

1. El visitante abre Moneta.
2. Selecciona crear cuenta.
3. Introduce nombre, correo y contraseña.
4. El sistema valida los datos y crea la cuenta.
5. El usuario inicia sesión si no se inicia automáticamente.
6. El sistema solicita crear su primera cuenta financiera.
7. El usuario introduce nombre, tipo, moneda y saldo inicial.
8. El sistema muestra el dashboard con estado vacío o saldo inicial.

**Errores:** correo duplicado, formato inválido, contraseña débil, datos incompletos o error de servidor.

## 2. Registrar un ingreso o gasto

1. El usuario selecciona “Nuevo movimiento”.
2. Selecciona ingreso o gasto.
3. Introduce importe, fecha, cuenta, categoría y descripción opcional.
4. El sistema valida importe, propiedad de la cuenta y categoría.
5. El usuario confirma.
6. El sistema registra el movimiento y actualiza el saldo de la cuenta.
7. El dashboard y el historial reflejan el cambio.

**Errores:** importe cero/negativo, cuenta archivada, cuenta de otro usuario, fecha inválida o categoría no disponible.

## 3. Registrar una transferencia

1. El usuario selecciona “Transferencia”.
2. Selecciona cuenta origen y cuenta destino.
3. Introduce importe, fecha y descripción opcional.
4. El sistema valida que ambas cuentas pertenezcan al usuario y sean distintas.
5. El sistema registra una operación de transferencia atómica.
6. Disminuye el saldo origen y aumenta el saldo destino.
7. La transferencia no incrementa ingresos ni gastos del dashboard.

**Restricción inicial:** transferencia entre cuentas de la misma moneda. Transferencias entre monedas distintas quedan fuera del MVP.

## 4. Consultar movimientos

1. El usuario abre el historial.
2. Define un rango de fechas o filtros.
3. El sistema devuelve solo sus movimientos.
4. El usuario abre un movimiento para ver el detalle.
5. Si tiene permiso, puede editarlo o eliminarlo.

## 5. Registrar una suscripción (P1)

1. El usuario abre Suscripciones.
2. Selecciona agregar.
3. Introduce nombre, importe, moneda, periodicidad, próxima fecha y cuenta asociada opcional.
4. El sistema guarda el compromiso.
5. El usuario visualiza la próxima fecha de cobro.

La suscripción no ejecuta un pago. La generación automática de movimientos debe definirse por separado.

## 6. Consultar dashboard

1. El usuario abre el dashboard.
2. El sistema obtiene cuentas activas y movimientos del usuario.
3. Calcula saldos y totales del periodo.
4. Muestra ingresos, gastos, saldo total y distribución por categoría.
5. El usuario cambia el periodo y el dashboard recalcula los indicadores.

## 7. Estados de interfaz requeridos

- Cargando.
- Sin datos / estado vacío.
- Datos disponibles.
- Error recuperable.
- Sesión expirada.
- Acción completada.
- Confirmación antes de acciones destructivas.
