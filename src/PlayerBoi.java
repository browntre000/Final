import java.awt.*;

public class PlayerBoi extends SpriteBoi {

    String color, element;
    int x, y, xSize;
    GameBoi gameBoi;
    int hp, atk, spd, def, luck;

    public PlayerBoi(GameBoi gameBoi){
        super();
        this.color = this.getColor();
        this.element = this.getElement();
        this.x = 600;
        this.y = 600;
        this.xSize = 25;
        this.gameBoi = gameBoi;
    }

    public void setup(){
        if(element.equals("spark")){
            
        }
        if(element.equals("water")){

        }
        if(element.equals("fire")){

        }
        if(element.equals("ice")){

        }
        if(element.equals("speedy")){

        }
        if(element.equals("sturdy")){

        }
        if(element.equals("archer")){

        }
        if(element.equals("flier")){

        }
    }

    public void paint(Graphics g){
        if(color.equals("red")){
            g.setColor(Color.red);
            g.fillRect(x,y,xSize,xSize);
        }
        if(color.equals("green")){
            g.setColor(Color.green);
            g.fillRect(x,y,xSize,xSize);
        }
        if(color.equals("blue")){
            g.setColor(Color.blue);
            g.fillRect(x,y,xSize,xSize);
        }
        if(color.equals("light blue")){
            g.setColor(new Color(0,191,255));
            g.fillRect(x,y,xSize,xSize);
        }
        if(color.equals("orange")){
            g.setColor(Color.ORANGE);
            g.fillRect(x,y,xSize,xSize);
        }
        if(color.equals("brown")){
            g.setColor(new Color(139,69,19));
            g.fillRect(x,y,xSize,xSize);
        }
        if(color.equals("gray")){
            g.setColor(new Color(105,105,105));
            g.fillRect(x,y,xSize,xSize);
        }
        if(color.equals("white")){
            g.setColor(Color.WHITE);
            g.fillRect(x,y,xSize,xSize);
        }
    }

    public void move(){
        if(element.equals("flier")){

        }
    }

}
