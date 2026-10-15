#!/usr/bin/env bash
# Compila el proyecto y lo ejecuta con una entrada de ejemplo que incluye
# datos inválidos a propósito (letras, cantidad 0, nota 7) para comprobar
# que las validaciones funcionan.
set -euo pipefail
cd "$(dirname "$0")/.."

rm -rf out && mkdir out
javac -encoding UTF-8 -d out src/*.java
java -Dfile.encoding=UTF-8 -Dstdout.encoding=UTF-8 -cp out Main < scripts/entrada-ejemplo.txt
