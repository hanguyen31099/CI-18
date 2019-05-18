package game.enemy;

import game.GameObject;
import game.Physics.BoxCollider;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public int hp;
    public Enemy(){
        image = SpriteUtils.loadImage("assets/images/enemies/level0/black/6.png");
        position.set(0,-50);
        velocity.set(0,-5);
        velocity.setAngle(Math.toRadians(30));
        hitBox  = new BoxCollider(this,image.getWidth(),image.getHeight());
        hp = 3;
    }

    @Override
    public void run() {
        super.run();
        this.move();
        this.fire();
        this.deactiveIfNeeded();
    }
    int count = 0;
    private void fire() {
        count++;
        if(count>30){
            count = 0;
            EnemyBullet bullet= GameObject.recycle(EnemyBullet.class);
            bullet.position.set(this.position.x, this.position.y);
            bullet.velocity.setAngle(Math.toRadians(90));
        }
    }

    private void move()            {
        if(this.onGoingRight() && this.outOfBoundRight()){
            this.reverseVelocityX();
        }
        if (this.onGoingLeft()&&this.outOfBoundLeft()){
            this.reverseVelocityX();
        }
    }

    @Override
    public void reset() {
        super.reset();
        position.set(0,-50);
        velocity.set(0,5);
        velocity.setAngle(Math.toRadians(30));
        hp = 3;
    }

    public void takeDamege(int damage){
        hp -= damage;
        if(hp<=0){
            hp = 0;
            this.deactive();
        }

    }
    private void deactiveIfNeeded() {
        if (position.y>600) this.deactive();
    }

    private boolean outOfBoundLeft() {
        return position.x < 0;
    }

    private boolean onGoingLeft() {
        return velocity.x <0;
    }

    private void reverseVelocityX() {
        velocity.x = -velocity.x;
    }

    private boolean outOfBoundRight() {
        return position.x > 384 - image.getWidth();
    }

    private boolean onGoingRight() {
        return velocity.x > 0;
    }

}
