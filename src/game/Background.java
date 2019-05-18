package game;

import tklibs.SpriteUtils;

import java.awt.*;


public class Background extends GameObject{
    public Background() {
        image = SpriteUtils.loadImage("assets/images/background/0.png");
//        position = new Vector2D(0, 600 - 3109);
        position.set(0,600-3109);
    }
    @Override
    public void run() {
        position.y++;
        if(position.y >= 0) {
            position.y = 0;
        }
    }
}
