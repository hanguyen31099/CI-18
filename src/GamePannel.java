import tklibs.Mathx;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePannel extends JPanel {
    BufferedImage playerImage;
    BufferedImage ImageBackground;
    Vector2D playerPosition;
    Vector2D Background;


    public GamePannel(){
        playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        ImageBackground = SpriteUtils.loadImage("assets/images/background/0.png");
        Background = new Vector2D(0,600-ImageBackground.getHeight(null));
        playerPosition = new Vector2D(200,500);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(ImageBackground,(int)Background.x,(int)Background.y,null);
        g.drawImage(playerImage,(int)playerPosition.x,(int)playerPosition.y,null);

    }
    public void GameLoop(){
        long lastTime = 0;
        while(true){
            long currenTime = System.currentTimeMillis();
            if(currenTime-lastTime>1000/60){

                this.runAll();
                this.repaint();
                lastTime = currenTime;
            }
        }
    }
    public  void runAll(){
        if(KeyEnvenPress.isUpPress){
            playerPosition.y--;
        }
        if(KeyEnvenPress.isDOWPress){
            playerPosition.y++;
        }
        if(KeyEnvenPress.isLeftPress){
            playerPosition.x--;
        }
        if(KeyEnvenPress.isRightPress){
            playerPosition.x++;
        }
        playerPosition.x = Mathx.clamp(playerPosition.x,0,ImageBackground.getWidth()- playerImage.getWidth());
        playerPosition.y = Mathx.clamp( playerPosition.y,0,600 - playerImage.getHeight());
        Background.y += 10;
        if(Background.y>=10){
            Background.y = 0;
        }
    }
}