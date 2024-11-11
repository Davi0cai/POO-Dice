package tecinfo.poo.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import tecinfo.poo.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ThirdController implements Initializable{
    
    @FXML
    private ChoiceBox<String> p1c;
    @FXML
    private ChoiceBox<String> p2c;
    @FXML
    private ChoiceBox<String> p3c;
    @FXML
    private ChoiceBox<String> p4c;
    @FXML
    private ChoiceBox<String> p5c;
    @FXML
    private ChoiceBox<String> p6c;
    @FXML
    private ChoiceBox<String> p7c;
    @FXML
    private ChoiceBox<String> p8c;
    @FXML
    private ChoiceBox<String> p9c;
    @FXML
    private ChoiceBox<String> p10c;
    @FXML
    private ChoiceBox<String> p11c;
    @FXML
    private ChoiceBox<String> p12c;

    public static int[] betExt = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] betTransfer = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private String[] bets = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        p1c.setValue("0");
        p2c.setValue("0");
        p3c.setValue("0");
        p4c.setValue("0");
        p5c.setValue("0");
        p6c.setValue("0");
        p7c.setValue("0");
        p8c.setValue("0");
        p9c.setValue("0");
        p10c.setValue("0");
        p11c.setValue("0");
        p12c.setValue("0");

        p1c.getItems().addAll(bets);
        p2c.getItems().addAll(bets);
        p3c.getItems().addAll(bets);
        p4c.getItems().addAll(bets);
        p5c.getItems().addAll(bets);
        p6c.getItems().addAll(bets);
        p7c.getItems().addAll(bets);
        p8c.getItems().addAll(bets);
        p9c.getItems().addAll(bets);
        p10c.getItems().addAll(bets);
        p11c.getItems().addAll(bets);
        p12c.getItems().addAll(bets);
    }

    @FXML
    private void switchToPrimary() throws IOException {
        betTransfer[0] = Integer.valueOf(p1c.getValue());
        betTransfer[1] = Integer.valueOf(p2c.getValue());
        betTransfer[2] = Integer.valueOf(p3c.getValue());
        betTransfer[3] = Integer.valueOf(p4c.getValue());
        betTransfer[4] = Integer.valueOf(p5c.getValue());
        betTransfer[5] = Integer.valueOf(p6c.getValue());
        betTransfer[6] = Integer.valueOf(p7c.getValue());
        betTransfer[7] = Integer.valueOf(p8c.getValue());
        betTransfer[8] = Integer.valueOf(p9c.getValue());
        betTransfer[9] = Integer.valueOf(p10c.getValue());
        betTransfer[10] = Integer.valueOf(p11c.getValue());
        betTransfer[11] = Integer.valueOf(p12c.getValue());

        for (int i = 1; i < 13; i++) {
            //Transmitir para próximos
            betExt[i - 1] = betTransfer[i - 1];
            //Verificador
            System.out.println("Aposta número " + (i) + " equivalente a: " + betTransfer[i - 1] + "\n"); 
        }

        System.out.println("changing to dice screen");
        App.setRoot("primary");
    }
}
