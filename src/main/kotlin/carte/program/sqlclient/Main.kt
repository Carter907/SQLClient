package carte.program.sqlclient

import javafx.application.Application
import javafx.application.Platform
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import kotlin.system.exitProcess

class App: Application() {
    override fun start(stage: Stage) {

        val root: Parent = FXMLLoader.load(javaClass.getResource("login.fxml"));
        val scene: Scene = Scene(root);
        //scene.stylesheets.add(javaClass.getResource("Application.css")?.toExternalForm() ?: error("stylesheet not found"))
        stage.scene = scene;
        stage.title = "SQL Client";
        stage.isResizable = true;
        stage.show();

        stage.setOnCloseRequest {
            exitProcess(0);
        }
    }

}

fun main() {
    Platform.startup {
        App().start(Stage());
    }
}