import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerBoi extends SpriteBoi {

    //OBJECTS
    private GameBoi gameBoi;
    private BoardBoi boardBoi;
    private List<BulletBoi> bullets;
    private GameBoardBoi gameBoardBoi;
    
    //VARIABLES
    private String color, element;
    private int x, y, xSize;
    private int realX, realY;
    private int hp, atk, spd, def, luck;

    //CONSTRUCTOR
    public PlayerBoi(GameBoi gameBoi, BoardBoi boardBoi, GameBoardBoi gameBoardBoi){
        super();
        this.color = super.getColor();
        this.element = super.getElement();
        this.bullets = new ArrayList<>();
        this.x = 275;
        this.y = 700;
        this.xSize = 50;
        this.realX = x + xSize/2;
        this.realY = y + xSize/2;
        this.gameBoi = gameBoi;
        this.boardBoi = boardBoi;
        this.gameBoardBoi = gameBoardBoi;
        setupStats(this.element);
    }

    //METHODS
    public void setupStats(String element){
        if(element.equals("spark")){
            this.hp = 50;
            this.atk = 12;
            this.spd = 15;
            this.def = 7;
            this.luck = 10;
        }
        if(element.equals("water")){
            this.hp = 35;
            this.atk = 18;
            this.spd = 18;
            this.def = 7;
            this.luck = 12;
        }
        if(element.equals("fire")){
            this.hp = 40;
            this.atk = 16;
            this.spd = 14;
            this.def = 13;
            this.luck = 7;
        }
        if(element.equals("ice")){
            this.hp = 52;
            this.atk = 14;
            this.spd = 11;
            this.def = 7;
            this.luck = 8;
        }
        if(element.equals("speedy")){
            this.hp = 30;
            this.atk = 14;
            this.spd = 25;
            this.def = 5;
            this.luck = 16;
        }
        if(element.equals("sturdy")){
            this.hp = 70;
            this.atk = 25;
            this.spd = 5;
            this.def = 24;
            this.luck = 0;
        }
        if(element.equals("archer")){
            this.hp = 55;
            this.atk = 20;
            this.spd = 10;
            this.def = 10;
            this.luck = 2;
        }
        if(element.equals("flier")){
            this.hp = 40;
            this.atk = 16;
            this.spd = 19;
            this.def = 16;
            this.luck = 13;
        }
    }


    public void paint(Graphics g){
        g.setColor(super.returnColor());
        g.fillRect(x, y, xSize, xSize);
        for(BulletBoi b: bullets){
            b.paint(g);
        }
    }

    public void move(){
        if(element.equals("flier")){
            if(gameBoi.isUpPressed()){
                y -= this.spd;
                realY -= this.spd;
            }
            if(gameBoi.isDownPressed()){
                y += this.spd;
                realY += this.spd;
            }
            if(gameBoi.isLeftPressed()){
                x-= this.spd;
                realX -= this.spd;
            }
            if(gameBoi.isRightPressed()){
                x += this.spd;
                realX += this.spd;
            }
        }
        else{
            if(gameBoi.isLeftPressed()){
                x-= this.spd;
                realX -= this.spd;
            }
            if(gameBoi.isRightPressed()){
                x += this.spd;
                realX += this.spd;
            }
        }
        if(x <= -xSize/2 && gameBoi.isLeftPressed()){
            x = boardBoi.getWidth();
            realX = x + xSize/2;
        }
        if(x >= boardBoi.getWidth() && gameBoi.rightPressed){
            x = -xSize/2;
            realX = x + xSize/2;
        }
        if(y >= boardBoi.getHeight() - xSize){
            y = boardBoi.getHeight() - xSize;
            realY = y + xSize/2;
        }
        if(y <= 0){
            y = 0;
            realY = y + xSize/2;
        }

        if(gameBoi.isSpacePressed()){
            bullets.add(new BulletBoi(gameBoi, boardBoi, this, gameBoardBoi));
        }
        for(int i = 0; i < bullets.size(); i++){
            if(this.element.equals("archer")){
                switch(i % 3){
                    case 0: {
                        bullets.get(i).move(90);
                        break;
                    }
                    case 1: {
                        bullets.get(i).move(60);
                        break;
                    }
                    case 2:{
                        bullets.get(i).move(120);
                        break;
                    }
                }
            }
            bullets.get(i).move(90);
            gameBoardBoi.collideWithBullet(bullets.get(i));
            if(bullets.get(i).checkBounds())
                bullets.remove(i);
        }
    }

    public void collideWithObstacle(ObstacleBoi obstacleBoi){
        if(obstacleBoi != null) {
            int leftX = obstacleBoi.getX() - obstacleBoi.getXSize() / 2;
            int rightX = obstacleBoi.getX() + obstacleBoi.getXSize() / 2;
            int topY = obstacleBoi.getY() - obstacleBoi.getXSize() / 2;
            int bottomY = obstacleBoi.getY() + obstacleBoi.getXSize() / 2;

            if (this.realX >= leftX && this.realX <= rightX && this.realY >= topY && this.realY <= bottomY) {
                if(obstacleBoi.isCopyable() && obstacleBoi.getHp() <= 0){
                    this.element = obstacleBoi.getElement();
                    this.setElement(obstacleBoi.getElement());
                    this.color = super.getColor();
                    this.setupStats(this.element);
                }
                else {
                    this.hp = 0;
                }
            }
        }

    }


    public boolean checkDeath(){
        if (this.hp <= 0){
            return true;
        }
        else{
            return false;
        }
    }
           
    //GETTERS/SETTERS
    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getXSize() {
        return xSize;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getHp() {
        return hp;
    }

    public int getLuck() {
        return luck;
    }

    public int getSpd() {
        return spd;
    }
}
