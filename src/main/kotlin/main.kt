import javafx.application.Application
import javafx.application.Platform
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.Parent
import javafx.stage.Stage

fun main () {

  class Main : Application() {
  
  override fun start(stage: Stage) {
    
    val root = FXMLLoader.load<Parent>(Main::class.java.getResource("main.fxml"))
    val mainScene = Scene(root, 720.0, 860.0)
    
    stage.title = ""
    
    stage.scene = mainScene
    
    stage.show()
    
  }
  
}

fun main () {

  Application.launch(Main::class.java)
  
}

  
}
