import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ObstacleBoi extends SpriteBoi {
  
    //OBJECTS
    List<BulletBoi> bullets;
    GameBoi gameBoi;
    BoardBoi boardBoi;
    PlayerBoi playerBoi;
    List<Integer> yBounds;
    List<Integer> xBounds;

    //VARIABLES
    int x, y, xSize;
    String color, element;
    int def, atk, hp;
    boolean isCopiable;

    //CONSTRUCTOR
    public ObstacleBoi(GameBoi gb, BoardBoi bb, int x, int y, int hp){
        super();
        this.xSize = 600/5;
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.xBounds = new ArrayList<>();
        this.yBounds = new ArrayList<>();
        this.color = super.getColor();
        this.element = super.getElement();
        this.gameBoi = gb;
        this.boardBoi = bb;
        this.isCopiable = random.nextBoolean();
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
        if(isCopiable){
            g.fillOval(x - xSize/2 , y - xSize/2, xSize, xSize);
        }
        else{
            g.fillRect(x - xSize/2 , y - xSize/2, xSize, xSize);
        }
    }

    public void setBounds(List<Integer> xBounds) {
        if(isCopiable){
            for(int i = 0; i < xSize; i++){
                Integer newBoi = new Integer((int)Math.sqrt(xSize*xSize - y*y));
                if(i == 0){
                    xBounds.add(newBoi);
                }
                else{
                    Integer lastBoi = xBounds.get(i-1);
                    if(!lastBoi.equals(newBoi)){
                        xBounds.add(newBoi);
                    }
                }
            }
        }
        else{
            for(int i )
        }
    }

    public void move(){
        y += 5;
    }

    //GETTERS/SETTERS
  
}
