package projectjva.ui;

import javafx.geometry.Insets;

import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;


/**
 * View class responsible for creating and configuring, the graphical user interface elements of the JVA form.
 * This class contains only UI components and no business logic.
 */
public class JvaFormView {

    private final ComboBox<String> jvaCombo = new ComboBox<>();
    private final TextField kennField = new TextField();
    private final CheckBox timeCheck = new CheckBox("mit Uhrzeitangabe");
    private final CheckBox abdruckCheck = new CheckBox("Abdruck für die Akten der JVA");
    private final Button validateBtn = new Button("Validate");
    private final Button sendBtn = new Button("Send");
    private final Label resultLabel = new Label("Result: -");
    private final GridPane root = new GridPane();

    /**
     * Constructs the view and initializes all UI components.
     */
    public JvaFormView() {
        build();
    }

    /**
     * Builds and arranges all UI elements inside the layout container.
     */
    private void build() {
        final Label jvaLabel = new Label("JVA *");
        final Label kennLabel = new Label("weitere Kennzeichen");

        jvaCombo.getItems().addAll("Berlin", "Hamburg", "München");
        jvaCombo.setPromptText("Select JVA");

        kennField.setPromptText("Optional");

        root.setPadding(new Insets(16));
        root.setHgap(10);
        root.setVgap(10);

        root.add(jvaLabel, 0, 0);
        root.add(jvaCombo, 1, 0);

        root.add(kennLabel, 0, 1);
        root.add(kennField, 1, 1);

        root.add(timeCheck, 1, 2);
        root.add(abdruckCheck, 1, 3);

        root.add(validateBtn, 0, 4);
        root.add(sendBtn, 1, 4);

        root.add(resultLabel, 0, 5, 2, 1);
    }

    public Parent getRoot() {
        return root;
    }

    public ComboBox<String> getJvaCombo() {
        return jvaCombo;
    }

    public TextField getKennField() {
        return kennField;
    }

    public CheckBox getTimeCheck() {
        return timeCheck;
    }

    public CheckBox getAbdruckCheck() {
        return abdruckCheck;
    }

    public Button getValidateBtn() {
        return validateBtn;
    }

    public Button getSendBtn() {
        return sendBtn;
    }

    public Label getResultLabel() {
        return resultLabel;
    }
}