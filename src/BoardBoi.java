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
        playerBoi.move();
        gameBoardBoi.move();
        gameBoardBoi.checkDeaths();
        repaint();
    }


    //METHODS
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        gameBoardBoi.paint(g);
        playerBoi.paint(g);
    }

    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g2d){
        int stringLen = (int)g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        int start = width/2 - stringLen/2;
        g2d.drawString(s, start + XPos, YPos);
    }




    //GETTERS/SETTERS

}
