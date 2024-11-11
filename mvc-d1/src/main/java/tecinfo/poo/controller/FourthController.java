package tecinfo.poo.controller;

import javafx.fxml.FXML;
import tecinfo.poo.App;

import java.io.IOException;

public class FourthController {
    
    @FXML
    private void switchToThird() throws IOException {
        
        System.out.println("changing to bets screen");
        App.setRoot("third");
    }
}
