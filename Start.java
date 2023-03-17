import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Start extends JPanel implements MouseListener
{
    //variables for x and y
    int x;
    int y;
    //Boolean state for AI and menu screen
    boolean enableAI;
    boolean start = false;
    //x and y coordinates of buttons
    int b1_x = 75;
    int b1_y = 185;
    int b2_x = 575;
    int b2_y = 185;
    int b3_x = 341;
    int b3_y = 385;
    //Measurements of button names
    int strHeight;
    int strWidth1;
    int strWidth2;
    int strWidth3;
    //font
    Font font = new Font("SanSerif", Font.BOLD,50);
    //button width and height
    int button_width = 350;
    int button_height = 100;
    //opens menu screen
    Start(JFrame window)
    {
    	  super();
        super.setFocusable(true);
        super.addMouseListener(this);
    }
    //paints menu with buttons and title
    public void paint(Graphics g)
    {
        //Graphics2D to allow for more methods such as setStroke()
        Graphics2D g2 = (Graphics2D)g;
        g2.clearRect(0, 0, getWidth() ,getHeight());
        g2.setColor(Color.BLACK);
        //Background
        g2.fillRect(0,0,1000,500);
        g2.setColor(Color.WHITE);
        g2.setFont(font);
        g2.setStroke(new BasicStroke(3));
        //Game Border
        g2.drawRect(0,0,998,500);
        g2.setStroke(new BasicStroke(5));
        //Player 1, player 2, and quit text
        strWidth1 = g2.getFontMetrics(font).stringWidth("1 PLAYER");
        strWidth2 = g2.getFontMetrics(font).stringWidth("2 PLAYERS");
        strWidth3 = g2.getFontMetrics(font).stringWidth("QUIT");
        strHeight = g2.getFontMetrics(font).getHeight();
        g2.drawString("PONG", 436, 100);
        g2.drawRect(b1_x,b1_y,button_width,button_height);
        g2.drawRect(b2_x,b2_y,button_width,button_height);
        g2.drawRect(b3_x,b3_y,button_width,button_height);        
        g.drawString("1 PLAYER", (b1_x + button_width / 2 - strWidth1 / 2), (b1_y + button_height / 2 + strHeight / 4));
        g.drawString("2 PLAYERS", (b2_x + button_width / 2 - strWidth2 / 2), (b2_y + button_height / 2 + strHeight / 4));
        g.drawString("QUIT", (b3_x + button_width / 2 - strWidth3 / 2), (b3_y + button_height / 2 + strHeight / 4));
    }

    @Override
    public void mouseClicked(MouseEvent m)
    {
        //checks where the user clicks the mouse
        x = m.getX();
        y = m.getY();
        //if statment to check if the user clicked 1 player
        if (x > b1_x && x < b1_x+button_width && y > b1_y && y < b1_y+button_height)
        {
            enableAI = true;
            start = true;
        }
        //if statment to check if the user clicked 2 players
        if (x > b2_x && x < b2_x+button_width && y > b2_y && y < b2_y+button_height)
        {
            start = true;
        }
        //if statment to check if the user clicked quit button
        if (x > b3_x && x < b3_x+button_width && y > b3_y && y < b3_y+button_height)
        {
            System.exit(0);
        }
    }
    @Override
    public void mouseEntered(MouseEvent m) 
    {
        
    }
    @Override
    public void mouseExited(MouseEvent m) 
    {
        
    }
    @Override
    public void mousePressed(MouseEvent m) 
    {
        
    }
    @Override
    public void mouseReleased(MouseEvent m) 
    {
        
    }

}