package application;

import javafx.scene.shape.Rectangle;

public class SBlock extends Block {

    public SBlock(Rectangle a, Rectangle b, Rectangle c, Rectangle d){
        super(a,b,c,d);
    }

    public SBlock(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name){
        super(a,b,c,d,name);
    }

    @Override
    public void rotateBlock() {
        int r = this.rotation;

        if (r == 1 && canMove(a, -1, -1) && canMove(c, -1, 1) && canMove(d, 0, 2)) {
            MoveDown(this.a());
            MoveLeft(this.a());
            MoveLeft(this.c());
            MoveUp(this.c());
            MoveUp(this.d());
            MoveUp(this.d());
            this.changeRotation();
        }
        if (r == 2 && canMove(a, 1, 1) && canMove(c, 1, -1) && canMove(d, 0, -2)) {
            MoveUp(this.a());
            MoveRight(this.a());
            MoveRight(this.c());
            MoveDown(this.c());
            MoveDown(this.d());
            MoveDown(this.d());
            this.changeRotation();
        }
        if (r == 3 && canMove(a, -1, -1) && canMove(c, -1, 1) && canMove(d, 0, 2)) {
            MoveDown(this.a());
            MoveLeft(this.a());
            MoveLeft(this.c());
            MoveUp(this.c());
            MoveUp(this.d());
            MoveUp(this.d());
            this.changeRotation();
        }
        if (r == 4 && canMove(a, 1, 1) && canMove(c, 1, -1) && canMove(d, 0, -2)) {
            MoveUp(this.a());
            MoveRight(this.a());
            MoveRight(this.c());
            MoveDown(this.c());
            MoveDown(this.d());
            MoveDown(this.d());
            this.changeRotation();
        }
    }
}
