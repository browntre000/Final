import java.awt.*;

public class PlayerBoi extends SpriteBoi {

    //OBJECTS
    GameBoi gameBoi;
    BoardBoi boardBoi;
    
    //VARIABLES
    String color, element;
    int x, y, xSize;
    int hp, atk, spd, def, luck;

    //CONSTRUCTOR
    public PlayerBoi(GameBoi gameBoi, BoardBoi boardBoi){
        super();
        this.color = super.getColor();
        this.element = super.getElement();
        this.x = 275;
        this.y = 700;
        this.xSize = 50;
        this.gameBoi = gameBoi;
        this.boardBoi = boardBoi;
    }

    //METHODS
    public void setupStats(){
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
        g.fillRect(x, y, xSize, xSize);
    }

    public void move(){
        if(element.equals("flier")){
            if(gameBoi.isUpPressed()){
                y -= this.spd;
            }
            if(gameBoi.isDownPressed()){
                y += this.spd;
            }
            if(gameBoi.isLeftPressed()){
                x-= this.spd;
            }
            if(gameBoi.isRightPressed()){
                x += this.spd;
            }
        }
        else{
            if(gameBoi.isLeftPressed()){
                x-= this.spd;
            }
            if(gameBoi.isRightPressed()){
                x += this.spd;
            }
        }
        if(x <= -xSize/2 && gameBoi.isLeftPressed()){
            x = boardBoi.getWidth() - (xSize/2);
        }
        if(x >= boardBoi.getWidth() - (xSize/2) && gameBoi.rightPressed){
            x = -xSize/2;
        }
        if(y >= boardBoi.getHeight() - xSize){
            y = boardBoi.getHeight() - xSize;
        }
        if(y <= 0){
            y = 0;
        }
    }
           
    //GETTERS/SETTERS
    public String getColor(){
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getElement() {
        return element;
    }

    @Override
    public void setElement(String element) {
        this.element = element;
    }

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
