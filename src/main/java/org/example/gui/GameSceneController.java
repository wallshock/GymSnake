package org.example.gui;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import org.example.Direction;
import org.example.Game;
import org.example.Main;
import org.example.Snake;
import org.example.interfaces.IGuiObserver;
import org.example.interfaces.Item;

import java.io.IOException;
import java.util.ArrayList;

public class GameSceneController implements IGuiObserver {
    @FXML
    private GridPane mapGridPane;
    @FXML
    private Label gameOverText;

    @FXML
    private ImageView mainmenu;
    @FXML
    private Label gameOverText1;
    @FXML
    private ImageView endScreenBlur;

    @FXML
    private ImageView toxicbar;

    @FXML
    private GridPane mapGridPane1;

    @FXML private AnchorPane ap;
    @FXML
    private ImageView restart;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label scoreLabel1;
    private MapVisualiser mapV;

    private Game game;

    private double maxScore;
    private Stage stage;

    public Snake getSnake(){
        return game.getSnake();
    }

    public void start() {
        this.game = new Game();
        game.setObserver(this);
        this.mapV = new MapVisualiser(game.getMap(), mapGridPane);
        Scene scene = ap.getScene();
        Snake snake = this.game.getSnake();
//        stage.getIcons().add(new Image(new FileInputStream("src/main/resources/com/example/evolutiongenerator/icon.png")));
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W &&
                    (snake.getDirection()== Direction.LEFT || snake.getDirection()==Direction.RIGHT))  {
                snake.queueDirection(Direction.UP);
            } else if (e.getCode() == KeyCode.A &&
                    (snake.getDirection()==Direction.UP || snake.getDirection()==Direction.DOWN)){
                snake.queueDirection(Direction.LEFT);
            } else if (e.getCode() == KeyCode.S &&
                    (snake.getDirection()==Direction.LEFT || snake.getDirection()==Direction.RIGHT))  {
                snake.queueDirection(Direction.DOWN);
            } else if (e.getCode() == KeyCode.D &&
                    (snake.getDirection()==Direction.UP || snake.getDirection()==Direction.DOWN)){
                snake.queueDirection(Direction.RIGHT);
            }
        });
        updateGuiViews();
        new Thread(game).start();
    }

    public void updateGuiViews() {
        try {
            long speed =(long) (500/game.getSnake().getSpeed());
            Platform.runLater(this::updateScore);
            Platform.runLater(this::updateItems);
            Platform.runLater(this::updateGui);
            Platform.runLater(this::updateToxicBar);
            Thread.sleep(speed);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void updateScore(){
        scoreLabel1.setText(Double.toString(getScore()));
        scoreLabel.setText(Double.toString(getScore()));
    }
    public void endingScreenShow(){
        Platform.runLater(this::endScreenShow);
    }
    public void endingScreenHide(){
        Platform.runLater(this::endScreenHide);
    }

    public void endScreenShow(){
        restart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                onRestartButtonClicked();
            }
        });
        mainmenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                onMainMenuButtonClicked();
            }
        });
        EndScreenOpacityValue(0.8);
    }

    private void onMainMenuButtonClicked() {
        Platform.runLater(() -> {
            try {
                MainMenu();
            } catch (Exception e) {
                // Handle the exception
                e.printStackTrace();
            }
        });
    }

    public void endScreenHide(){
        EndScreenOpacityValue(0);
        restart.setScaleX(0);
        mainmenu.setScaleX(0);
    }

    public void onRestartButtonClicked(){
        Platform.runLater(this::start);
    }

    public void EndScreenOpacityValue(double value){
        //for some reason fade transition does not work on group
        restart.setScaleX(1);
        mainmenu.setScaleX(1);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1));
        FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(1));
        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(1));
        FadeTransition fadeTransition3 = new FadeTransition(Duration.seconds(1));
        FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(1));
        fadeTransition.setNode(endScreenBlur);
        fadeTransition1.setNode(gameOverText);
        fadeTransition2.setNode(gameOverText1);
        fadeTransition3.setNode(restart);
        fadeTransition4.setNode(mainmenu);
        fadeTransition.setToValue(value);
        fadeTransition1.setToValue(value);
        fadeTransition2.setToValue(value);
        fadeTransition3.setToValue(value);
        fadeTransition4.setToValue(value);
        fadeTransition.play();
        fadeTransition1.play();
        fadeTransition2.play();
        fadeTransition3.play();
        fadeTransition4.play();

        //todo add popup and buttons to restart or main menu
        //plus prompt high score
    }

    public void updateItems(){
        Snake snake = game.getSnake();
        ArrayList<Item> backpack = snake.getBackpack();
        mapGridPane1.getChildren().clear();
        mapGridPane1.setGridLinesVisible(true);
        for (int x = 0; x < snake.getBackpack().size(); x++) {
            String imagePath =backpack.get(x).getPath();
            if (imagePath != null) {
                Image image = new Image(imagePath);
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(69); // adjust size as needed
                imageView.setFitHeight(65);
                mapGridPane1.add(imageView, x, x/4); // add to GridPane (column, row)
                }
            }
    }
    public double getScore(){
        if(!game.isDead()) {
            maxScore = game.getSnake().getScore();
            return this.game.getSnake().getScore();
        }
        return 0;
    }

    @Override
    public void updateGui() {
        mapV.visualiseMap();
    }

    public void updateToxicBar(){
        Snake snake = game.getSnake();
        if(snake.getAnabolicDose()>99){
            Image newImage = new Image("barfive.png");
            toxicbar.setImage(newImage);
        } else if (snake.getAnabolicDose()>98) {
            Image newImage = new Image("barfour.png");
            toxicbar.setImage(newImage);
        } else if (snake.getAnabolicDose()>51) {
            Image newImage = new Image("barthree.png");
            toxicbar.setImage(newImage);
        } else if (snake.getAnabolicDose()>26) {
            Image newImage = new Image("bar.png");
            toxicbar.setImage(newImage);
        } else if (snake.getAnabolicDose()>0) {
            Image newImage = new Image("barone.png");
            toxicbar.setImage(newImage);
        }else{
            Image newImage = new Image("barzero.png");
            toxicbar.setImage(newImage);
        }
    }

    public void MainMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/main-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 720);

        stage = (Stage) ap.getScene().getWindow();
        stage.setResizable(false);
        stage.setTitle("GymSnake");
        stage.setScene(scene);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });

        stage.show();
    }
}
