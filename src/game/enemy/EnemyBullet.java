package game.enemy;

import game.GameObject;
import game.Physics.BoxCollider;
import tklibs.SpriteUtils;

public class EnemyBullet extends GameObject {
    public int damge;
    public EnemyBullet() {
        image = SpriteUtils.loadImage("assets/images/enemies/bullets/red.png");
        velocity.set(0,-3);
        hitBox = new BoxCollider(this,image.getWidth(),image.getHeight());
        damge = 1;
    }

    @Override
    public void run() {
        super.run();
        this.deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if (position.y>600){
            this.deactive();
        }
    }
}
