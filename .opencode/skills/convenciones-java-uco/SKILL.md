---
name: convenciones-java-uco
description: Convenciones del código Java del sistema de gestión académica UCO (clases, reglas de notas, estilo de comentarios didácticos y cómo compilar). Úsala al revisar o modificar archivos de src/.
---

# Convenciones del código Java

## Clases del proyecto

| Clase | Rol |
|---|---|
| `Persona` | Abstracta. Atributos privados `nombre` y `cedula`; método abstracto `mostrarInformacion()`. |
| `Estudiante` | Extiende `Persona`. Tiene `carrera` y `ArrayList<Double> notas`; calcula promedio y estado. |
| `Profesor` | Extiende `Persona`. Tiene `materia`; ingresa notas a un `Estudiante`. |
| `Entrada` | Utilitaria. Lee enteros y decimales sin que el programa se caiga. |
| `Main` | Pide los datos, coordina objetos y muestra el resumen. |

## Reglas del negocio

- Nota válida: de **0.0 a 5.0**.
- **Aprobado** si el promedio es **>= 3.0**; si no, **No Aprobado**.
- Sin notas el promedio es 0.0 (evita dividir entre cero).

## Estilo

- Comentarios y mensajes al usuario en **español**.
- Cada clase lleva un comentario Javadoc que nombra el concepto de POO que ilustra
  (`>>> HERENCIA <<<`, `>>> ENCAPSULAMIENTO <<<`, etc.). Respeta ese estilo al agregar clases.
- Atributos `private`; acceso por getters y setters.
- Nombres de clases en `PascalCase`; métodos y variables en `camelCase`.
- Los números leídos de consola siempre pasan por `Entrada.leerEntero` o `Entrada.leerDouble`.

## Compilar y ejecutar

```bash
bash scripts/probar.sh
```

Equivale a `javac -encoding UTF-8 -d out src/*.java` y luego `java -cp out Main`.
