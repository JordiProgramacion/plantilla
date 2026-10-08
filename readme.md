# Ayuda para empezar en fxml y kotlin

                    ###### Kotlin inicio: ######

class Main : Application() {
  override fun start(stage: Stage) {
    val root = FXMLLoader.load<Parent>(Main::class.java.getResource("main.fxml"))
    val mainScene = Scene(root, 1280.0, 720.0) 
    stage.title = "titulo"
    stage.scene = mainScene
    stage.show()
  }
}
fun main() {
  Application.launch(Main::class.java)
}

                    ###### FXML ######

Comienzo con imports:

<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.layout.VBox?>
<?import javafx.scene.control.Label?>

### VBox (div para empezar) ###

<VBox xmlns:fx="http://javafx.com/fxml"
      fx:controller="MainController"
      alignment="CENTER">
</VBox>

### Label (para poner texto) ###
// Solo para poner una etiqueta de texto
<Label fx:id="mensaje" text="" />

// Propiedades para esta etiqueta
<Label textFill="RED"/> - Para el color del texto
<Label textAlignment="JUSTIFY" wrapText="true"/> - Para justificar el texto, CENTER, LEFT, RIGHT, wrapText = salto de linea
<Label text="Ejemplo">
    <font>
        <Font name="Arial Bold" size="18.0" /> - Tamaño y fuente de letra.
    </font>
</Label>

### Botones ###
// Ejemplo boton y propiedades
<Button fx:id="boton" text="Pulsar"/> -  Boton normal con un texto
<Button onAction="#handleButtonAction" text="Aceptar"/> - On action, se le pone el nombre de una funcion para darle una
funcionalidad.
// Boton con imagen
<Button text="Eliminar">
    <graphic>
        <ImageView image="$null" /> - Ruta de la imagen en image
    </graphic>
</Button>

### Boton con cambio de texto ###
// Esto iría dentro del mainController
@FXML
    
    lateinit var boton: Button
    lateinit var mensaje: Label
    
    fun accioBoto(event: ActionEvent) {

        mensaje.text = "Hola!"
    }
### Ahora el FXML del .kt ###

<VBox xmlns:fx="http://javafx.com/fxml"
      fx:controller="MainController"
      alignment="CENTER">

  <Button fx:id="boton" 
            text="Pulsar" 
            onAction="#accioBoto" 
            style="-fx-font-weight: bold; -fx-background-color: #0078d4;" />

  <Label fx:id="mensaje" text="" />

</VBox>

                    ###### TextField ######















