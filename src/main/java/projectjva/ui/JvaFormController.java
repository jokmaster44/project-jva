package projectjva.ui;

import projectjva.model.JvaData;
import projectjva.validator.*;


/**
 * Controller responsible for handling user interactions, collecting data from the view, and invoking validation logic.
 */
public class JvaFormController {

    private final JvaFormView view;
    private final Validator<JvaData> validator;

    public JvaFormController(JvaFormView view, Validator<JvaData> validator) {
        this.view = view;
        this.validator = validator;
        bindActions();
    }

    /**
     * Binds button actions to their corresponding handler methods.
     */
    private void bindActions() {
        view.getValidateBtn().setOnAction(e -> onValidate());
        view.getSendBtn().setOnAction(e -> onSend());
    }

    /**
     * Collects data from the view, creates a JvaData objects,validates it, and displays the validation result.
     */
    private JvaData collectFormData(){
        final String jva = view.getJvaCombo().getValue();
        final String kenn = view.getKennField().getText();
        final boolean mitUhrZeit = view.getTimeCheck().isSelected();
        final boolean abdrick = view.getAbdruckCheck().isSelected();

        return new JvaData(jva, kenn, mitUhrZeit, abdrick);
    }

    private void onValidate(){
        final JvaData data = collectFormData();
        final ValidatorResult result = validator.validate(data);

        if (result.isSuccessful()){
            view.getResultLabel().setText("Result: SUCCESS");
            System.out.println("SUCCESS");
        }else {
            view.getResultLabel().setText("Result: ERROR -" + result.getErrorCode());
            System.out.println("ERROR: " + result.getErrorCode());
        }
    }

    /**
     * Handles the send action and displays a placeholder message.
     */
    private void onSend() {
        System.out.println("Package was sent");
        view.getResultLabel().setText("Result: Sent Package");
    }
}