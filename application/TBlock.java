package application;

import javafx.scene.shape.Rectangle;

public class TBlock extends Block {

    public TBlock(Rectangle a, Rectangle b, Rectangle c, Rectangle d){
        super(a,b,c,d);
    }

    public TBlock(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name){
        super(a,b,c,d,name);
    }

    @Override
    public void rotateBlock() {
        int r = this.rotation;

        if (r == 1 && canMove(a, 1, 1) && canMove(d, -1, -1) && canMove(c, -1, 1)) {
            MoveUp(this.a());
            MoveRight(this.a());
            MoveDown(this.d());
            MoveLeft(this.d());
            MoveLeft(this.c());
            MoveUp(this.c());
            this.changeRotation();
        }
        if (r == 2 && canMove(a, 1, -1) && canMove(d, -1, 1) && canMove(c, 1, 1)) {
            MoveRight(this.a());
            MoveDown(this.a());
            MoveLeft(this.d());
            MoveUp(this.d());
            MoveUp(this.c());
            MoveRight(this.c());
            this.changeRotation();
        }
        if (r == 3 && canMove(a, -1, -1) && canMove(d, 1, 1) && canMove(c, 1, -1)) {
            MoveDown(this.a());
            MoveLeft(this.a());
            MoveUp(this.d());
            MoveRight(this.d());
            MoveRight(this.c());
            MoveDown(this.c());
            this.changeRotation();
        }
        if (r == 4 && canMove(a, -1, 1) && canMove(d, 1, -1) && canMove(c, -1, -1)) {
            MoveLeft(this.a());
            MoveUp(this.a());
            MoveRight(this.d());
            MoveDown(this.d());
            MoveDown(this.c());
            MoveLeft(this.c());
            this.changeRotation();
        }
    }
}
