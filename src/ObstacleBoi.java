import javafx.scene.shape.Circle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstacleBoi extends SpriteBoi {
  
    //OBJECTS
    private List<BulletBoi> bullets;
    private GameBoi gameBoi;
    private BoardBoi boardBoi;
    private Random random = new Random();

    //VARIABLES
    private int x, y, xSize;
    private String color, element;
    private int def, atk, hp;
    private boolean isCopyable;

    //CONSTRUCTOR
    public ObstacleBoi(GameBoi gb, BoardBoi bb, int x, int y, int hp){
        super();
        this.xSize = 600/5;
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.atk = hp/50;
        this.color = super.getColor();
        this.element = super.getElement();
        this.gameBoi = gb;
        this.boardBoi = bb;
        this.isCopyable = (random.nextInt(10) <= 1);
        bullets = new ArrayList<>();
    }

    //METHODS
    public void paint(Graphics g){
        g.setColor(returnColor());
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
        int leftX = this.getX() - this.getXSize()/2;
        int rightX = this.getX() + this.getXSize()/2;
        int topY = this.getY() - this.getXSize()/2;
        int bottomY = this.getY() + this.getXSize()/2;

        if(bb.getX() >= leftX && bb.getX() <= rightX && bb.getY() >= topY && bb.getY() <= bottomY){
            this.hp -= bb.getAtk();
        }
        if(isCopyable){
            if(this.hp <= 0)
                this.hp = 0;
        }
    }

    public boolean collideWithPlayer(PlayerBoi playerBoi){
        int leftX = this.getX() - this.getXSize()/2;
        int rightX = this.getX() + this.getXSize()/2;
        int topY = this.getY() - this.getXSize()/2;
        int bottomY = this.getY() + this.getXSize()/2;

        if(playerBoi.getX() >= leftX && playerBoi.getX() <= rightX && playerBoi.getY() >= topY && playerBoi.getY() <= bottomY){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isDead(){
        if(this.hp <= 0 && this.isCopyable){
            this.xSize = 100;
            return false;
        }
        else if(this.hp <= 0){
            return true;
        }
        else{
            return false;
        }
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

    public int getAtk(){
        return this.atk;
    }
    public boolean isCopyable(){
        return isCopyable;
    }
}
