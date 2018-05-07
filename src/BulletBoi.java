import java.awt.*;

public class BulletBoi extends SpriteBoi {
  
    //OBJECTS
    GameBoi gameBoi;
    BoardBoi boardBoi;
    GameBoardBoi gameBoardBoi;

    //VARIABLES
    String colour, element;
    Color color;
    int x, y, xSize;
    int atk, spd, def, luck;
  
    //CONSTRUCTOR
    public BulletBoi(GameBoi gameBoi, BoardBoi boardBoi, PlayerBoi playerBoi, GameBoardBoi gameBoardBoi){
        super();
        this.gameBoi = gameBoi;
        this.boardBoi = boardBoi;
        this.gameBoardBoi = gameBoardBoi;
        setupStats(playerBoi);
    }
  
    //METHODS
    public void setupStats(PlayerBoi playerBoi){
        this.x = playerBoi.getX() + 25;
        this.y = playerBoi.getY() + 25;
        this.xSize = 20;
        this.color = playerBoi.setColor();
        this.element = playerBoi.getElement();
        this.atk = playerBoi.getAtk();
        this.spd = playerBoi.getSpd();
        this.def = playerBoi.getDef();
        this.luck = playerBoi.getLuck();
    }


    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x - xSize/2, y - xSize/2, xSize, xSize);
    }

    public void move(double angle){
        angle *= (Math.PI / 180.00);
        double yANGLE = Math.sin(angle)*10;
        double xANGLE = Math.cos(angle)*10;

        x+=xANGLE;
        y-=yANGLE;
    }

    public void move(int x, int y){

    }

    public void collideWithObstacle(ObstacleBoi obstacleBoi){

    }

    public void collideWithBoss(BossBoi bossBoi){

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
