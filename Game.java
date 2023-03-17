import javax.swing.*;
public class Game 
{
    public void run(boolean enableAI)
    {
    	JFrame window = new JFrame("Pong");
        window.setSize(1016,542); //Set size to 1016,542 if setUndecorated(false) in eclipse
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Draw draw = new Draw();
        draw.enableAI = enableAI;
        Collision collision = new Collision();
        window.add(draw);
        window.setVisible(true);
        //Game Loop
        while(true)
        {
            try
            {
	            //Updates ball direction
	            collision.checkPaddleCollision(draw.p1,draw.p2,draw);
	            collision.checkScreenCollision(draw);
	            draw.ball.update_ball();
	            //Update method is called
	            draw.update();
	            //Loop is delayed for 5ms
	            Thread.sleep(5);
            }
            catch (InterruptedException e)
            {
            	e.printStackTrace();
            }
        }  
    }
    
}
