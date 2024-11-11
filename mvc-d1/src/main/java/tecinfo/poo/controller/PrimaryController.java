package tecinfo.poo.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import tecinfo.poo.App;
import tecinfo.poo.model.Player;
import tecinfo.poo.model.dao.PlayerDao;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import tecinfo.poo.model.Dado;

public class PrimaryController {

    public static long winPlay = 0;

    @FXML
    private ImageView img_dice_moving;

    @FXML
    void switchDiceImage(MouseEvent event) {
        img_dice_moving.setFitHeight ( 250 );
        img_dice_moving.setFitWidth ( 250 );
        // supported image types: BMP, GIF, JPEG, PNG
        // src/main/resources/img directory inserted into resources tag in pom.xml, thus one has direct reference for Image
        img_dice_moving.setImage(new Image("D6.png")); 
    }

    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {
        System.out.println("changing to secondary");

        Dado sortDado = new Dado();
        sortDado.numSort();

        //Verifier + Set-up
        for (int i = 0; i < 12; i++) {
            System.out.println(ThirdController.betExt[i]);
            if (ThirdController.betExt[i] == sortDado.getNum()){
                winPlay = i + 1;
                System.out.println("We got a lucky winner!");
            }
        }

        if (winPlay != 0) {
            PlayerDao playerDao = new PlayerDao();

            Player winner = new Player(winPlay);

            boolean success = playerDao.update(winner, null);

            if (success == true) {
                System.out.println("Vitória registrada sem problemas, sendo do jogador: " + winPlay + "!");
            } else {
                System.out.println("Ocorreu algum erro na hora de registrar no banco");
            }
        }


        App.setRoot("secondaryEdit");
    }
}
