# Moneta — Documentación del proyecto

**Versión del paquete:** 1.0  
**Estado:** Baseline inicial para análisis y desarrollo  
**Idioma:** Español  
**Documento rector:** `PROJECT_PROPOSAL.md` (MON-DOC-001)

## Objetivo

Este repositorio contiene la documentación funcional, técnica y de gestión necesaria para construir el MVP de Moneta. La documentación traduce la propuesta del producto a decisiones implementables, pero no reemplaza la validación con usuarios.

## Estructura

```text
docs/
├── PROJECT_PROPOSAL.md                 # Documento existente del proyecto
├── README.md                           # Índice documental
├── 01-producto/
│   ├── PRD.md                          # Requisitos del producto
│   ├── USER_FLOWS.md                   # Flujos principales
│   └── BACKLOG.md                      # Historias priorizadas
├── 02-ingenieria/
│   ├── SRS.md                          # Especificación de requisitos
│   ├── ARCHITECTURE.md                 # Arquitectura propuesta
│   ├── DATA_MODEL.md                   # Modelo de dominio y datos
│   ├── API_CONTRACT.md                 # Contrato REST inicial
│   └── TEST_PLAN.md                    # Estrategia y casos de prueba
└── 03-gestion/
    ├── DELIVERY_PLAN.md                # Plan de entrega de ocho semanas
    └── DECISION_LOG.md                 # Decisiones y asuntos abiertos
```

## Orden recomendado de lectura

1. `PROJECT_PROPOSAL.md`
2. `01-producto/PRD.md`
3. `01-producto/USER_FLOWS.md`
4. `01-producto/BACKLOG.md`
5. `02-ingenieria/SRS.md`
6. `02-ingenieria/DATA_MODEL.md`
7. `02-ingenieria/ARCHITECTURE.md`
8. `02-ingenieria/API_CONTRACT.md`
9. `02-ingenieria/TEST_PLAN.md`
10. `03-gestion/DELIVERY_PLAN.md`
11. `03-gestion/DECISION_LOG.md`

## Convenciones

- **Definido:** decisión tomada para el MVP.
- **Supuesto:** decisión provisional para poder avanzar; debe confirmarse.
- **Pendiente:** requiere investigación o decisión del Product Owner.
- Los identificadores `MON-FR`, `MON-NFR`, `MON-US`, `MON-API` y `MON-DB` deben ser estables.
- Si una decisión cambia, actualizar los documentos afectados y registrar el cambio en `DECISION_LOG.md`.
- Los requisitos de este paquete son una baseline inicial. La aprobación del Project Proposal no implica que todas las hipótesis de negocio estén validadas.

## Baseline funcional propuesta

Para proteger el plazo de ocho semanas y el trabajo de un único desarrollador, el MVP se divide en:

- **P0 — imprescindible:** autenticación, cuentas, categorías, ingresos, egresos, transferencias, dashboard básico y aislamiento de datos.
- **P1 — si P0 está estable:** suscripciones/recurrentes, presupuestos y reportes básicos.
- **P2 — diferido si el plazo se compromete:** metas de ahorro, calendario avanzado y exportaciones.

Esta priorización concreta el alcance preliminar del Project Proposal. Si no se completa la validación de usuarios antes del desarrollo, el producto debe tratarse como una beta de aprendizaje.

## Cómo mantener la documentación

Actualizar la documentación en el mismo pull request que cambie comportamiento, reglas de negocio, contratos API o modelo de datos. No documentar como implementado algo que todavía sea una hipótesis.
