import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BoardBoi extends JPanel implements ActionListener {

    //OBJECTS
    Timer timer;
    PlayerBoi playerBoi;
    GameBoi gameBoi;
    GameBoardBoi gameBoardBoi;

    //VARIABLES
    long currentTime = System.currentTimeMillis();

    //CONSTRUCTORS
    public BoardBoi(GameBoi gameBoi){
        setPreferredSize(new Dimension(600,800));
        setBackground(Color.BLACK);
        this.gameBoi = gameBoi;
        timer = new Timer(1000/60, this);
        timer.start();
        gameBoardBoi = new GameBoardBoi(gameBoi, this);
        playerBoi = new PlayerBoi(gameBoi, this, gameBoardBoi);

    }

    //IMPLEMENTED METHODS
    @Override
    public void actionPerformed(ActionEvent e){
        if(playerBoi != null) {
            playerBoi.move();
            for (int i = 0; i < gameBoardBoi.getLevels() * 15; i++) {
                for (int j = 0; j < 5; j++) {
                    playerBoi.collideWithObstacle(gameBoardBoi.getObstacleBoi(i, j));
                }
            }
        }
        gameBoardBoi.move(playerBoi);
        gameBoardBoi.checkDeaths();
        repaint();
    }


    //METHODS
    public void paintComponent(Graphics g){
        if(playerBoi != null) {
            if (!playerBoi.checkDeath()) {
                super.paintComponent(g);
                gameBoardBoi.paint(g);
                playerBoi.paint(g);
                paintingCriticallyImportantStrings(g);
            } else {
                for (int i = 0; i < gameBoardBoi.getLevels(); i++) {
                    for (int j = 0; j < 5; j++) {
                        gameBoardBoi.setObstacleBoi(i, j, null);
                        g.clearRect(0, 0, this.getWidth(), this.getHeight());
                        g.setColor(Color.GRAY);
                        g.fillRect(0, 0, this.getWidth(), this.getHeight());
                    }
                }
                printSimpleString("YOU LOST", 200, this.getWidth() / 2 - 100, this.getHeight() / 2, g);
            }
        }
    }

    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g2d){
        g2d.setFont(new Font("Serif", 32, 32));
        g2d.setColor(Color.black);
        int stringLen = (int)g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        int start = width/2 - stringLen/2;
        g2d.drawString(s, start + XPos, YPos);
    }

    public void paintingCriticallyImportantStrings(Graphics g){
        int[][] x = gameBoardBoi.getX();
        int[][] y = gameBoardBoi.getY();
        for(int i = 0; i < gameBoardBoi.getLevels() * 15; i++){
            for(int j = 0; j < 5; j++){
                if(gameBoardBoi.getObstacleBoi(i,j) != null)
                printSimpleString(Integer.toString(gameBoardBoi.getObstacleBoi(i,j).getHp()), 125,
                        gameBoardBoi.getObstacleBoi(i, j).getX() - 60,
                        gameBoardBoi.getObstacleBoi(i, j).getY() + 8, g);
            }
        }
        printSimpleString(Integer.toString(playerBoi.getHp()), 125, playerBoi.getX()-35, playerBoi.getY()+35, g);
    }




    //GETTERS/SETTERS

}
