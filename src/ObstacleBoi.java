import javafx.scene.shape.Circle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ObstacleBoi extends SpriteBoi {
  
    //OBJECTS
    List<BulletBoi> bullets;
    GameBoi gameBoi;
    BoardBoi boardBoi;
    PlayerBoi playerBoi;

    //VARIABLES
    int x, y, xSize;
    String color, element;
    int def, atk, hp;
    boolean isCopyable;

    //CONSTRUCTOR
    public ObstacleBoi(GameBoi gb, BoardBoi bb, int x, int y, int hp){
        super();
        this.xSize = 600/5;
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.color = super.getColor();
        this.element = super.getElement();
        this.gameBoi = gb;
        this.boardBoi = bb;
        this.isCopyable = (random.nextInt(10) <= 1);
        bullets = new ArrayList<>();
    }

    //METHODS
    public void paint(Graphics g){
        g.setColor(setColor());
        if(isCopyable){
            g.fillOval(x - xSize/2 , y - xSize/2, xSize, xSize);
        }
        else{
            g.fillRect(x - xSize/2 , y - xSize/2, xSize, xSize);
        }
    }


    public void move(){
        y += 5;
    }

    public void collideWithBullet(BulletBoi bb){

    }

    public void collideWithPlayer(PlayerBoi playerBoi){

    }

    //GETTERS/SETTERS

    public int getHp() {
        return hp;
    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }

    public int getXSize() {
        return xSize;
    }
}
