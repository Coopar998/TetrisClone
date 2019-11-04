package application;

import javafx.scene.shape.Rectangle;

public class IBlock extends Block {

    public IBlock(Rectangle a, Rectangle b, Rectangle c, Rectangle d){
        super(a,b,c,d);
    }

    public IBlock(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name){
        super(a,b,c,d,name);
    }

    @Override
    public void rotateBlock() {
        int r = this.rotation;

        if (r == 1 && canMove(a, 2, 2) && canMove(b, 1, 1) && canMove(d, -1, -1)) {
            MoveUp(this.a());
            MoveUp(this.a());
            MoveRight(this.a());
            MoveRight(this.a());
            MoveUp(this.b());
            MoveRight(this.b());
            MoveDown(this.d());
            MoveLeft(this.d());
            this.changeRotation();
        }
        if (r == 2 && canMove(a, -2, -2) && canMove(b, -1, -1) && canMove(d, 1, 1)) {
            MoveDown(this.a());
            MoveDown(this.a());
            MoveLeft(this.a());
            MoveLeft(this.a());
            MoveDown(this.b());
            MoveLeft(this.b());
            MoveUp(this.d());
            MoveRight(this.d());
            this.changeRotation();
        }
        if (r == 3 && canMove(a, 2, 2) && canMove(b, 1, 1) && canMove(d, -1, -1)) {
            MoveUp(this.a());
            MoveUp(this.a());
            MoveRight(this.a());
            MoveRight(this.a());
            MoveUp(this.b());
            MoveRight(this.b());
            MoveDown(this.d());
            MoveLeft(this.d());
            this.changeRotation();
        }
        if (r == 4 && canMove(a, -2, -2) && canMove(b, -1, -1) && canMove(d, 1, 1)) {
            MoveDown(this.a());
            MoveDown(this.a());
            MoveLeft(this.a());
            MoveLeft(this.a());
            MoveDown(this.b());
            MoveLeft(this.b());
            MoveUp(this.d());
            MoveRight(this.d());
            this.changeRotation();
        }
    }
}
