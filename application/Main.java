package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;


public class Main extends Application {

    //Variables
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static  int XMAX = SIZE * 12;
    public static int YMAX = SIZE * 24;
    public static int[][] MESH = new int [XMAX/SIZE][YMAX/SIZE];
    private static Pane group = new Pane();
    private static Block object;
    private static Scene scene;
    public static int score = 0;
    public static int top = 0;
    private static boolean game = true;
    private static Block nextObj = Controller.makeBlock();
    private static int lineNo = 0;
    private static int canRotate = 1;
    private static int speed = 200;

    //create scene and start the game
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        for(int[] a: MESH){
            Arrays.fill(a,0);;
        }

        //Create score and level text
        Line line = new Line(XMAX, 0, XMAX, YMAX);
        Text scoreText = new Text("Score: ");
        scoreText.setStyle("-fx-font: 20 arial;");
        scoreText.setY(50);
        scoreText.setX(XMAX + 5);
        Text level = new Text("Lines: ");
        level.setStyle("-fx-font: 20 arial;");
        level.setY(100);
        level.setX(XMAX + 5);
        level.setFill(Color.GREEN);
        group.getChildren().addAll(scoreText,line,level);

        //Create first block and the stage
        Block a = nextObj;
        group.getChildren().addAll(a.a(),a.b(),a.c(),a.d());
        object = a;
        nextObj = Controller.makeBlock();
        scene  = new Scene(group,XMAX + 150, YMAX);
        stage.setScene(scene);
        stage.setTitle("T E T R I S");
        stage.show();
        moveOnKeyPress(a);

        //Timer
        Timer fall = new Timer();
        TimerTask task = new TimerTask(){
            public void run(){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if(object.a().getY() == 0 || object.b().getY() == 0 || object.c().getY() == 0 || object.d().getY() == 0){
                            top++;
                        }
                        else {
                            top = 0;
                        }
                        if(top == 2){
                            //GAME OVER
                            Text over = new Text("GAME OVER");
                            over.setFill(Color.RED);
                            over.setStyle("-fx-font: 70 arial;");
                            over.setY(250);
                            over.setX(10);
                            group.getChildren().add(over);
                            game = false;
                        }

                        // END GAME
                        if (top == 15) {
                            game = false;
                        }

                        //PLAYING GAME
                        if(game){
                            MoveDown(object);
                            scoreText.setText("Score: " + score);
                            level.setText("Lines: " + lineNo);
                        }
                    }
                });
            }
        };

        fall.schedule(task,0,speed);
        if(speed > 50){
            speed = 50;
        }

    }
    @Override
    public void stop(){
        System.exit(0);
    }

    private void moveOnKeyPress(Block block){
        scene.setOnKeyPressed(new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch(keyEvent.getCode()){
                    case RIGHT:
                        Controller.MoveRight(block);
                        break;
                    case LEFT:
                        Controller.MoveLeft(block);
                        break;
                    case DOWN:
                        if(game)
                            MoveDown(block);
                        break;
                    case UP:
                        if(canRotate > 2){
                            block.rotateBlock();
                            canRotate = 2;
                        }
                        break;
                }
            }
        });
    }

    private void RemoveRows(Pane pane) {
        ArrayList<Node> rects = new ArrayList<Node>();
        ArrayList<Integer> lines = new ArrayList<Integer>();
        ArrayList<Node> newrects = new ArrayList<Node>();
        int full = 0;
        for (int i = 0; i < MESH[0].length; i++) {
            for (int j = 0; j < MESH.length; j++) {
                if (MESH[j][i] == 1)
                    full++;
            }
            if (full == MESH.length)
                lines.add(i);
            full = 0;
        }
        if (lines.size() > 0)
            do {
                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
                score += 50;
                lineNo++;

                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() == lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        pane.getChildren().remove(node);
                    } else
                        newrects.add(node);
                }

                for (Node node : newrects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() < lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        a.setY(a.getY() + SIZE);
                    }
                }
                lines.remove(0);
                rects.clear();
                newrects.clear();
                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    try {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                rects.clear();
            } while (lines.size() > 0);
    }

    private void MoveDown(Block block) {
        if (block.a().getY() == YMAX - SIZE || block.b().getY() == YMAX - SIZE || block.c().getY() == YMAX - SIZE
                || block.d().getY() == YMAX - SIZE || moveA(block) || moveB(block) || moveC(block) || moveD(block)) {
            MESH[(int) block.a().getX() / SIZE][(int) block.a().getY() / SIZE] = 1;
            MESH[(int) block.b().getX() / SIZE][(int) block.b().getY() / SIZE] = 1;
            MESH[(int) block.c().getX() / SIZE][(int) block.c().getY() / SIZE] = 1;
            MESH[(int) block.d().getX() / SIZE][(int) block.d().getY() / SIZE] = 1;
            RemoveRows(group);

            if (nextObj.getName().equals("i")) {
                canRotate = -1;
            }else{
                canRotate = 0;
            }
            score++;
            Block a = nextObj;
            nextObj = Controller.makeBlock();
            object = a;
            group.getChildren().addAll(a.a(), a.b(), a.c(), a.d());
            moveOnKeyPress(a);
        }

        if (block.a().getY() + MOVE < YMAX && block.b().getY() + MOVE < YMAX && block.c().getY() + MOVE < YMAX
                && block.d().getY() + MOVE < YMAX) {
            int movea = MESH[(int) block.a().getX() / SIZE][((int) block.a().getY() / SIZE) + 1];
            int moveb = MESH[(int) block.b().getX() / SIZE][((int) block.b().getY() / SIZE) + 1];
            int movec = MESH[(int) block.c().getX() / SIZE][((int) block.c().getY() / SIZE) + 1];
            int moved = MESH[(int) block.d().getX() / SIZE][((int) block.d().getY() / SIZE) + 1];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                block.a().setY(block.a().getY() + MOVE);
                block.b().setY(block.b().getY() + MOVE);
                block.c().setY(block.c().getY() + MOVE);
                block.d().setY(block.d().getY() + MOVE);
            }
            canRotate ++;
        }
    }

    private boolean moveA(Block block) {
        return (MESH[(int) block.a().getX() / SIZE][((int) block.a().getY() / SIZE) + 1] == 1);
    }

    private boolean moveB(Block block) {
        return (MESH[(int) block.b().getX() / SIZE][((int) block.b().getY() / SIZE) + 1] == 1);
    }

    private boolean moveC(Block block) {
        return (MESH[(int) block.c().getX() / SIZE][((int) block.c().getY() / SIZE) + 1] == 1);
    }

    private boolean moveD(Block block) {
        return (MESH[(int) block.d().getX() / SIZE][((int) block.d().getY() / SIZE) + 1] == 1);
    }

}
