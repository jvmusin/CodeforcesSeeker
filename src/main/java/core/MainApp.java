package core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp extends Application {

    private ExecutorService pool = Executors.newCachedThreadPool();

    public void start(Stage primaryStage) throws Exception {
        ServiceHolder.setMainApp(this);
        SplitPane root = FXMLLoader.load(getClass().getResource("/UserSeekerLayout.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            pool.shutdownNow();
            System.out.println(pool);
        });
    }

    public ExecutorService getPool() {
        return pool;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
