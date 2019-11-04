package application;

import javafx.scene.shape.Rectangle;

public class JBlock extends Block {

    public JBlock(Rectangle a, Rectangle b, Rectangle c, Rectangle d){
        super(a,b,c,d);
    }

    public JBlock(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name){
        super(a,b,c,d,name);
    }

    @Override
    public void rotateBlock() {
        int r = this.rotation;

        if (r == 1 && canMove(a, 1, -1) && canMove(c, -1, -1) && canMove(d, -2, -2)) {
            MoveRight(this.a);
            MoveDown(this.a);
            MoveDown(this.c);
            MoveLeft(this.c);
            MoveDown(this.d);
            MoveDown(this.d);
            MoveLeft(this.d);
            MoveLeft(this.d);
            this.changeRotation();
        }
        if (r == 2 && canMove(a, -1, -1) && canMove(c, -1, 1) && canMove(d, -2, 2)) {
            MoveDown(this.a);
            MoveLeft(this.a);
            MoveLeft(this.c);
            MoveUp(this.c);
            MoveLeft(this.d);
            MoveLeft(this.d);
            MoveUp(this.d);
            MoveUp(this.d);
            this.changeRotation();
        }
        if (r == 3 && canMove(a, -1, 1) && canMove(c, 1, 1) && canMove(d, 2, 2)) {
            MoveLeft(this.a);
            MoveUp(this.a);
            MoveUp(this.c);
            MoveRight(this.c);
            MoveUp(this.d);
            MoveUp(this.d);
            MoveRight(this.d);
            MoveRight(this.d);
            this.changeRotation();
        }
        if (r == 4 && canMove(a, 1, 1) && canMove(c, 1, -1) && canMove(d, 2, -2)) {
            MoveUp(this.a);
            MoveRight(this.a);
            MoveRight(this.c);
            MoveDown(this.c);
            MoveRight(this.d);
            MoveRight(this.d);
            MoveDown(this.d);
            MoveDown(this.d);
            this.changeRotation();
        }
    }
}
