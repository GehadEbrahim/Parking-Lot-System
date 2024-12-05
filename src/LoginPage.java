import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        // إنشاء واجهة تسجيل الدخول
        Label nameLabel = new Label("Enter your name:");
        TextField nameField = new TextField();

        Label passwordLabel = new Label("Enter your password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Log In");

        Label messageLabel = new Label();

        // حدث عند الضغط على زر تسجيل الدخول
        loginButton.setOnAction(event -> {
            String name = nameField.getText();
            String password = passwordField.getText();

            // اختبري Admin أو Owner هنا
            User admin = new Admin("admin", "admin123");
            User owner = new Owner(1, "owner@example.com", "owner", "owner123");

            // تحقق من المستخدم
            if (admin.logIn(name, password) == 1) {
                messageLabel.setText("Welcome Admin!");
            } else if (owner.logIn(name, password) == 1) {
                messageLabel.setText("Welcome Owner!");
            } else {
                messageLabel.setText("Invalid username or password. Try again!");
            }
        });

        // تصميم الواجهة
        VBox root = new VBox(10);  // تحديد المسافة بين العناصر بـ 10 بكسل
        root.getChildren().addAll(nameLabel, nameField, passwordLabel, passwordField, loginButton, messageLabel);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 1000, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Page");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
