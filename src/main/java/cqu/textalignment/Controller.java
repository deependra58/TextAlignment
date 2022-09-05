package cqu.textalignment;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Deependra karki
 */
public class Controller implements Initializable {

    @FXML
    private TextArea originalTextarea;
    @FXML
    private TextArea alignedTextarea;
    @FXML
    private Button exitButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button defaultButton;
    @FXML
    private Button loadButton;
    @FXML
    private Button saveButton;
    @FXML
    private RadioButton left;
    @FXML
    private RadioButton right;
    @FXML
    private RadioButton centred;
    @FXML
    private RadioButton justified;
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Create a toggle group
        ToggleGroup tg = new ToggleGroup();
        left.setToggleGroup(tg);
        right.setToggleGroup(tg);
        centred.setToggleGroup(tg);
        justified.setToggleGroup(tg);
    }

    @FXML
    private void exitButtonHandler(ActionEvent event) {
        System.exit(0);
        System.out.println("Exit Invoked");
    }

    @FXML
    private void clearButtonHandler(ActionEvent event) {
        System.out.println("clear Invoked");
    }

    @FXML
    private void defaultButtonHandler(ActionEvent event) {
        System.out.println("default invoked");
    }

    @FXML
    private void loadButtonHandler(ActionEvent event) {
        System.out.println("load invoked");
    }

    @FXML
    private void saveButtonHandler(ActionEvent event) {
        System.out.println("save invoked");
    }

    @FXML
    private void leftAlignHandler(ActionEvent event) {
        System.out.println("left aligned");
    }

    @FXML
    private void rightAlignHandler(ActionEvent event) {
        System.out.println("right invoked");
    }

    @FXML
    private void centreAlignHandler(ActionEvent event) {
        System.out.println("left invoked");
    }

    @FXML
    private void justifiedAlignHandler(ActionEvent event) {
        System.out.println("justified invoked");
    }

}
