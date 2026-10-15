---
name: flujo-git-uco
description: Flujo de trabajo con git para este proyecto (ramas main/development/feature, formato de commits en español, pull y push). Úsala siempre que haya que crear ramas, hacer commits, fusionar o subir cambios.
---

# Flujo de git del proyecto

## Vocabulario básico

- **Commit**: una foto del proyecto en un momento dado; es el historial de
  cambios. Git le asigna automáticamente un ID (hash) para saber cuándo y qué cambió.
- **add**: prepara los archivos que irán en el próximo commit (zona de staging).
- **-m**: escribe el mensaje del commit directamente en el comando.
- **pull**: trae y baja los cambios del repositorio remoto (GitHub) a nuestro equipo.
- **push**: sube nuestros cambios locales al repositorio remoto.
- **branch**: una rama, una línea de trabajo separada para no dañar lo estable.

## Ramas

| Rama | Para qué sirve |
|---|---|
| `main` | Rama **estable**. Solo recibe código ya probado desde `development`. Nunca se trabaja directo aquí. |
| `development` | Integración. Todo el código que está aquí termina en `main`. |
| `feature/<tema>` | Una funcionalidad nueva. Sale de `development` y vuelve a `development`. |
| `fix/<tema>` | Corrección de un error. |
| `docs/<tema>` | Cambios solo de documentación. |

## Ciclo de trabajo

```bash
git switch development
git pull                          # si hay remoto: traer lo último
git switch -c feature/mi-tema     # crear la rama de trabajo
# ... editar código ...
bash scripts/probar.sh            # comprobar que compila y funciona
git status                        # ver qué cambió
git add src/Archivo.java          # preparar archivos concretos
git commit -m "feat: descripción corta"
git switch development
git merge --no-ff feature/mi-tema # conserva en el historial que hubo una rama
git push                          # subir cuando el usuario lo confirme
```

Para publicar una versión estable: `development` → `main` con `git merge --no-ff development`
y luego una etiqueta (`git tag -a v1.1.0 -m "..."`).

## Formato de los commits

`tipo(alcance opcional): descripción en español, en presente, sin punto final`

| Tipo | Cuándo |
|---|---|
| `feat` | Funcionalidad nueva |
| `fix` | Corrección de un error |
| `docs` | Solo documentación |
| `test` | Pruebas o scripts de prueba |
| `refactor` | Reorganizar código sin cambiar lo que hace |
| `chore` | Tareas de mantenimiento (.gitignore, configuración) |

Buenas prácticas:

- Un commit = un cambio lógico. No mezclar una corrección con una funcionalidad nueva.
- Asunto de máximo ~72 caracteres; si hace falta explicar el porqué, va en el cuerpo.
- Nunca subir archivos `.class` ni carpetas de IDE (ya están en `.gitignore`).
- Revisar con `git status` y `git diff` antes de cada `git add`.
- Nada de `git push --force` ni `git reset --hard` salvo que el usuario lo pida y entienda el riesgo.
