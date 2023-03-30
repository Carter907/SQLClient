package carte.program.sqlclient.controllers



import javafx.concurrent.Task
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem
import javafx.scene.control.TableView
import javafx.scene.layout.BorderPane
import java.net.URL
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.logging.Logger

class HomeController: Controller() {

    @FXML
    lateinit var queryDataMenuItem: MenuItem

    @FXML
    private lateinit var editMenu: Menu

    @FXML
    private lateinit var fileMenu: Menu

    @FXML
    private lateinit var helpMenu: Menu

    @FXML
    private lateinit var menuBar: MenuBar

    @FXML
    private lateinit var outerBorder: BorderPane

    @FXML
    private lateinit var table: TableView<Any>

    override fun initializeScene() {
        service.execute(object: Task<Unit>() {
            override fun call() {
                while (outerBorder.scene == null) {
                    TimeUnit.MILLISECONDS.sleep(10)
                }
                scene = outerBorder.scene;
                Logger.getLogger(javaClass.simpleName).info("initialized scene! ($scene)")

            }
        });
    }


    override fun initialize(location: URL, resources: ResourceBundle?) {
        initializeScene()
        queryDataMenuItem.setOnAction {
            onQueryDateMenuItemPressed(it)
        }
    }

    private fun onQueryDateMenuItemPressed(event: ActionEvent) {
        scene.root = FXMLLoader(javaClass.getResource("../query_screen.fxml")).load()
    }

}
