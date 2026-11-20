# API Contract — Moneta

| Campo | Valor |
|---|---|
| Identificador | MON-DOC-008 |
| Versión | 1.0 |
| Estado | Contrato REST propuesto |
| Base path | `/api/v1` |

## 1. Convenciones

- JSON en request/response.
- UUID para identificadores.
- Fechas ISO 8601.
- Importes enviados como string decimal para evitar pérdida de precisión en JavaScript.
- Paginación: `page`, `size`, `sort`.
- La identidad del propietario se obtiene del contexto autenticado, nunca de un `userId` confiado al cliente.
- Los ejemplos son ilustrativos; ajustar nombres finales al implementar.

## 2. Autenticación

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/auth/register` | Registrar usuario |
| POST | `/auth/login` | Iniciar sesión |
| POST | `/auth/logout` | Cerrar sesión |
| GET | `/users/me` | Perfil del usuario autenticado |

La forma exacta de transportar la sesión/token depende de la decisión de seguridad. No exponer tokens en logs.

## 3. Cuentas

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/accounts` | Crear cuenta |
| GET | `/accounts` | Listar cuentas propias |
| GET | `/accounts/{accountId}` | Obtener cuenta propia |
| PATCH | `/accounts/{accountId}` | Actualizar datos descriptivos |
| POST | `/accounts/{accountId}/archive` | Archivar cuenta |

Ejemplo de creación:

```json
{
  "name": "Cuenta principal",
  "accountType": "BANK",
  "currencyCode": "PEN",
  "openingBalance": "1500.00"
}
```

## 4. Categorías

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/categories` | Listar categorías disponibles |
| POST | `/categories` | Crear categoría propia |
| PATCH | `/categories/{categoryId}` | Editar categoría propia |
| DELETE | `/categories/{categoryId}` | Desactivar/eliminar si no rompe historial |

Ejemplo:

```json
{
  "name": "Alimentación",
  "categoryType": "EXPENSE"
}
```

## 5. Movimientos

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/transactions` | Crear ingreso o gasto |
| GET | `/transactions` | Listar con filtros y paginación |
| GET | `/transactions/{transactionId}` | Obtener movimiento propio |
| PATCH | `/transactions/{transactionId}` | Editar movimiento propio |
| DELETE | `/transactions/{transactionId}` | Anular/eliminar según política |

Ejemplo de gasto:

```json
{
  "transactionType": "EXPENSE",
  "accountId": "00000000-0000-0000-0000-000000000001",
  "categoryId": "00000000-0000-0000-0000-000000000002",
  "amount": "45.90",
  "currencyCode": "PEN",
  "occurredAt": "2026-11-17T13:30:00-05:00",
  "description": "Almuerzo"
}
```

Filtros:
- `from`
- `to`
- `accountId`
- `categoryId`
- `transactionType`
- `page`
- `size`
- `sort`

## 6. Transferencias

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/transfers` | Crear transferencia |
| GET | `/transfers` | Listar transferencias |
| GET | `/transfers/{transferId}` | Obtener transferencia |
| PATCH | `/transfers/{transferId}` | Editar transferencia |
| DELETE | `/transfers/{transferId}` | Anular transferencia |

Ejemplo:

```json
{
  "sourceAccountId": "00000000-0000-0000-0000-000000000001",
  "destinationAccountId": "00000000-0000-0000-0000-000000000002",
  "amount": "100.00",
  "currencyCode": "PEN",
  "occurredAt": "2026-11-17T14:00:00-05:00",
  "description": "Mover a ahorros"
}
```

## 7. Dashboard

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/dashboard/summary` | Resumen financiero por periodo |
| GET | `/dashboard/expenses-by-category` | Gastos agrupados por categoría |
| GET | `/dashboard/cash-flow` | Ingresos y gastos por intervalo |

Parámetros recomendados: `from`, `to`, `currencyCode`. El backend no debe sumar monedas diferentes.

## 8. P1 — recurrentes y presupuestos

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/recurring-payments` | Crear compromiso recurrente |
| GET | `/recurring-payments` | Listar compromisos |
| PATCH | `/recurring-payments/{id}` | Actualizar compromiso |
| POST | `/recurring-payments/{id}/pause` | Pausar |
| POST | `/recurring-payments/{id}/cancel` | Cancelar |
| GET | `/recurring-payments/upcoming` | Próximos vencimientos |
| POST | `/budgets` | Crear presupuesto |
| GET | `/budgets` | Listar presupuestos |
| PATCH | `/budgets/{id}` | Actualizar presupuesto |
| GET | `/budgets/{id}/progress` | Consultar progreso |

## 9. Formato de error

```json
{
  "timestamp": "2026-11-17T15:00:00Z",
  "status": 400,
  "code": "VALIDATION_ERROR",
  "message": "La solicitud contiene datos inválidos.",
  "fieldErrors": {
    "amount": "Debe ser mayor que cero."
  },
  "traceId": "correlation-id"
}
```

No devolver stack traces ni información interna al cliente.

## 10. Seguridad obligatoria

- Validar autenticación y propiedad en cada endpoint privado.
- Responder `404` cuando sea conveniente no revelar la existencia de un recurso ajeno.
- Validar IDs relacionados dentro del mismo usuario.
- Usar transacciones para crear/editar transferencias y movimientos.
- Aplicar límites de tamaño y validación de payload.
- No aceptar `userId` como autoridad del propietario.
- Añadir pruebas de acceso cruzado entre usuarios.

## 11. Pendientes

- Definir esquema de sesión/token.
- Definir envelope de paginación.
- Definir política de idempotencia para operaciones de creación.
- Definir formato final de fechas y zona horaria.
- Generar OpenAPI/Swagger desde la implementación.
