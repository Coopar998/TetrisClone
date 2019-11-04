package application;

import javafx.scene.shape.Rectangle;

public class Controller {

    public static final int MOVE = Main.MOVE;
    public static final int SIZE = Main.SIZE;
    public static int XMAX = Main.XMAX;
    public static int YMAX = Main.YMAX;
    public static int [][] MESH = Main.MESH;

    //MOVING THE BLOCKS

    //Move Right
    public static void MoveRight(Block block){
        if(block.a().getX() + MOVE <= XMAX - SIZE && block.b().getX() + MOVE <= XMAX - SIZE
                && block.c().getX() + MOVE <= XMAX - SIZE && block.d().getX() + MOVE <= XMAX - SIZE){

            int moveA = MESH[(int) block.a().getX()/SIZE + 1][(int) block.a().getY()/SIZE];
            int moveB = MESH[(int) block.b().getX()/SIZE + 1][(int) block.b().getY()/SIZE];
            int moveC = MESH[(int) block.c().getX()/SIZE + 1][(int) block.c().getY()/SIZE];
            int moveD = MESH[(int) block.d().getX()/SIZE + 1][(int) block.d().getY()/SIZE];

            if(moveA == 0 && moveB == 0 && moveC == 0 && moveD == 0){
                block.a().setX(block.a().getX() + MOVE);
                block.b().setX(block.b().getX() + MOVE);
                block.c().setX(block.c().getX() + MOVE);
                block.d().setX(block.d().getX() + MOVE);
            }
        }
    }

    //Move Left
    public static void MoveLeft(Block block){
        if(block.a().getX() - MOVE >= 0 && block.b().getX() - MOVE >= 0
                && block.c().getX() - MOVE >= 0 && block.d().getX() - MOVE >= 0){

            int moveA = MESH[(int) block.a().getX()/SIZE - 1][(int) block.a().getY()/SIZE];
            int moveB = MESH[(int) block.b().getX()/SIZE - 1][(int) block.b().getY()/SIZE];
            int moveC = MESH[(int) block.c().getX()/SIZE - 1][(int) block.c().getY()/SIZE];
            int moveD = MESH[(int) block.d().getX()/SIZE - 1][(int) block.d().getY()/SIZE];

            if(moveA == 0 && moveB == 0 && moveC == 0 && moveD == 0){
                block.a().setX(block.a().getX() - MOVE);
                block.b().setX(block.b().getX() - MOVE);
                block.c().setX(block.c().getX() - MOVE);
                block.d().setX(block.d().getX() - MOVE);
            }
        }
    }

    //CREATE THE BLOCKS
    public static Block makeBlock(){

        //Random block
        int block = (int) (Math.random() * 70);
        String name;

        Rectangle a = new Rectangle(SIZE-1, SIZE-1), b = new Rectangle(SIZE-1, SIZE-1), c = new Rectangle(SIZE-1, SIZE-1),
                d = new Rectangle(SIZE-1, SIZE-1);
        if (block < 10) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "j";
            return new JBlock(a,b,c,d,name);
        } else if (block < 20) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "l";
            return new LBlock(a,b,c,d,name);
        } else if (block < 30) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 - SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2);
            d.setY(SIZE);
            name = "o";
            return new OBlock(a,b,c,d,name);
        } else if (block < 40) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 - SIZE);
            d.setY(SIZE);
            name = "s";
            return new SBlock(a,b,c,d,name);
        } else if (block < 50) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            name = "t";
            return new TBlock(a,b,c,d,name);
        } else if (block < 60) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 + SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE + SIZE);
            d.setY(SIZE);
            name = "z";
            return new ZBlock(a,b,c,d,name);
        } else {
            a.setX(XMAX / 2 - SIZE - SIZE);
            b.setX(XMAX / 2 - SIZE);
            c.setX(XMAX / 2);
            d.setX(XMAX / 2 + SIZE);
            name = "i";
            return new IBlock(a,b,c,d,name);
        }
    }

}
