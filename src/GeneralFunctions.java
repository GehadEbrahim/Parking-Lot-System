import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class  GeneralFunctions {
    public static void WriteInFile(String filepath , List<?> infoList){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            for(Object object : infoList){
                writer.write(object.toString());
                writer.newLine();
            }
            writer.close();
        }catch (IOException e){
            System.out.println(filepath +" => This file is not found\n" +  e.getMessage());
        }
    }

    public void setScene(String fxmlPage , Event event , String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPage));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    public void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);//عشان ميبقاش في كلام كتير فالهيدر لكن ممكن تتغير لحاجة تانية عادي
        alert.setContentText(content);
        alert.showAndWait();
    }
}
