import java.awt.*;
import java.util.Random;

public class GameBoardBoi extends SpriteBoi {

    //OBJECTS
    ObstacleBoi[][] gameBoard;
    GameBoi gameBoi;
    BoardBoi boardBoi;
    Random rand;

    //VARIABLES
    int levels;

    //CONSTRUCTOR
    public GameBoardBoi(GameBoi gb, BoardBoi bb ){
        this.gameBoi = gb;
        this.boardBoi = bb;
        this.levels = random.nextInt(15);
        gameBoard = new ObstacleBoi[300][5];
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[0].length; j++){
                gameBoard[i][j] = new ObstacleBoi(gameBoi,boardBoi,j*(600/5)+(600/10), -i*600-50, random.nextInt(1000));
            }
        }
    }

    //METHODS

    public void paint(Graphics g){
        for(ObstacleBoi[] ob: gameBoard){
            for(ObstacleBoi ob2: ob){
                if (ob2 != null) {
                    ob2.paint(g);
                }
            }
        }
    }

    public void move(){
        for(ObstacleBoi[] ob: gameBoard){
            for(ObstacleBoi ob2: ob){
                if (ob2 != null) {
                    ob2.move();
                }
            }
        }
    }

    public boolean isInBounds(int y){
        for(ObstacleBoi[] ob: gameBoard){
            for(ObstacleBoi ob2: ob){
                if (ob2 != null) {
                    if (ob2.isInBounds(y)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void collideWithBullet(BulletBoi bulletBoi){
        for(ObstacleBoi[] ob: gameBoard){
            for(ObstacleBoi ob2: ob){
                if (ob2 != null) {
                    ob2.collideWithBullet(bulletBoi);
                }
            }
        }
    }

    public void checkDeaths(){
        for(ObstacleBoi[] ob: gameBoard){
            for(ObstacleBoi ob2: ob){
                if (ob2 != null) {
                    if(ob2.getHp()<=0){
                        ob2 = null;
                    }
                }
            }
        }
    }

    //GETTERS/SETTERS

    /*
    I got tired of copying this
    for(ObstacleBoi[] ob: gameBoard){
        for(ObstacleBoi ob2: ob){
            if (ob2 != null) {

            }
        }
    }
    */

}