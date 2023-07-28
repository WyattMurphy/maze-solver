import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class DrawMaze extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Maze");
//        Button btn = new Button();
//        btn.setText("Say 'Go Maze'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
// 
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Go JetWave!!!!!");
//            }
//        });
        
        StackPane root = new StackPane();
//    
        primaryStage.setScene(new Scene(root, 600, 300));
        primaryStage.show();
    }
}
