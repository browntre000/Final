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
    List<BulletBoi> bullets = new ArrayList<BulletBoi>();

    //VARIABLES
    long currentTime = System.currentTimeMillis();

    //CONSTRUCTORS
    public BoardBoi(GameBoi gameBoi){
        setPreferredSize(new Dimension(600,800));
        setBackground(Color.BLACK);
        this.gameBoi = gameBoi;
        timer = new Timer(1000/60, this);
        timer.start();
        playerBoi = new PlayerBoi(gameBoi, this);
        playerBoi.setupStats();


    }

    //IMPLEMENTED METHODS
    @Override
    public void actionPerformed(ActionEvent e){
        playerBoi.move();
        if(gameBoi.isSpacePressed()){
            long newTime = System.currentTimeMillis();
            if(currentTime - newTime >= 3000) {
                bullets.add(new BulletBoi(gameBoi, this, playerBoi));
                currentTime = newTime;
            }
        }
        for(BulletBoi b: bullets){
            b.move();
        }
        repaint();
    }


    //METHODS
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        playerBoi.paint(g);
        for(BulletBoi b: bullets){
            long newTime = System.currentTimeMillis();
            if(currentTime - newTime >= 3000) {
                b.paint(g);
            }
        }
    }




    //GETTERS/SETTERS

}
