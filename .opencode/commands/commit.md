---
description: Propone un mensaje de commit (en español, formato tipo - descripción) para lo que está en staging
agent: git-mentor
---

Rama actual:

!`git branch --show-current`

Archivos en staging:

!`git diff --staged --stat`

Cambios en staging:

!`git diff --staged`

Con base en la skill `flujo-git-uco`:

1. Si estoy en `main`, avísame y no continúes.
2. Si no hay nada en staging, explícame cómo usar `git add` y para.
3. Si hay cambios, propón **un** mensaje con el formato `tipo(alcance): descripción`
   (máx. ~72 caracteres) y, solo si hace falta, un cuerpo breve explicando el porqué.
4. Si los cambios mezclan varias cosas distintas, sugiere dividirlos en commits separados.
5. Dame el comando final `git commit -m "..."` para que yo lo ejecute.

Contexto adicional (opcional): $ARGUMENTS
