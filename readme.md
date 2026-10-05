# Ayuda para empezar en fxml y kotlin
Este repositorio contiene los conceptos fundamentales, estructuras esenciales y ejemplos prácticos alineados con los objetivos de aprendizaje de la asignatura (creación de escenarios, layouts, controles y gestión de eventos).

---

## 1. El Ciclo de Vida: Crear el Escenario (`Stage` y `Scene`)

En JavaFX, la clase principal debe heredar de `Application`. El punto de entrada inicial configurará el escenario principal (`Stage`) y cargará la vista desde el archivo `.fxml`.

### Código Base: `MainApp.kt`
```kotlin
package com.ejemplo

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class MainApp : Application() {

    override fun start(primaryStage: Stage) {
        // 1. Cargar el archivo FXML de la vista
        val loader = FXMLLoader(javaClass.getResource("/vistas/main_view.fxml"))
        val root: Parent = loader.load()

        // 2. Crear la escena asociando el contenedor raíz y definiendo el tamaño (Ancho x Alto)
        val escena = Scene(root, 400.0, 300.0)

        // 3. Configurar el escenario principal (Stage)
        primaryStage.title = "Mi Primera Aplicación JavaFX"
        primaryStage.scene = escena
        
        // 4. Mostrar la ventana
        primaryStage.show()
    }
}

fun main(args: Array<String>) {
    Application.launch(MainApp::class.java, *args)
}
```

---

## 2. Estructura y Propiedades del Archivo FXML

Los archivos FXML estructuran los componentes visuales de manera jerárquica. Aquí se detallan las etiquetas y propiedades clave necesarias para resolver los ejercicios prácticos:

### Ejemplo Completo: `main_view.fxml`
```xml
<?xml version="1.0" encoding="UTF-8"?>

<!-- Importaciones requeridas de los componentes JavaFX -->
<?import javafx.scene.layout.VBox?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.text.Font?>

<!-- Contenedor Raíz con alineación superior-centrada y espaciado -->
<VBox xmlns:fx="http://javafx.com" 
      fx:controller="com.ejemplo.MainController"
      spacing="15.0" 
      alignment="TOP_CENTER" 
      style="-fx-padding: 20px;">
    
    <!-- Modificación visual mediante etiquetas internas de tipografía -->
    <Label text="Presentación Personal">
        <font>
            <Font name="Arial Bold" size="22.0" />
        </font>
    </Label>
    
    <!-- Componente de entrada con texto de sugerencia y ID de inyección -->
    <TextField fx:id="txtNombre" 
               promptText="Escribe tu nombre aquí..." 
               maxWidth="250.0" />
               
    <!-- Botón interactivo con método de acción asignado -->
    <Button fx:id="btnEnviar" 
            text="Registrar" 
            onAction="#manejarAccionBoton" 
            style="-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #0078d4;" />

</VBox>
```

### Acordeón de Propiedades Visuales FXML (Cheat Sheet)

*   **Alineación (`alignment`)**: `TOP_CENTER` (Centrado arriba), `CENTER` (Centro total), `CENTER_LEFT` (Izquierda), `CENTER_RIGHT` (Derecha).
*   **Espaciado de contenedores (`spacing`)**: Define la separación en píxeles entre los elementos hijos de un `VBox` o `HBox`.
*   **Estilos en línea (`style`)**: Usa la sintaxis CSS de JavaFX (Prefijo `-fx-`). 
    *   `-fx-font-size: 16px;` (Tamaño de fuente).
    *   `-fx-text-fill: #ff0000;` (Color del texto).
    *   `-fx-background-color: #eee;` (Color de fondo del nodo).

---

## 3. El Controlador (`MainController.kt`)

El controlador conecta el archivo FXML con la lógica de negocio en Kotlin. Los componentes declarados con `fx:id` y las acciones `onAction` se vinculan mediante la anotación `@FXML`.

```kotlin
package com.ejemplo

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField

class MainController {

    // Enlace directo con los componentes del FXML usando lateinit
    @FXML
    private lateinit var txtNombre: TextField

    @FXML
    private lateinit var btnEnviar: Button

    // Función inicializadora automática tras cargar el FXML (Opcional)
    @FXML
    fun initialize() {
        println("Controlador inicializado correctamente.")
    }

    // Método asignado al onAction del botón
    @FXML
    private fun manejarAccionBoton() {
        val entradaUsuario = txtNombre.text.trim()

        if (entradaUsuario.isEmpty()) {
            println("El campo de texto está vacío.")
        } else {
            // Ejemplo de lectura y lógica dinámica
            println("Nombre registrado con éxito: $entradaUsuario")
            
            // Ejemplo de reinicio de campo (Útil para ejercicios de RESET)
            txtNombre.clear()
        }
    }
}
```

---

## 4. Guía de Componentes Avanzados para Ejercicios

Para cumplir con los ejercicios de validación, selectores y formularios complejos, usa los siguientes mapeos de componentes:

### Entrada Segura (Ejercicio 10: Inicio de sesión)
Para contraseñas ocultas, sustituye `TextField` por `PasswordField`:
```xml
<PasswordField fx:id="txtPassword" promptText="Contraseña" />
```

### Opciones Únicas (Ejercicio 8: RadioButton + ToggleGroup)
Para forzar al usuario a escoger solo una opción de género, se agrupan en un `ToggleGroup` definido en los elementos no visuales:
```xml
<fx:define>
    <ToggleGroup fx:id="grupoGeneros" />
</fx:define>

<RadioButton text="Masculino" toggleGroup="$grupoGeneros" />
<RadioButton text="Femenino" toggleGroup="$grupoGeneros" />
```

### Listas Desplegables (Ejercicio 8: ComboBox)
Crea la caja en el FXML y añade sus elementos desde el método `initialize()` de tu controlador Kotlin:
```xml
<ComboBox fx:id="comboPaises" promptText="Selecciona un país..." />
```
```kotlin
@FXML
private lateinit var comboPaises: ComboBox<String>

@FXML
fun initialize() {
    comboPaises.items.addAll("España", "Francia", "Italia", "Marruecos")
}
```
