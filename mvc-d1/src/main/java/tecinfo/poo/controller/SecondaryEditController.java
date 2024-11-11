package tecinfo.poo.controller;

import java.io.IOException;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import tecinfo.poo.App;
import tecinfo.poo.model.Player;
import tecinfo.poo.model.dao.PlayerDao;

public class SecondaryEditController {

    int counter = 15;

    @FXML
    private Label winAnnouncer;
    
    @FXML
    private TableView<Player> tbvPlayers;

    @FXML
    private Label lblCounter;

    @FXML
    private void switchToThird() throws IOException {
        System.out.println("changing to third");
        App.setRoot("third");
    }

    @FXML
    private void flushTable() throws IOException {
        PlayerDao playerDao = new PlayerDao();

        System.out.println("flushing table data");
        playerDao.flush();
        App.setRoot("secondaryEdit");
    }

    public SecondaryEditController() {
        
    }

    @SuppressWarnings("unchecked")
    @FXML
    public void initialize() {
        
        //temporizador (exemplo)
       
        lblCounter.setText(String.valueOf(counter));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            counter--;
            lblCounter.setText(String.valueOf(counter));
        }));
        timeline.setCycleCount(15); //Animation.INDEFINITE (-1)
        timeline.play();
        timeline.setOnFinished(e -> {
            try {
                switchToThird();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        if (PrimaryController.winPlay == 0) {
            winAnnouncer.setText(String.valueOf("Máquina foi Vencedora!"));
        } else {
            winAnnouncer.setText(String.valueOf("Jogador de ID " + PrimaryController.winPlay + " venceu!"));
        }

        // criação colunas TableView, considerando que não foram criadas no scene builder. 
        TableColumn<Player, Long> colId = new TableColumn<Player,Long>("id");
        TableColumn<Player, Long> colWins = new TableColumn<Player,Long>("wins");
        
        tbvPlayers.getColumns().addAll(colId, colWins);
        
        // agora obtendo do banco de dados - se comentar as cinco linhas abaixo, insere apenas os dois objetos acima. Se descomentar, insere dados do BD ignorando acima
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colWins.setCellValueFactory(new PropertyValueFactory<>("wins"));

        tbvPlayers.setItems(fillTableFromDB()); //este método é o que de fato insere os dados do BD no TableView


        // agora adicionando dados manualmente com o construtor
        
        colId.setCellValueFactory(data -> new SimpleLongProperty(data.getValue().getId()).asObject());
        colWins.setCellValueFactory(data -> new SimpleLongProperty(data.getValue().getWins()).asObject());
        // preenchendo manualmente alguns dados
        // tbvPlayers.getItems().add(new Player(13L,0l));
        // tbvPlayers.getItems().add(new Player(14L,0l));


        PrimaryController.winPlay = 0;
    }

    public ObservableList<Player> fillTableFromDB() {
        PlayerDao playerDao = new PlayerDao();

        return FXCollections.observableArrayList(playerDao.getAll()); // se usar return (ObservableList<Product>(...)) não funciona. É preciso usar o ArrayList do tipo Observable
    }
}