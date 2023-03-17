import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Draw extends JPanel implements KeyListener
{
    //Paddle and ball class are instantiated
    Paddles p1;
    Paddles p2;
    Ball ball;
    
    boolean enableAI;
    int reactAI = 300;
    
    //Booleans for each button press
    boolean S_Press = false;
    boolean W_Press = false;
    boolean UP_Press = false;
    boolean DOWN_Press = false;

    //Boolean for winning
    boolean win = false;

    //x and y positions for player 1
    int x = 30;
    int y = 210;
    //x and y positions for player 2
    int x2 = 960;
    int y2 = 210;
    
    int paddle_speed = 3;

    //Points
    int p1_points = 0;
    int p2_points = 0;
    
    //x and y positions for the ball
    int ball_x = 485;
    int ball_y = 235;
    
    Draw()
    {
    	super();
        //setFocusable allows for the JPanel to take in keyboard inputs
        super.setFocusable(true);
        super.addKeyListener(this);
        p1 = new Paddles(x,y);
        p2 = new Paddles(x2,y2);
        ball = new Ball(ball_x,ball_y);
    }

    
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.clearRect(0, 0, getWidth() ,getHeight());
        //Set a font so that the program can print strings to the correct size and font
        Font font = new Font("SanSerif", Font.BOLD,50);
        g2.setFont(font);
        //Paints background
        g2.fillRect(0,0,1000,500);
        g2.setColor(Color.BLACK);
        g2.setColor(Color.WHITE);
        //Paints the players score
        g2.drawString(Integer.toString(p1_points),411,50);
        g2.drawString(Integer.toString(p2_points),578,50);
        //Paints borders
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(0,0,998,500);
        //g2.fillRect(0, 0, 3, 500);
        //g2.fillRect(0, 0, 1000, 3);
        //g2.fillRect(997, 0, 3, 500);
        //g2.fillRect(0, 997, 1000, 3);
        //Paints paddles and balls
        p1.paint(g2);
        p2.paint(g2);
        ball.paint(g2);
        float dash1[] = {10.0f};
        g2.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f, dash1, 0.0f));
        g2.drawLine(508,0,508,542);
        //Check to see if anybody won
        if(p1_points == 10)
        {
          //Draw a win screen
        	g2.drawString("Player 1 WIN", 350,225 );
          //If statement so that the win popup does not loop
          if (win == false)
          {
            reset();
          }
        }
        if(p2_points == 10)
        {
        	g2.drawString("Player 2 WIN", 350,225 );
          if (win == false)
          {
            reset();
          }
        }
    }
  
    @Override
    public void keyPressed(KeyEvent e)
    {
        //If statements to check which button is pressed
        if(e.getKeyCode()== KeyEvent.VK_S)
        {
          S_Press = true;
        }
        
        if(e.getKeyCode()== KeyEvent.VK_W)
        {
          W_Press = true;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
          UP_Press = true;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
          DOWN_Press = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e)
    {
      //If statements to check when the button gets released 
      if(e.getKeyCode()== KeyEvent.VK_S)
        {
          S_Press = false;
        }
        
        if(e.getKeyCode()== KeyEvent.VK_W)
        {
          W_Press = false;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
          UP_Press = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
          DOWN_Press = false;
        }       
     
    } 
    @Override
    public void keyTyped(KeyEvent e)
    {
      
    } 
  public void update()
  {
    //Enable the AI if single player mode is chosen
    if(enableAI == true)
    {
      AI();
    }
    //Update method checks if each button is pressed, if it is within the border, and if anybody has won
    //If all conditions are true, the y values of the paddles are updated 
    if(win == false)
    {
      if(S_Press == true&&p1.y<417)
      {
        p1.y = p1.y+paddle_speed;
      }
      if(W_Press == true&&p1.y>3)
      {
        p1.y = p1.y-paddle_speed;
      }
      if(DOWN_Press == true&&p2.y<417)
      {
        p2.y = p2.y+paddle_speed;
      }
      if(UP_Press == true&&p2.y>3)
      {
        p2.y = p2.y-paddle_speed;
      }
    }
    //Repaint
    repaint();
  }
  public void AI()
  {
    //AI looks if the ball is above or below its current y position
    //AI also aims to hit the middle of the paddle
    //AI is only activated when the ball passes a certain x coordinate
    if(ball.y > p1.y+40&&ball.x<reactAI)
    {
      S_Press = true;
      W_Press = false;
    }
    else if (ball.y == p1.y+40||p1.y>500||p1.y<0)
    {
      S_Press = false;
      W_Press = false;
    }
    else if(ball.y < p1.y+40&&ball.x<reactAI)
    {
      W_Press = true;
      S_Press = false;
    }
    if(ball.x>reactAI)
    {
      W_Press = false;
      S_Press = false;
    }
  }

  public void reset()
  {
    win = true;
    ball.speed_x = 0;
    //JOptionPane takes in an integer input to check if the "ok" button has been pressed
    int input = JOptionPane.showConfirmDialog(null,"Reset?","MESSAGE",JOptionPane.DEFAULT_OPTION);
    if (input == 0)
    {
      //Game is reset
      p1_points = 0;
      p2_points = 0;
      ball.speed_x = 1;
      S_Press = false;
      W_Press = false;
      UP_Press = false;
      DOWN_Press = false;
      win = false;
    }
  }
  
}
