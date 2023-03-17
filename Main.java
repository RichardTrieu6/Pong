import javax.swing.*;

class Main 
{
  
  public static void main(String[] args) 
    {
        //Start menu
        boolean start = false;
        //Boolean statement that activates AI
        boolean enableAI;
        JFrame window = new JFrame("Pong");
        window.setSize(1016,542);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Start menu = new Start(window);
        window.add(menu);
        //While loop constantly checks if the game is started
        while(!(start==true))
        {
          try
          {
            //Start variable is updated
            start = menu.start;
            Thread.sleep(10);
            //Game starts if variable start is true
            if(start == true)
            {
              enableAI = menu.enableAI;
              //Start menu is closed
              window.remove(menu);
              window.dispose();
              //Game is run
              Game game = new Game();
              game.run(enableAI);
            }
          }
          catch (InterruptedException e)
            {
            	e.printStackTrace();
            }
          
        }

        
    }
    
}
