module cqu.textalignment {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens cqu.textalignment to javafx.fxml;
    exports cqu.textalignment;
}
