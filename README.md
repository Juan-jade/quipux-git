# Sistema de Gestión Académica – UCO

Programa en Java (consola) que registra un profesor y un estudiante de la
**Universidad Católica de Oriente**, permite que el profesor ingrese las notas
del estudiante y muestra el promedio y el estado académico.

Este repositorio es también un ejercicio de **buenas prácticas de git** y de uso
creativo de **OpenCode** (carpeta `.opencode/` incluida).

## Cómo compilar y ejecutar

```bash
# Ejecución normal (interactiva)
mkdir -p out
javac -encoding UTF-8 -d out src/*.java
java -cp out Main

# Prueba automática con una entrada de ejemplo (incluye datos inválidos a propósito)
bash scripts/probar.sh
```

## Estructura

| Archivo | Qué hace |
|---|---|
| `src/Persona.java` | Clase abstracta con nombre y cédula (abstracción + encapsulamiento) |
| `src/Estudiante.java` | Hereda de Persona; guarda carrera y notas, calcula promedio |
| `src/Profesor.java` | Hereda de Persona; ingresa notas a un estudiante |
| `src/Entrada.java` | Lectura segura de números por consola (no se cae con letras) |
| `src/Main.java` | Punto de entrada: pide los datos y muestra el resumen con polimorfismo |
| `scripts/probar.sh` | Compila y ejecuta con `scripts/entrada-ejemplo.txt` |
| `opencode.json`, `AGENTS.md`, `.opencode/` | Configuración de OpenCode (agentes, skills, comandos) |

Regla de negocio: promedio **>= 3.0 → Aprobado**; las notas van de 0.0 a 5.0.

## Buenas prácticas de git aplicadas

**Ramas**

| Rama | Uso |
|---|---|
| `main` | Rama estable. Solo recibe código probado desde `development`. |
| `development` | Integración: todo lo que está aquí termina en `main`. |
| `feature/*`, `docs/*`, `fix/*` | Una rama por cambio, creada desde `development`. |

**Historial de este proyecto**

1. `main`: versión inicial del programa + `.gitignore`.
2. `docs/readme-inicial` → README.
3. `feature/validacion-entradas` → clase `Entrada` y validaciones (3 commits).
4. `feature/polimorfismo-personas` → `List<Persona>` en `Main`.
5. `feature/script-pruebas` → `scripts/probar.sh`.
6. `feature/opencode` → `.opencode/`, `opencode.json`, `AGENTS.md`.
7. `development` → `main` con `merge --no-ff` y la etiqueta `v1.0.0`.

**Commits:** formato `tipo: descripción` en español (`feat`, `fix`, `docs`, `test`, `chore`),
un cambio lógico por commit, y fusiones con `--no-ff` para que el grafo muestre cada rama.

Para ver el historial como grafo:

```bash
git log --oneline --graph --all
```

## Uso de OpenCode

La carpeta `.opencode/` se versiona junto con el código:

| Elemento | Qué es |
|---|---|
| `agents/git-mentor.md` | Agente primario: tutor de git que explica cada comando y guía el flujo de ramas. |
| `agents/revisor-poo.md` | Subagente de solo lectura: revisa abstracción, encapsulamiento, herencia y polimorfismo. |
| `agents/probador.md` | Subagente que compila y ejecuta `scripts/probar.sh` y verifica el resultado. |
| `skills/flujo-git-uco/` | Skill: vocabulario de git, ramas y formato de commits (lo visto en clase). |
| `skills/convenciones-java-uco/` | Skill: clases, reglas de notas y estilo del código. |
| `commands/` | `/estado`, `/nueva-rama`, `/commit`, `/revisar-poo`, `/probar`. |

Un **agente** es un asistente de IA especializado en una tarea; una **skill** es un
conjunto de instrucciones y conocimiento empaquetado que el agente carga cuando lo necesita.

Ejemplo de flujo con OpenCode:

```text
/nueva-rama feature promedio-ponderado   # crea la rama desde development
... se hacen los cambios ...
/probar                                   # compila y verifica
git add src/Estudiante.java
/commit                                   # propone el mensaje de commit
/revisar-poo                              # revisión de POO antes de fusionar
```
