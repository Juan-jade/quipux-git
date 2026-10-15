# Sistema de Gestión Académica – UCO

Programa en Java (consola) que registra un profesor y un estudiante de la
**Universidad Católica de Oriente**, permite que el profesor ingrese las notas
del estudiante y muestra el promedio y el estado académico.

## Cómo compilar y ejecutar

```bash
mkdir -p out
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

## Estructura

| Archivo | Qué hace |
|---|---|
| `src/Persona.java` | Clase abstracta con nombre y cédula (abstracción + encapsulamiento) |
| `src/Estudiante.java` | Hereda de Persona; guarda carrera y notas, calcula promedio |
| `src/Profesor.java` | Hereda de Persona; ingresa notas a un estudiante |
| `src/Main.java` | Punto de entrada: pide los datos y muestra el resumen |

Regla de negocio: promedio **>= 3.0 → Aprobado**; las notas van de 0.0 a 5.0.
