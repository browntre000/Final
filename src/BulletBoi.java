import java.awt.*;

public class BulletBoi extends SpriteBoi {
  
    //OBJECTS
    GameBoi gameBoi;
    BoardBoi boardBoi;

    //VARIABLES
    String color, element;
    int x, y, xSize;
    int atk, spd, def, luck;
  
    //CONSTRUCTOR
    public BulletBoi(GameBoi gameBoi, BoardBoi boardBoi, PlayerBoi playerBoi){
        super();
        this.gameBoi = gameBoi;
        this.boardBoi = boardBoi;
        setupStats(playerBoi);
    }
  
    //METHODS
    public void setupStats(PlayerBoi playerBoi){
        this.x = playerBoi.getX();
        this.y = playerBoi.getY();
        this.xSize = 20;
        this.color = playerBoi.getColor();
        this.element = playerBoi.getElement();
        this.atk = playerBoi.getAtk();
        this.spd = playerBoi.getSpd();
        this.def = playerBoi.getDef();
        this.luck = playerBoi.getLuck();
    }

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
        g.fillOval(x, y, xSize, xSize);
    }

    public void move(){
        y -= 10;
        if(y <= -xSize){
            this.x = 300000;
            this.y = 300000;
            y += 0;
        }
    }
  
    //GETTERS/SETTERS
    public int getAtk() {
        return atk;
    }

    public int getSpd() {
        return spd;
    }

    public int getLuck() {
        return luck;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getDef() {
        return def;
    }

}
