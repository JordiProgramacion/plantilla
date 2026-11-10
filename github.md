Guía Rápida de Comandos Básicos de Git

Esta guía reúne los comandos esenciales de Git explicados de forma clara para el trabajo diario en proyectos.

1. Configuración Inicial e Identificación

Antes de hacer tu primer commit o enviar cambios (push), debes identificar tu usuario en Git.

Configurar nombre de usuario

Define el nombre que aparecerá asociado a tus commits.

git config --global user.name "Tu Nombre"


Configurar correo electrónico

Define el correo electrónico vinculado a tu cuenta (por ejemplo, GitHub, GitLab, Bitbucket).

git config --global user.email "tu_email@ejemplo.com"


Comprobar la configuración activa

Muestra todas las variables de configuración establecidas en tu entorno.

git config --list


2. Iniciar o Clonar un Repositorio

Iniciar un repositorio local nuevo

Convierte el directorio actual en un repositorio de Git vacante.

git init


Clonar un repositorio existente

Descarga una copia completa de un proyecto alojado en un servidor remoto.

git clone https://github.com/usuario/repositorio.git


3. Estado y Trabajo Diario (Add, Commit, Push, Pull)

Ver en qué estado se encuentra el proyecto

Muestra los archivos modificados, los añadidos a la zona de preparación (staging) y la rama actual.

git status


Añadir cambios al área de preparación (Staging)

Prepara archivos específicos para ser guardados en el próximo commit.

# Añadir un archivo concreto
git add nombre_del_archivo.ext

# Añadir todos los archivos modificados y nuevos
git add .


Guardar cambios en el historial (Commit)

Crea una instantánea guardada del estado actual de tu código con un mensaje descriptivo.

git commit -m "Mensaje claro describiendo el cambio realizado"


Subir cambios al repositorio remoto (Push)

Envía tus commits locales a la rama remota especificada.

# Enviar a la rama main (o master) por primera vez vinculándola
git push -u origin main

# Envíos posteriores simples
git push


Descargar y fusionar los cambios más recientes (Pull)

Trae las novedades del servidor remoto y las fusiona en tu rama local activa.

git pull origin main


4. Gestión de Ramas (Branches)

Ver en qué rama estás y cuáles existen

Muestra un listado de todas las ramas locales. La rama activa aparece marcada con un asterisco (*).

git branch


Crear una nueva rama

Crea una rama secundaria sin cambiarte a ella todavía.

git branch nombre-de-la-rama


Cambiar de rama (Switch / Checkout)

Cambia tu espacio de trabajo a la rama seleccionada.

# Opción recomendada actual
git switch nombre-de-la-rama

# Opción tradicional
git checkout nombre-de-la-rama


Crear una nueva rama y cambiarte a ella de inmediato

Combina la creación y el cambio de rama en una sola orden.

# Opción moderna
git switch -c nombre-de-la-rama

# Opción tradicional
git checkout -b nombre-de-la-rama


Fusionar una rama en la rama actual (Merge)

Integra los cambios de otra rama dentro de la rama en la que estás situado (por ejemplo, estar en main y traer los cambios de feature-login).

git merge nombre-de-la-rama


Eliminar una rama local

Borra una rama una vez que sus cambios ya se han fusionado.

git branch -d nombre-de-la-rama


5. Historial y Descarte de Cambios

Ver el historial de commits

Muestra una lista secuencial de las revisiones realizadas en el proyecto.

# Historial completo
git log

# Historial resumido (un commit por línea)
git log --oneline


Descartar cambios en un archivo no guardado

Restaura un archivo a su estado en el último commit (cancela modificaciones locales).

git restore nombre_del_archivo.ext
