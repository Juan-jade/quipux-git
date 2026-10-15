# Sistema de Gestión Académica UCO – Reglas para OpenCode

Proyecto académico en Java (consola) de la Universidad Católica de Oriente.
Lo usa un estudiante que está aprendiendo POO y git: **explica con palabras
sencillas y en español**.

## Estructura

- `src/` → código Java (paquete por defecto): `Persona` (abstracta), `Estudiante`,
  `Profesor`, `Entrada` (lectura segura de números) y `Main`.
- `scripts/probar.sh` → compila y ejecuta el programa con una entrada de ejemplo.
- `.opencode/` → agentes, skills y comandos del proyecto (también va en el repo).

## Cómo compilar y probar

```bash
bash scripts/probar.sh
```

## Reglas de código

- Mantén los comentarios didácticos en español que explican el concepto de POO
  (abstracción, encapsulamiento, herencia, polimorfismo).
- Atributos `private` con getters/setters.
- Las notas van de 0.0 a 5.0 y **promedio >= 3.0 = Aprobado**.
- Toda lectura de números por consola pasa por la clase `Entrada`.

## Reglas de git (obligatorias)

Antes de tocar git carga la skill `flujo-git-uco`. Resumen:

1. Nunca hacer commit directo en `main`; `main` es la rama estable.
2. El trabajo diario va en ramas `feature/<tema>`, `fix/<tema>` o `docs/<tema>`
   creadas desde `development`.
3. Commits pequeños, con formato `tipo: descripción` en español.
4. Nunca ejecutar `git push` sin que el usuario lo confirme.

## Skills y agentes disponibles

- Skills: `flujo-git-uco`, `convenciones-java-uco`.
- Agentes: `git-mentor` (primario), `revisor-poo` y `probador` (subagentes).
- Comandos: `/estado`, `/nueva-rama`, `/commit`, `/revisar-poo`, `/probar`.
