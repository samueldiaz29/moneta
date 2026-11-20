# Product Requirements Document (PRD)

| Campo | Valor |
|---|---|
| Identificador | MON-DOC-002 |
| Producto | Moneta |
| Versión | 1.0 |
| Estado | Baseline propuesta — requiere revisión del Product Owner |
| Relacionado | MON-DOC-001 — Project Proposal |

## 1. Propósito

Definir qué problema aborda Moneta, para quién se construye, qué experiencia ofrecerá el MVP y cómo se medirá su utilidad. Este documento describe el producto; los detalles de implementación están en el SRS y los documentos de ingeniería.

## 2. Visión del producto

Moneta ayuda a personas a organizar sus finanzas personales en un solo lugar, registrando movimientos y compromisos para comprender mejor sus saldos, gastos y próximos pagos.

## 3. Problema e hipótesis

**Hipótesis del problema:** algunas personas llevan sus ingresos, gastos y pagos recurrentes en herramientas separadas, lo que dificulta conocer su situación financiera completa.

**Hipótesis de solución:** un registro manual centralizado, acompañado de resúmenes y recordatorios visuales, puede mejorar la organización financiera cotidiana.

Estas hipótesis no se consideran evidencia de mercado. Deben validarse con entrevistas y pruebas de uso.

## 4. Usuarios objetivo

### Segmento inicial

Personas jóvenes y adultas residentes en Perú que desean organizar sus finanzas personales y están dispuestas a registrar manualmente sus movimientos.

### Personas preliminares

- **Estudiante:** recibe ingresos ocasionales o una asignación y necesita controlar gastos pequeños.
- **Profesional dependiente:** recibe un ingreso periódico y desea controlar gastos, pagos y ahorro.
- **Independiente:** recibe ingresos variables y necesita registrar entradas y salidas.
- **Usuario con suscripciones:** quiere visualizar importe, periodicidad y próxima fecha de cobro.

Son arquetipos de trabajo, no perfiles investigados.

## 5. Objetivos del producto

1. Permitir registrar ingresos, gastos y transferencias.
2. Mantener saldos coherentes por cuenta.
3. Facilitar la clasificación de movimientos.
4. Mostrar un resumen financiero entendible.
5. Permitir registrar pagos recurrentes y suscripciones.
6. Dar al usuario control sobre sus propios datos.

## 6. No objetivos del MVP

- Conectar o leer cuentas bancarias.
- Ejecutar pagos, transferencias o débitos.
- Dar recomendaciones de inversión, crédito o asesoría financiera.
- Compartir cuentas entre varios usuarios.
- Aplicación móvil nativa.
- Inteligencia artificial financiera.
- Conversión automática de monedas.
- Contabilidad empresarial o facturación.

## 7. Alcance y prioridades

### P0 — núcleo obligatorio

- Registro, inicio de sesión y cierre de sesión.
- Perfil básico del usuario.
- Crear, consultar, editar y archivar cuentas.
- Categorías iniciales y categorías personalizadas.
- Registrar, consultar, editar y eliminar movimientos.
- Tipos de movimiento: ingreso, gasto y transferencia.
- Actualización consistente de saldos.
- Dashboard con saldo total, ingresos y gastos del periodo.
- Filtros por fecha, cuenta, tipo y categoría.
- Aislamiento estricto de datos por usuario.

### P1 — objetivo si P0 está estable

- Crear y administrar suscripciones/pagos recurrentes.
- Visualizar próximos vencimientos.
- Crear presupuestos por categoría y periodo mensual.
- Reporte de gastos por categoría y evolución mensual.

### P2 — diferible

- Metas de ahorro.
- Calendario consolidado.
- Exportación CSV.
- Funcionalidades Premium y pagos.

La prioridad puede cambiar tras investigación. No se debe sacrificar seguridad, integridad de saldos ni pruebas para incluir P1/P2.

## 8. Propuesta de valor

- **Centralización:** movimientos y cuentas en un solo lugar.
- **Visibilidad:** resumen de entradas, salidas y saldos.
- **Organización:** categorías y presupuestos.
- **Planificación:** pagos recurrentes y próximos compromisos.

La diferenciación de “dinero realmente disponible” queda como hipótesis. No debe mostrarse como saldo bancario ni como asesoramiento; cualquier cálculo futuro deberá explicar los compromisos incluidos y su fecha.

## 9. Experiencia principal

El usuario crea su cuenta, configura una cuenta financiera inicial, registra sus movimientos y consulta el dashboard. A partir de allí puede filtrar movimientos y administrar categorías. En P1 podrá registrar suscripciones y presupuestos.

## 10. Reglas de producto

1. Todo dato financiero pertenece a un único usuario propietario en el MVP.
2. Una cuenta archivada conserva su historial, pero no acepta nuevos movimientos.
3. Un movimiento de ingreso aumenta el saldo de su cuenta.
4. Un movimiento de gasto disminuye el saldo de su cuenta.
5. Una transferencia disminuye una cuenta origen y aumenta una cuenta destino por el mismo importe.
6. Una transferencia no se contabiliza como ingreso ni como gasto en los reportes.
7. El importe debe ser mayor que cero.
8. La moneda de una cuenta se define al crearla. No se permite cambiarla si ya tiene movimientos, salvo que se implemente un proceso explícito de conversión.
9. En la primera versión se recomienda una sola moneda por cuenta y moneda base PEN. La política multimoneda queda pendiente de decisión.
10. Los movimientos no deben borrarse silenciosamente si forman parte de un historial financiero; para el MVP se permite eliminación lógica o eliminación con auditoría técnica, según decisión registrada.
11. Las fechas se almacenan de forma consistente y se muestran en la zona horaria del usuario.
12. Las suscripciones son registros de compromisos; no realizan cobros automáticamente.

## 11. Métricas de éxito

Para una beta inicial:

- 10 usuarios invitados a probar el producto.
- Al menos 5 usuarios completan la activación: crean una cuenta y registran al menos tres movimientos.
- Al menos 5 participantes entregan retroalimentación.
- Medir usuarios activos semanales y retorno a 7/30 días cuando exista volumen suficiente.
- Registrar errores críticos y abandono en el flujo de alta.

Estas metas son objetivos de experimento, no pronósticos.

## 12. Criterios de aceptación del MVP

- Un usuario puede registrarse e iniciar sesión.
- Un usuario puede crear al menos una cuenta y consultar su saldo.
- Puede registrar ingresos, gastos y transferencias válidas.
- Los saldos se mantienen correctos al crear, editar y eliminar movimientos.
- El dashboard refleja los movimientos del usuario autenticado y del periodo seleccionado.
- Un usuario no puede consultar ni modificar datos de otro usuario, incluso manipulando identificadores.
- La interfaz informa errores de validación y estados vacíos.
- La aplicación funciona en resoluciones móviles y escritorio.
- Existe una guía para ejecutar el proyecto localmente.

## 13. Riesgos de producto

| Riesgo | Mitigación |
|---|---|
| El usuario no quiere registrar manualmente | Observar tareas reales en pruebas y simplificar el registro |
| El producto no se diferencia | Entrevistar usuarios y comparar alternativas |
| Demasiadas funciones para ocho semanas | Proteger P0 y posponer P1/P2 |
| Desconfianza por datos financieros | Explicar privacidad, minimizar datos y probar controles |
| Saldos incorrectos | Definir una única fuente de verdad y pruebas de invariantes |

## 14. Preguntas abiertas

- ¿La moneda base será PEN exclusivamente o habrá multimoneda desde el MVP?
- ¿El usuario podrá crear varias cuentas con monedas distintas?
- ¿Se requiere confirmación de correo?
- ¿Los movimientos se eliminan físicamente o se anulan/archivan?
- ¿Las recurrencias generan movimientos automáticamente o solo recordatorios?
- ¿Qué segmento será el primero en probar el producto?
- ¿Se incluirán presupuestos en la primera beta?

No resolver estas preguntas por intuición: documentar la decisión antes de implementar el comportamiento correspondiente.
