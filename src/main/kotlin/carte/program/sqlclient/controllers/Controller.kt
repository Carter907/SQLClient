package carte.program.sqlclient.controllers

import javafx.concurrent.Task
import javafx.fxml.Initializable
import javafx.scene.Scene
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.logging.Logger

sealed class Controller(val service: ExecutorService = Executors.newSingleThreadExecutor()): Initializable {

    lateinit var scene: Scene;

    abstract fun initializeScene()

}