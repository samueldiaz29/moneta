# Decision Log — Moneta

| Campo | Valor |
|---|---|
| Identificador | MON-DOC-011 |
| Versión | 1.0 |
| Estado | Registro inicial |

## 1. Decisiones tomadas

| ID | Decisión | Motivo | Estado |
|---|---|---|---|
| MON-ADR-001 | Construir un MVP web antes de apps nativas | Limitar alcance y validar uso | Propuesta |
| MON-ADR-002 | Backend Java + Spring Boot | Stack definido en Project Proposal | Propuesta |
| MON-ADR-003 | Frontend React + TypeScript | Stack definido en Project Proposal | Propuesta |
| MON-ADR-004 | PostgreSQL como base de datos | Persistencia relacional y soporte transaccional | Propuesta |
| MON-ADR-005 | Monolito modular | Menor complejidad operativa para un equipo de una persona | Propuesta |
| MON-ADR-006 | No integrar bancos ni procesar pagos en MVP | Reducir riesgo, costo y alcance | Definida |
| MON-ADR-007 | Registros financieros manuales | Permite validar el flujo principal sin integraciones | Definida |
| MON-ADR-008 | Priorizar P0 sobre P1/P2 | Proteger plazo y calidad | Propuesta |

## 2. Decisiones bloqueantes antes de implementar

| ID | Tema | Opciones | Recomendación provisional |
|---|---|---|---|
| OPEN-001 | Monedas | PEN única / multimoneda | PEN para MVP; confirmar |
| OPEN-002 | Saldo negativo | Permitir / bloquear / advertir | Advertir o bloquear según tipo de cuenta; definir |
| OPEN-003 | Autenticación SPA | Cookie HttpOnly / bearer token | Evaluar cookie segura para SPA propia |
| OPEN-004 | Eliminación de movimientos | Física / lógica / anulación | Anulación o soft delete con historial |
| OPEN-005 | Recurrencias | Solo recordatorio / generar movimiento | Solo recordatorio en primera entrega |
| OPEN-006 | Categorías | Globales / por usuario / mixtas | Mixtas: sistema + personalizadas |
| OPEN-007 | Zona horaria | Fija / configurable | Guardar instantes UTC y mostrar zona definida por usuario |
| OPEN-008 | Confirmación de correo | Obligatoria / opcional | Decidir antes de beta pública |

## 3. Formato para nuevas decisiones

```text
ID:
Fecha:
Estado: Proposed / Accepted / Rejected / Superseded
Contexto:
Decisión:
Alternativas consideradas:
Consecuencias:
Documentos afectados:
Responsable:
```

## 4. Registro de cambios

| Versión | Fecha | Cambio |
|---|---|---|
| 1.0 | 2026-11-17 | Creación del paquete documental inicial |
