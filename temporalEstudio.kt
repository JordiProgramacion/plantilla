import javafx.application.Application
import javafx.application.Platform
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.Parent
import javafx.stage.Stage

class Main : Aplication () {

    override fun start (stage: Stage) {

        val root = FXMLLoader.load<Parent>(Main::class.java.getResource("main.fxml"))
        val mainScene = (root, 1920.0, 1080.0)

        stage.title = "Preuba"
        stage.scene = mainScene
        stage.show()

    }
}
fun main() {

    Aplication.launch(Main::class.java)

}

// xmlns:fx="https://javafx.com/fxml"
// fx:controller="mainController"

<padding>
        <Insets top="20.0" right="20.0" bottom="20.0" left="20.0" />
</padding>

###############

<fx:define>
        <ToggleGroup fx:id="grupoOperacion" />
</fx:define>

<RadioButton text="Suma" toggleGroup="$grupoOperacion" selected="true" />
<RadioButton text="Resta" toggleGroup="$grupoOperacion" />

#################

<ComboBox fx:id="cmbPaises" promptText="Selecciona un país" prefWidth="200.0" />

@FXML private lateinit var cmbPaises: ComboBox

@FXML fun initialize() { 
    cmbPaises.items.addAll("España", "Marruecos", "Francia", "Italia") 
}
// Para guardar lo seleccionado del usuario
fun guardar() {
        
    val paisSeleccionado: String? = cmbPaises.value
        
}

########### Importantes del FXML
