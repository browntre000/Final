import java.awt.*;
import java.util.Random;

public class GameBoardBoi extends SpriteBoi {

    //OBJECTS
    ObstacleBoi[][] gameBoard;
    int[][] x;
    int[][] y;
    GameBoi gameBoi;
    BoardBoi boardBoi;
    Random rand;

    //VARIABLES
    int levels;

    //CONSTRUCTOR
    public GameBoardBoi(GameBoi gb, BoardBoi bb ){
        this.gameBoi = gb;
        this.boardBoi = bb;
        this.levels = random.nextInt(15) + 15;
        gameBoard = new ObstacleBoi[15*levels][5];
        x = new int[15*levels][5];
        y = new int[15*levels][5];
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[0].length; j++){
                gameBoard[i][j] = new ObstacleBoi(gameBoi,boardBoi,j*(600/5)+(600/10), -i*600-50, random.nextInt(8000) + 3000);
                x[i][j] = gameBoard[i][j].getX();
                y[i][j] = gameBoard[i][j].getY();
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


    public void collideWithBullet(BulletBoi bulletBoi){
        for(ObstacleBoi[] ob: gameBoard){
            for(ObstacleBoi ob2: ob){
                if (ob2 != null) {
                    ob2.collideWithBullet(bulletBoi);
                }
            }
        }
    }

    public void collideWithPlayer(PlayerBoi playerBoi){
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[0].length; j++){
                if (gameBoard[i][j] != null) {
                    if(gameBoard[i][j].collideWithPlayer(playerBoi)){
                        gameBoard[i][j] = null;
                    }
                }
            }
        }
    }

    public void checkDeaths(){
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[0].length; j++){
                if (gameBoard[i][j] != null) {
                    if(gameBoard[i][j].isDead()){
                        gameBoard[i][j] = null;
                    }
                }
            }
        }
    }



    //GETTERS/SETTERS

    public ObstacleBoi getObstacleBoi(int x, int y){
        return gameBoard[x][y];
    }
    public void setObstacleBoi(int x, int y, ObstacleBoi boi){
        this.gameBoard[x][y] = boi;
    }

    public int[][] getX() {
        return this.x;
    }

    public int[][] getY() {
        return this.y;
    }

    public int getLevels(){
        return this.levels;
    }

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