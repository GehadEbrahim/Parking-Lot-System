import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ParkingController implements Initializable {

    GeneralFunctions gf = new GeneralFunctions();
    public void loginMain(Event event) {
        try {
            gf.setScene("Login.fxml" , event , "Login Page");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void registerMain(Event event) throws IOException {
        gf.setScene( "RejesterPage.fxml", event , "Rejester Page");
    }

    public void exitMain() {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
