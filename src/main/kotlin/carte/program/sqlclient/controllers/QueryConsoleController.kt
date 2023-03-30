package carte.program.sqlclient.controllers

import javafx.concurrent.Task
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar
import javafx.scene.control.Label
import javafx.scene.control.ScrollPane
import javafx.scene.control.SplitPane
import javafx.scene.control.TextArea
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.FlowPane
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.text.TextFlow
import java.net.URL
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.logging.Logger

class QueryConsoleController: Controller() {

    @FXML
    private lateinit var backButton: Button

    @FXML
    private lateinit var bot: AnchorPane

    @FXML
    private lateinit var console: TextFlow

    @FXML
    private lateinit var consoleHolder: StackPane

    @FXML
    private lateinit var consoleScroller: ScrollPane

    @FXML
    private lateinit var queryBar: ButtonBar

    @FXML
    private lateinit var queryDivider: SplitPane

    @FXML
    private lateinit var queryLabel: Label

    @FXML
    private lateinit var queryTextArea: TextArea

    @FXML
    private lateinit var queryVBox: VBox

    @FXML
    private lateinit var runButton: Button

    @FXML
    private lateinit var runSelectButton: Button

    @FXML
    private lateinit var top: AnchorPane

    @FXML
    private lateinit var topFlow: FlowPane

    override fun initializeScene() {
        service.execute(object: Task<Unit>() {
            override fun call() {
                while (queryVBox.scene == null) { TimeUnit.MILLISECONDS.sleep(10) }
                scene = queryVBox.scene;
                Logger.getLogger(javaClass.simpleName).info("initialized scene! ($scene)")
            }
        })
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {

        initializeScene();
        backButton.setOnAction {
            Logger.getLogger(javaClass.simpleName).info("pressed back button")

            onBackButtonPressed(it)
        }

    }
    private fun onBackButtonPressed(event: ActionEvent) {
        scene.root = FXMLLoader(javaClass.getResource("../home.fxml")).load()
    }

}
