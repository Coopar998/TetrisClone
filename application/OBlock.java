package application;

import javafx.scene.shape.Rectangle;

public class OBlock extends Block {

    public OBlock(Rectangle a, Rectangle b, Rectangle c, Rectangle d){
        super(a,b,c,d);
    }

    public OBlock(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name){
        super(a,b,c,d,name);
    }

    @Override
    public void rotateBlock() {
    }
}
