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
    public Color setColor(){
        if(color.equals("red")){
            return Color.red;
        }
        else if(color.equals("green")){
            return Color.green;
        }
        else if(color.equals("blue")){
            return Color.blue;
        }
        else if(color.equals("light blue")){
            return new Color(0,191,255);
        }
        else if(color.equals("orange")){
            return Color.ORANGE;
        }
        else if(color.equals("brown")){
            return new Color(139,69,19);
        }
        else if(color.equals("gray")){
            return new Color(105,105,105);
        }
        else if(color.equals("white")){
            return Color.WHITE;
        }
        else{
            return Color.magenta;
        }
    }
    public void paint(Graphics g){
        g.setColor(setColor());
        if(isCopyable){
            g.fillOval(x - xSize/2 , y - xSize/2, xSize, xSize);
        }
        else{
            g.fillRect(x - xSize/2 , y - xSize/2, xSize, xSize);
        }
    }

    public boolean isInBounds(int y) {
        if(y < this.y+xSize/2 && y > this.y-xSize/2){
            return true;
        }
        else{
            return false;
        }
    }

    public void move(){
        y += 5;
    }

    public void collideWithBullet(BulletBoi bb){
        if(isInBounds(bb.getY()     )){
            this.hp -= bb.getAtk();
        }
    }

    //GETTERS/SETTERS

    public int getHp() {
        return hp;
    }
}
