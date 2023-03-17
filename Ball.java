import javax.swing.*;
import java.awt.*;

class Ball extends JPanel
  {
    //x and y variables are initiated
    int x;
    int y;
    //x and y speed of the ball
    int speed_x = 2;
    int speed_y = 0;
    public Ball(int x, int y)
    {
      //x and y values are taken from draw class and updated
        this.x = x;
        this.y = y;
    }
    //Ball is updated
    public void update_ball() 
    {
        x = x + speed_x;
        y = y + speed_y;
    }
    
    public void paint(Graphics g)
    {
        g.clearRect(0, 0, getWidth() ,getHeight());
        g.setColor(Color.WHITE);
        //Paints the new ball 
        g.fillOval(x, y, 15, 15);
    }
  }