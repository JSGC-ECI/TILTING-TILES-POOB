# 🧩 Tilting Tiles

SANTIAGO ROCHA DURAN y MARIA IRMA DIAZ ROZO
- LINA JANETH SANCHEZ FORERO <lina.sanchez@mail.escuelaing.edu.co>
- JUAN SEBASTIÁN GUAYAZÁN CLAVIJO <juan.guayazan-c@mail.escuelaing.edu.co>

Programación Orientada a Objetos (ISIS POOB - 2 LEC y POOB-201 LAB)   
Decanatura Ingeniería de Sistemas → Centro de Estudios de Ingeniería de Software    
Ingeniería de Sistemas e Ingeniería Estadística    
Escuela Colombiana de Ingeniería Julio Garavito    
2024-2

---

## 🎯 Descripción

Este proyecto es un simulador interactivo inspirado en el *Problem F – Tilting Tiles* de la Maratón ICPC 2023. 🧠 El propósito es construir un simulador extensible y visual que permita probar interacciones entre **baldosas** y **pegantes especiales** en un tablero dinámico.

📌 A lo largo de cinco ciclos, se desarrollaron nuevas funcionalidades, se refactorizó el sistema y se aplicaron herramientas de análisis de calidad, siempre bajo principios de **extensibilidad**, **funcionalidad** y **usabilidad**.

---

## ✨ Características principales

✅ Crear tableros personalizados  
🧱 Adicionar, reubicar y eliminar baldosas  
🧪 Aplicar y remover pegantes  
🎯 Ladear el tablero en cualquier dirección  
🔍 Consultar configuraciones, estados y restricciones  
🌀 Intercambiar vistas de edición y referencia  
🕳️ Agujerear celdas vacías  
📊 Resolver automáticamente el tablero  
📽️ Simular la solución paso a paso

### 🔸 Tipos de Baldosas
- Normal  
- Fixed 🧱 (no se mueven)  
- Rough 🪨 (no deslizan)  
- Freelance 🌀 (no se pegan)  
- Flying 🪽 (no caen)  
- 🔧 *Tipo personalizado propuesto*

### 🔹 Tipos de Pegantes
- Normal  
- Super 💥  
- Frágil 🧊

---

## 🗂️ Estructura del Proyecto

- 📦 `shapes`: jerarquía de clases base (herencia, reutilización)
- 📦 `puzzle`: lógica del simulador y comandos

---

## 🛠️ Requisitos Técnicos

- ☕ Java 8+
- 💻 Eclipse o BlueJ
- 🧪 JUnit (pruebas unitarias y de aceptación)
- 📊 PMD (análisis estático)
- 📈 Cobertura (análisis dinámico)

---

## ▶️ Instrucciones de Ejecución

```bash
git clone https://github.com/JuanSebastianGuayazanClavijoECI/TILTING-TILES-POOB.git
```

1. Abre el proyecto en **Eclipse** o **BlueJ**
2. Ejecuta las clases de prueba: `PuzzleTest`, `PuzzleC2Test`, `PuzzleContestTest`, `PuzzleAtest`
3. Corre las pruebas de aceptación simulando escenarios reales
4. Revisa los reportes de **PMD** y **Cobertura**

---

## ✅ Pruebas

🔬 Incluye:

- Pruebas unitarias `PuzzleCxTest`  
- Pruebas comunes `PuzzleCCxTest`  
- Pruebas de aceptación `PuzzleAtest` con interacción de usuario  

---

## 🔄 Retrospectiva del Proyecto

🧩 Cada ciclo incluye:

1. Mini-ciclos definidos y su justificación  
2. Estado actual del proyecto  
3. Horas dedicadas por cada integrante  
4. Logros destacados  
5. Principales problemas técnicos  
6. Buenas prácticas como equipo  
7. Práctica XP más útil aplicada

