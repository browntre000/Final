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
            for(BulletBoi bb: bullets){
                if(bb != null) {
                    bb.paint(g);
                }
            }
        }
        else{
            g.fillRect(x - xSize/2 , y - xSize/2, xSize, xSize);
        }
    }


    public void move(PlayerBoi playerBoi){
        y += 5;
    }

    public void collideWithBullet(BulletBoi bb){
        int leftX = this.getX() - this.getXSize()/2;
        int rightX = this.getX() + this.getXSize()/2;
        int topY = this.getY() - this.getXSize()/2;
        int bottomY = this.getY() + this.getXSize()/2;

        if(bb.getX() >= leftX && bb.getX() <= rightX && bb.getY() >= topY && bb.getY() <= bottomY){
            if(this.element.equals("spark") && bb.getElement().equals("water")){
                this.hp -= (int) (0.1 * bb.getAtk());
            }
            else if(this.element.equals("water") && bb.getElement().equals("fire")){
                this.hp -= (int) (0.1 * bb.getAtk());
            }
            else if(this.element.equals("fire") && bb.getElement().equals("ice")){
                this.hp -= (int) (0.1 * bb.getAtk());
            }
            else if(this.element.equals("ice") && bb.getElement().equals("spark")){
                this.hp -= (int) (0.1 * bb.getAtk());
            }
            else if(this.element.equals("speedy") && bb.getElement().equals("sturdy")){
                this.hp -= (int) (0.1 * bb.getAtk());
            }
            else if(this.element.equals("sturdy") && bb.getElement().equals("archer")){
                this.hp -= (int) (0.1 * bb.getAtk());
            }
            else if(this.element.equals("archer") && bb.getElement().equals("flier")){
                this.hp -= (int) (0.1 * bb.getAtk());
            }
            else if(this.element.equals("flier") && bb.getElement().equals("speedy")){
                this.hp -= (int) (0.1 * bb.getAtk());
            }
            else if(this.element.equals("water") && bb.getElement().equals("spark")){
                this.hp -= (int) (1.2 * bb.getAtk());
            }
            else if(this.element.equals("fire") && bb.getElement().equals("water")){
                this.hp -= (int) (1.2 * bb.getAtk());
            }
            else if(this.element.equals("ice") && bb.getElement().equals("fire")){
                this.hp -= (int) (1.2 * bb.getAtk());
            }
            else if(this.element.equals("spark") && bb.getElement().equals("ice")){
                this.hp -= (int) (1.2 * bb.getAtk());
            }
            else if(this.element.equals("sturdy") && bb.getElement().equals("speedy")){
                this.hp -= (int) (1.2 * bb.getAtk());
            }
            else if(this.element.equals("archer") && bb.getElement().equals("sturdy")){
                this.hp -= (int) (1.2 * bb.getAtk());
            }
            else if(this.element.equals("flier") && bb.getElement().equals("archer")){
                this.hp -= (int) (1.2 * bb.getAtk());
            }
            else if(this.element.equals("speedy") && bb.getElement().equals("flier")){
                this.hp -= (int) (1.2 * bb.getAtk());
            }
            else{
                this.hp -= bb.getAtk();
            }
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
