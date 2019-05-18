package game.player;

import game.GameObject;
import game.Physics.BoxCollider;
import game.Vector2D;
import game.enemy.Enemy;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject { // PlayerBulletType2
    public int damge;
//    Player player;
    public PlayerBullet() {
        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        velocity.set(0,-3);
        hitBox = new BoxCollider(this,image.getWidth(),image.getHeight());
        damge = 1;
    }

    @Override
    public void run() {
        super.run(); //position.add(velocity.x,velocity.y)
        this.deactiveIfneed();
        this.checkEnemy();
    }

    private void checkEnemy() {
        Enemy enemy = GameObject.findInterSects(Enemy.class,hitBox);
        if(enemy!=null){
            //enemy.deactive();
            enemy.takeDamege(damge);

            this.deactive();
        }
    }

    private void deactiveIfneed() {
        if(position.y<-30) {
            this.deactive();
        }
    }
}
