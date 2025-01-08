package Views.main;

import Presentation.QuizPresenter;
import Presentation.views.View;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.Scanner;

public class MainView extends Application implements View {

    private QuizPresenter quizPresenter;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/main/MainView.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Quiz Anglais");
        stage.show();
    }

    @Override
    public void launch() {
        Application.launch();
    }

    @FXML
    private void handleVocabQuiz() {
        showAlert("Vocabulaire", "Lancement du quiz de vocabulaire...");
    }

    @FXML
    private void handleVerbsQuiz() {
        showAlert("Verbes Irréguliers", "Lancement du quiz des verbes irréguliers...");
    }

    @FXML
    private void handleQuit() {
        System.exit(0);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
