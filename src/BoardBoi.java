import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardBoi extends JPanel implements ActionListener {

    //OBJECTS
    Timer timer;
    PlayerBoi playerBoi;

    //VARIABLES

    //CONSTRUCTORS
    public BoardBoi(GameBoi gameBoi){
        setPreferredSize(new Dimension(600,800));
        setBackground(Color.BLACK);
        timer = new Timer(1000/60, this);
        timer.start();
        playerBoi = new PlayerBoi(gameBoi, this);
        playerBoi.setupStats();
    }

    //IMPLEMENTED METHODS
    @Override
    public void actionPerformed(ActionEvent e){
        playerBoi.move();
        repaint();
    }


    //METHODS
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(playerBoi.setColor());
        playerBoi.paint(g);
    }

    //GETTERS/SETTERS

}
