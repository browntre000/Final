import javax.swing.*;
import java.awt.event.*;

public class GameBoi extends JFrame implements KeyListener {

    //Instances
    BoardBoi boardBoi;

    //Variables
    boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed;

    //Constructor
    public GameBoi(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setFocusable(true);
        setTitle("FINAL PROJECT");
        boardBoi = new BoardBoi();
        add(boardBoi);
        pack();
        setLocationRelativeTo(null);
        addKeyListener(this);
    }

    //MAIN METHOD
    public static void main(String[] args){
        new GameBoi();
    }

    //Implemented Methods
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
           this.setUpPressed(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            this.setDownPressed(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            this.setLeftPressed(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.setRightPressed(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            this.setSpacePressed(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            this.setUpPressed(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            this.setDownPressed(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            this.setLeftPressed(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.setRightPressed(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            this.setSpacePressed(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    //Getters/Setters

    //rightPressed
    public boolean isRightPressed() {
        return rightPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }

    //leftPressed
    public boolean isLeftPressed() {
        return leftPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    //downPressed
    public boolean isDownPressed() {
        return downPressed;
    }

    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }

    //upPressed
    public boolean isUpPressed() {
        return upPressed;
    }

    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }

    //spacePressed
    public boolean isSpacePressed() {
        return spacePressed;
    }

    public void setSpacePressed(boolean spacePressed) {
        this.spacePressed = spacePressed;
    }

    //boardBoi
    public BoardBoi getBoardBoi() {
        return boardBoi;
    }

    public void setBoardBoi(BoardBoi boardBoi) {
        this.boardBoi = boardBoi;
    }
}
