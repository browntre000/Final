import java.awt.*;

public class PlayerBoi extends SpriteBoi {

    String color, element;
    int x, y, xSize;
    GameBoi gameBoi;
    BoardBoi boardBoi;
    int hp, atk, spd, def, luck;

    public PlayerBoi(GameBoi gameBoi, BoardBoi boardBoi){
        super();
        this.color = this.getColor();
        this.element = this.getElement();
        this.x = 600;
        this.y = 600;
        this.xSize = 25;
        this.gameBoi = gameBoi;
        this.BoardBoi = boardBoi;
    }

    public void setup(){
        if(element.equals("spark")){
            this.hp = 50;
            this.atk = 12;
            this.spd = 25;
            this.def = 7;
            this.luck = 10;
        }
        if(element.equals("water")){
            this.hp = 35;
            this.atk = 18;
            this.spd = 28;
            this.def = 7;
            this.luck = 12;
        }
        if(element.equals("fire")){
            this.hp = 40;
            this.atk = 16;
            this.spd = 24;
            this.def = 13;
            this.luck = 7;
        }
        if(element.equals("ice"){
            this.hp = 52;
            this.atk = 14;
            this.spd = 21;
            this.def = 7;
            this.luck = 8;
        }
        if(element.equals("speedy")){
            this.hp = 30;
            this.atk = 14;
            this.spd = 35;
            this.def = 5;
            this.luck = 16;
        }
        if(element.equals("sturdy")){
            this.hp = 75;
            this.atk = 25;
            this.spd = 5;
            this.def = 15;
            this.luck = 0;
        }
        if(element.equals("archer")){
            this.hp = 55;
            this.atk = 15;
            this.spd = 20;
            this.def = 10;
            this.luck = 2;
        }
        if(element.equals("flier")){
            this.hp = 40;
            this.atk = 16;
            this.spd = 29;
            this.def = 16;
            this.luck = 13;
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
            if(gameBoi.isUpPressed()){
                y -= spd;
            }
            if(gameBoi.isDownPressed()){
                y += spd;
            }
            if(gameBoi.isLeftPressed()){
                x-= spd;
            }
            if(gameBoi.isRightPressed()){
                x += spd;
            }
        }
        else{
            if(gameBoi.isUpPressed()){
                y -= 0;
            }
            if(gameBoi.isDownPressed()){
                y += 0;
            }
            if(gameBoi.isLeftPressed()){
                x-= spd;
            }
            if(gameBoi.isRightPressed()){
                x += spd;
            }
        }
        if(x <= (xSize/2))
            x = boardBoi.getLength() - (xSize/2);
        if(x >= boardBoi.getLength() - (xSize/2))
            x = xSize/2;
        if(y >= boardBoi.getHeight() - (xSize/2))
            y = boardBoi.getHeight() - (xSize/2);
        if(y <= (xSize/2))
            y = xSize/2;
    }

}
