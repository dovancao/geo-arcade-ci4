package game.square.circle;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.square.Square;

import java.util.Vector;

/**
 * Created by huynq on 3/15/18.
 */
public class CircleSquare extends GameObject {

    public Vector2D velocity;
    public Vector<Square> squareVector;
    public int count;

    public CircleSquare() {
       this.velocity = new Vector2D();
       this.squareVector = new Vector<>();
    }

    public void create() {
        for (double angle = 0.0; angle < 360.0; angle+=360.0/15) {
            Square square = new Square();
            Vector2D vector2D = new Vector2D(0, 80);     //vector goc
            Vector2D rotate = vector2D.rotate(angle);          //quay vector goc
            square.position.set(rotate).addUp(100, 100); //gan rotate vao position
            square.velocity.set(this.velocity);
            this.squareVector.add(square);
            GameObjectManager.instance.add(square);
        }
    }

    @Override
    public void run(){
        super.run();
        if(this.position.x >= 400 - 100){
             if(this.count >= 10){
                 this.count = 0;
                 this.velocity.set(1,1);
             }else {
                 this.count +=1;
                 this.velocity.set(-1,1);
             }
        }
        if(this.position.x < 100-20){
            if(this.count >= 10){
                this.count = 0;
                this.velocity.set(-1,1);
            }else {
                this.count +=1;
                this.velocity.set(1,1);
            }
        }
        this.position.addUp(this.velocity);
        this.squareVector.forEach(square -> square.velocity.set(velocity));
    }
}
