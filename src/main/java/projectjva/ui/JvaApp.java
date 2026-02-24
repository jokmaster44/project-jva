package projectjva.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import projectjva.model.JvaData;
import projectjva.validator.JvaFormValidator;
import projectjva.validator.Validator;


/**
 * Entry point of the JavaFX application that initializes the view,
 * connects the controller and validator, and displays the main window.
 */
public class JvaApp extends Application {

    /**
     * Creates the UI, initializes the validator and controller
     *
     * @param stage primary stage provided by JavaFX runtime
     */
    @Override
    public void start(Stage stage) {
        JvaFormView view = new JvaFormView();

        Validator<JvaData> validator = new JvaFormValidator();
        new JvaFormController(view, validator);

        Scene scene = new Scene(view.getRoot(), 520, 260);
        stage.setTitle("JVA Form");
        stage.setScene(scene);
        stage.show();
    }
}