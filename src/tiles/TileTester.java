package tiles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TileTester extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = new Group(new ColorPrimary(new TileTesterPanel()));
        primaryStage.setTitle("Tile Tester");
        primaryStage.setScene(new Scene(root, 600, 100));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
