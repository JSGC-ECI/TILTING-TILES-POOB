# 📌 TILTING TILES

> ⚠️ Estado: ***EN DESARROLLO*** Versión académica

Simulador de tablero dinámico en el que las fichas se inclinan en distintas direcciones. Este proyecto busca aplicar principios de orientación a objetos, modelado de estados y movimientos en una matriz interactiva y lógica.

---

## 👥 Autores

SANTIAGO ROCHA DURAN y MARIA IRMA DIAZ ROZO
- LINA JANETH SANCHEZ FORERO → [lina.sanchez@mail.escuelaing.edu.co](mailto:lina.sanchez@mail.escuelaing.edu.co)
- [JUAN SEBASTIÁN GUAYAZÁN CLAVIJO](https://github.com/JSGC-ECI) → [juan.guayazan-c@mail.escuelaing.edu.co](mailto:juan.guayazan-c@mail.escuelaing.edu.co)

Programación Orientada a Objetos (ISIS POOB - 2 LEC y POOB-201 LAB)   
Decanatura Ingeniería de Sistemas → Centro de Estudios de Ingeniería de Software    
Ingeniería de Sistemas e Ingeniería Estadística    
Escuela Colombiana de Ingeniería Julio Garavito    
2024-2


Ingeniería de Sistemas e Ingeniería Estadística
Escuela Colombiana de Ingeniería Julio Garavito
2025-

---

## 🧠 Índice

* 📌 [Nombre del Proyecto](#-tilting-tiles)
* 🚀 [Características](#-características)
* ⚙️ [Tecnologías](#️-tecnologías)
* 📦 [Instalación](#-instalación-y-requisitos)
* ▶️ [Uso](#️-uso)
* 🧪 [Pruebas](#-pruebas)
* 📁 [Estructura del Proyecto](#-estructura-del-proyecto)
* 📌 [TODOs / Funcionalidades Futuras](#-todos--funcionalidades-futuras)
* 👥 [Autores](#-autores)
* 📄 [Licencia](#-licencia)

---

## 🚀 Características

* ✅ Simulación visual de inclinación de fichas en cuatro direcciones
* ✅ Soporte para fichas pegadas y restricciones de movimiento
* ✅ Estados dinámicos del tablero y evolución paso a paso
* ✅ Proyecto educativo con propósito práctico y modular
* ✅ Compatible con BlueJ, Eclipse o cualquier IDE Java

---

## ⚙️ Tecnologías

* Lenguaje(s): `Java`
* Herramientas: `BlueJ`, `JUnit`, `Java AWT`, `Swing`
* Dependencias: `JUnit 4.13.2`, `Hamcrest 1.3` (para pruebas unitarias)

---

## 📦 Instalación y Requisitos

### Clonar el repositorio

```bash
git clone https://github.com/JuanSebastianGuayazanClavijoECI/TILTING-TILES-POOB
```

### Requisitos

* Java 8 o superior
* BlueJ o Eclipse
* JUnit 4 (para pruebas)

### Instalación

1. Abrir el proyecto en BlueJ o importar como proyecto en Eclipse
2. Compilar los archivos `.java` en `src/`
3. Ejecutar desde la clase principal o interfaz si está disponible

---

## ▶️ Uso

> \[!NOTE]
> El tablero puede inclinarse hacia cualquier dirección usando comandos o botones (según la implementación final).

> \[!TIP]
> Puedes modificar los tableros de prueba o crear los tuyos en la clase `Puzzle`.

También puedes incluir:

* Capturas de pantalla del tablero antes y después de mover
* GIFs o vídeos con desplazamientos visuales
* Tableros configurables como entrada

---

## 🧪 Pruebas

Ejecuta las pruebas unitarias con JUnit desde consola o IDE:

```bash
# Si usas JUnit 4
java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore PuzzleTest
```

---

## 📁 Estructura del Proyecto

```bash
📦 TILTING-TILES-POOB
├── 📂 src/
│   ├── 📜 Puzzle.java
│   ├── 📜 Cell.java
│   ├── 📜 Tile.java
│   └── 📜 Main.java
├── 📂 test/
│   └── 📜 PuzzleTest.java
├── 📜 README.md
├── 📜 .gitignore
└── 📜 LICENSE
```

---

## 📌 TODOs / Funcionalidades Futuras

* [ ] Implementar GUI con JavaFX o Swing
* [ ] Añadir diferentes tipos de fichas (bloques, obstáculos, bonos)
* [ ] Cargar tableros desde archivos externos
* [ ] Modo competitivo y modo sandbox

---

## 📊 Estadísticas del Repositorio

![Lenguaje principal](https://img.shields.io/github/languages/top/JuanSebastianGuayazanClavijoECI/TILTING-TILES-POOB?style=flat-square)
![Tamaño del repositorio](https://img.shields.io/github/repo-size/JuanSebastianGuayazanClavijoECI/TILTING-TILES-POOB?style=flat-square)
![Stars](https://img.shields.io/github/stars/JuanSebastianGuayazanClavijoECI/TILTING-TILES-POOB?style=flat-square)
![Forks](https://img.shields.io/github/forks/JuanSebastianGuayazanClavijoECI/TILTING-TILES-POOB?style=flat-square)
![Issues abiertas](https://img.shields.io/github/issues/JuanSebastianGuayazanClavijoECI/TILTING-TILES-POOB?style=flat-square)

---

## 📄 Licencia

Este proyecto está licenciado bajo propósitos académicos y educativos. Puedes consultar el archivo [LICENSE](./LICENSE) para más información.

---
