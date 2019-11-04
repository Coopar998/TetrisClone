package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Block {
    protected Rectangle a;
    protected Rectangle b;
    protected Rectangle c;
    protected Rectangle d;
    protected String name;
    public int rotation = 1;

    public Block(Rectangle a, Rectangle b, Rectangle c, Rectangle d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        setColor();
    }

    public Block(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.name = name;
        setColor();
    }

    public Rectangle a() {
        return a;
    }

    public Rectangle b() {
        return b;
    }

    public Rectangle c() {
        return c;
    }

    public Rectangle d() {
        return d;
    }

    public void setColor(){

        Color color;

        //set the color of the blocks
        switch(name){
            case "j":
                color = Color.BLUE;
                break;
            case "l":
                color = Color.ORANGE;
                break;
            case "o":
                color = Color.GOLD;
                break;
            case "s":
                color = Color.LIMEGREEN;
                break;
            case "t":
                color = Color.PURPLE;
                break;
            case "z":
                color = Color.RED;
                break;
            case "i":
                color = Color.CYAN;
                break;
            default:
                color = Color.BLACK;
        }

        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);

    }

    //Getter
    public String getName(){
        return this.name;
    }

    public void changeRotation(){
        if(rotation != 4){
            rotation++;
        }else{
            rotation = 1;
        }
    }

    public abstract void rotateBlock();

    public boolean canMove(Rectangle rect, int x, int y){
        boolean yb = false;
        boolean xb = false;
        if(x >= 0){
            xb = rect.getX() + x*Main.MOVE <= Main.XMAX - Main.SIZE;
        }
        if(x < 0){
            xb = rect.getX() + x*Main.MOVE >= 0;
        }
        if(y >= 0){
            yb = rect.getY() + y*Main.MOVE > 0 ;
        }
        if(y < 0){
            yb = rect.getY() + y*Main.MOVE < Main.YMAX;
        }

        int indexX = ((int)rect.getX()/Main.SIZE) + x;
        int indexY = ((int)rect.getY()/Main.SIZE)-y;

        if(indexX >= 0 && indexY >= 0 && indexX < 12 && indexY < 24){
            return xb && yb  && Main.MESH[indexX][indexY] == 0;
        }else{
            return false;
        }
    }

    public void MoveDown(Rectangle rect) {
        if (rect.getY() + Main.MOVE < Main.YMAX)
            rect.setY(rect.getY() + Main.MOVE);

    }

    public void MoveRight(Rectangle rect) {
        if (rect.getX() + Main.MOVE <= Main.XMAX - Main.SIZE)
            rect.setX(rect.getX() + Main.MOVE);
    }

    public void MoveLeft(Rectangle rect) {
        if (rect.getX() - Main.MOVE >= 0)
            rect.setX(rect.getX() - Main.MOVE);
    }

    public void MoveUp(Rectangle rect) {
        if (rect.getY() - Main.MOVE > 0)
            rect.setY(rect.getY() - Main.MOVE);
    }

}
