package carte.program.sqlclient.controllers

import carte.program.sqlclient.controllers.Controller
import javafx.concurrent.Task
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import java.net.URL
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.logging.Logger

class LoginController: Controller() {

    @FXML
    private lateinit var loginButton: Button

    @FXML
    private lateinit var loginPassword: PasswordField

    @FXML
    private lateinit var loginRoot: VBox

    @FXML
    private lateinit var loginText: Label

    @FXML
    private lateinit var loginUsername: TextField

    override fun initialize(url: URL, resourceBundle: ResourceBundle?) {

        initializeScene();
        loginButton.setOnAction {
            onLoginPressed(it)
        }

    }

    override fun initializeScene() {
        service.execute(object: Task<Unit>() {
            override fun call() {
                while (loginRoot.scene == null) { TimeUnit.MILLISECONDS.sleep(10); }
                scene = loginRoot.scene;
                Logger.getLogger(javaClass.simpleName).info("initialized scene! ($scene)")

            }
        });
    }

    private fun onLoginPressed(event: ActionEvent) {
        scene.root = FXMLLoader(javaClass.getResource("../home.fxml")).load();
    }





}
