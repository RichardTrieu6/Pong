import javax.swing.*;
import java.awt.*;

class Paddles extends JPanel
  {
    //x and y variables are initiated
    int x;
    int y;
    public Paddles(int x, int y)
    {
      //x and y values are taken from draw class and updated
        this.x = x;
        this.y = y;
    }
    
    public void paint(Graphics g)
    {
        g.clearRect(0, 0, getWidth() ,getHeight());
        g.setColor(Color.WHITE);
        //paints the paddle
        g.fillRect(x, y, 10, 80);
    }
  }