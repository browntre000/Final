import javax.swing.*;
import java.awt.event.*;

public class GameBoi extends JFrame implements KeyListener {

    //OBJECTS
    BoardBoi boardBoi;

    //VARIABLES
    boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed;

    //CONSTRUCTOR
    public GameBoi(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setFocusable(true);
        setTitle("FINAL PROJECT");
        boardBoi = new BoardBoi(this);
        add(boardBoi);
        pack();
        setLocationRelativeTo(null);
        addKeyListener(this);
    }

    //MAIN METHOD
    public static void main(String[] args){
        new GameBoi();
    }

    //IMPLEMENTED
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

    //GETTERS/SETTERS
    public boolean isRightPressed() {
        return rightPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }

    
    public boolean isLeftPressed() {
        return leftPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    
    public boolean isDownPressed() {
        return downPressed;
    }

    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }

    
    public boolean isUpPressed() {
        return upPressed;
    }

    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }

    
    public boolean isSpacePressed() {
        return spacePressed;
    }

    public void setSpacePressed(boolean spacePressed) {
        this.spacePressed = spacePressed;
    }

    
    public BoardBoi getBoardBoi() {
        return boardBoi;
    }

    public void setBoardBoi(BoardBoi boardBoi) {
        this.boardBoi = boardBoi;
    }
}
