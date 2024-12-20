import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginLayout extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setWidth(520);
        stage.setHeight(680);
        stage.setScene(scene);
        stage.setTitle("Login Page");
        stage.show();
    }



    public static void main(String [] args){
        launch(args);
    }
}

