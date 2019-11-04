package application;

import javafx.scene.shape.Rectangle;

public class LBlock extends Block {

    public LBlock(Rectangle a, Rectangle b, Rectangle c, Rectangle d){
        super(a,b,c,d);
    }

    public LBlock(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name){
        super(a,b,c,d,name);
    }

    @Override
    public void rotateBlock() {
        int r = this.rotation;

        if (r == 1 && canMove(a, 1, -1) && canMove(c, 1, 1) && canMove(b, 2, 2)) {
            MoveRight(this.a());
            MoveDown(this.a());
            MoveUp(this.c());
            MoveRight(this.c());
            MoveUp(this.b());
            MoveUp(this.b());
            MoveRight(this.b());
            MoveRight(this.b());
            this.changeRotation();
        }
        if (r == 2 && canMove(a, -1, -1) && canMove(b, 2, -2) && canMove(c, 1, -1)) {
            MoveDown(this.a());
            MoveLeft(this.a());
            MoveRight(this.b());
            MoveRight(this.b());
            MoveDown(this.b());
            MoveDown(this.b());
            MoveRight(this.c());
            MoveDown(this.c());
            this.changeRotation();
        }
        if (r == 3 && canMove(a, -1, 1) && canMove(c, -1, -1) && canMove(b, -2, -2)) {
            MoveLeft(this.a());
            MoveUp(this.a());
            MoveDown(this.c());
            MoveLeft(this.c());
            MoveDown(this.b());
            MoveDown(this.b());
            MoveLeft(this.b());
            MoveLeft(this.b());
            this.changeRotation();
        }
        if (r == 4 && canMove(a, 1, 1) && canMove(b, -2, 2) && canMove(c, -1, 1)) {
            MoveUp(this.a());
            MoveRight(this.a());
            MoveLeft(this.b());
            MoveLeft(this.b());
            MoveUp(this.b());
            MoveUp(this.b());
            MoveLeft(this.c());
            MoveUp(this.c());
            this.changeRotation();
        }
    }
}
