package application;

import javafx.scene.shape.Rectangle;

public class ZBlock extends Block {

    public ZBlock(Rectangle a, Rectangle b, Rectangle c, Rectangle d){
        super(a,b,c,d);
    }

    public ZBlock(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name){
        super(a,b,c,d,name);
    }

    @Override
    public void rotateBlock() {
        int r = this.rotation;

        if (r == 1 && canMove(b, 1, 1) && canMove(c, -1, 1) && canMove(d, -2, 0)) {
            MoveUp(this.b());
            MoveRight(this.b());
            MoveLeft(this.c());
            MoveUp(this.c());
            MoveLeft(this.d());
            MoveLeft(this.d());
            this.changeRotation();
        }
        if (r == 2 && canMove(b, -1, -1) && canMove(c, 1, -1) && canMove(d, 2, 0)) {
            MoveDown(this.b());
            MoveLeft(this.b());
            MoveRight(this.c());
            MoveDown(this.c());
            MoveRight(this.d());
            MoveRight(this.d());
            this.changeRotation();
        }
        if (r == 3 && canMove(b, 1, 1) && canMove(c, -1, 1) && canMove(d, -2, 0)) {
            MoveUp(this.b());
            MoveRight(this.b());
            MoveLeft(this.c());
            MoveUp(this.c());
            MoveLeft(this.d());
            MoveLeft(this.d());
            this.changeRotation();
        }
        if (r == 4 && canMove(b, -1, -1) && canMove(c, 1, -1) && canMove(d, 2, 0)) {
            MoveDown(this.b());
            MoveLeft(this.b());
            MoveRight(this.c());
            MoveDown(this.c());
            MoveRight(this.d());
            MoveRight(this.d());
            this.changeRotation();
        }
    }
}
