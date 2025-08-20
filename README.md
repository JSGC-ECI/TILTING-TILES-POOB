# 📌 TILTING TILES

> ⚠️ Estado: ***EN DESARROLLO*** Versión académica

Simulador de tablero dinámico en el que las fichas se inclinan en distintas direcciones. El jugador debe reorganizar fichas sobre un tablero inclinándolas en distintas direcciones hasta alcanzar una configuración objetivo. El sistema combina la lógica de movimientos colectivos con la estrategia de planificación, ya que cada inclinación afecta a todas las fichas simultáneamente. Su diseño busca fortalecer habilidades de resolución de problemas, pensamiento lógico y toma de decisiones en un entorno lúdico y dinámico.

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

¡Excelente! 🚀 Aquí te preparo la **sección de Uso** para el proyecto **Tilting Tiles** con el mismo estilo que aplicamos en **POOBvsZOMBIES**:

---

## ▶️ Uso


```bash
# Desde la carpeta del proyecto
javac src/presentation/PuzzleGUI.java
java src/presentation/PuzzleGUI
```

> \[!NOTE]
> El proyecto implementa un rompecabezas interactivo donde el jugador debe **mover las fichas inclinando el tablero** hasta alcanzar la configuración objetivo.

> \[!TIP]
> Puedes correr el programa desde **IntelliJ IDEA**, **BlueJ** o cualquier IDE compatible con Java sin necesidad de compilar manualmente.

> \[!IMPORTANT]
> La clase principal para iniciar el juego es `PuzzleGUI`, ubicada en el paquete `presentation`.

> \[!WARNING]
> Si se eliminan o mueven las clases del paquete `domain`, la lógica de movimiento del tablero podría dejar de funcionar.

> \[!CAUTION]
> El programa admite tableros de distintos tamaños; asegúrate de no exceder los límites configurados para evitar errores de ejecución.

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
