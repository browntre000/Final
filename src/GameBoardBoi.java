import java.awt.*;

public class GameBoardBoi extends SpriteBoi {

    //OBJECTS
    ObstacleBoi[][] gameBoard;
    GameBoi gameBoi;
    BoardBoi boardBoi;

    //VARIABLES
    int levels;

    //CONSTRUCTOR
    public GameBoardBoi(GameBoi gb, BoardBoi bb, int levels){
        this.gameBoi = gb;
        this.boardBoi = bb;
        this.levels = levels;
        gameBoard = new ObstacleBoi[levels + 15][5];
    }

    //METHODS
    public void paint(Graphics g){

    }

    //GETTERS/SETTERS

}