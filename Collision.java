class Collision
{
	int speed_add = 0;
	int count = 0;
    public void checkPaddleCollision(Paddles p1,Paddles p2,Draw draw)
    {
        //Direction is checked by getting the ball's x speed
    	int dir = Integer.signum(draw.ball.speed_x);
        //x coordinate is changed to more accurately represent where the ball is on the screen
    	int x = draw.ball.x + 7;
        //Checks if ball's x coordinates match up with the paddles
        //Also checks direction so that ball does not double bounce
        if(30 < x && 40 > x && dir==-1)
        {
            ballAngle(draw,p1);
        }
        if(960 < x && 970 > x && dir==1)
        {
            ballAngle(draw,p2);
        }
    }
    public void ballAngle(Draw draw, Paddles p)
    {
        //Direction is flipped so that ball can go opposite direction after hitting the paddle
        int dir = (Integer.signum(draw.ball.speed_x))*-1;
        //y coordinate is changed to more accurately represent where the ball is on the screen
        int y = draw.ball.y + 7;
        //Speed is added every 3 hits
        if (count%3==0&&draw.ball.speed_x<13)
        	speed_add++;
        //Checks if the ball's y coordinate matches with the paddle
        if(y > p.y && y < p.y+80)
            {
        		count++;
                //15 degree up
                if(y > p.y && y < p.y+16)
                {
                	draw.ball.speed_x = 1 + speed_add;
                	draw.ball.speed_x = draw.ball.speed_x*dir;
                	draw.ball.speed_y = -3;
                }
                //45 degree up
                else if(y+16 > p.y && y < p.y+38)
                {
                	draw.ball.speed_x = 2 + speed_add;
                	draw.ball.speed_x = draw.ball.speed_x*dir;
                	draw.ball.speed_y = -2;
                }
                //90 degree straight
                else if(y+38 > p.y && y < p.y+42)
                {
                	draw.ball.speed_x = 3 + speed_add;
                	draw.ball.speed_x = draw.ball.speed_x*dir;
                	draw.ball.speed_y = 0;
                }
                //45 degree down
                else if(y+42 > p.y && y < p.y+64)
                {
                	draw.ball.speed_x = 2 + speed_add;
                	draw.ball.speed_x = draw.ball.speed_x*dir;
                	draw.ball.speed_y = 2;
                }
                //15 degree down
                else if(y+64 > p.y && y < p.y+80)
                {
                	draw.ball.speed_x = 1 + speed_add;
                	draw.ball.speed_x = draw.ball.speed_x*dir;
                	draw.ball.speed_y = 3;
                }
                
            }
    }
    //Screen collision check
    public void checkScreenCollision(Draw draw)
    {
        //Ball bounces if it hits the top or bottom of the screen
        if(draw.ball.y >= 500 || draw.ball.y <= 0)
        {
        	draw.ball.speed_y = draw.ball.speed_y*-1;
        }
        //Score detection
        if(draw.ball.x < 0)
        {
        	draw.p2_points++;
            //Reset the speed added and the balls position
        	speed_add = 0;
            draw.S_Press = false;
            draw.W_Press = false;
            draw.UP_Press = false;
            draw.DOWN_Press = false;
            draw.ball.x = 485;
            draw.ball.y = 235;
            draw.ball.speed_x = 2;
            draw.ball.speed_y = 0;
        }
        else if(draw.ball.x > 1000)
        {
        	draw.p1_points++;
            //Reset the speed added and the balls position
        	speed_add = 0;
        	draw.ball.x = 485;
            draw.ball.y = 235;
            draw.ball.speed_x = -2;
            draw.ball.speed_y = 0;
        }
        
    }
    
}
    
