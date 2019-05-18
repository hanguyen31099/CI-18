package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.Physics.BoxCollider;
import game.enemy.Enemy;
import game.enemy.EnemyBullet;
import tklibs.Mathx;
import tklibs.SpriteUtils;


public class Player extends GameObject {
    public int hp;

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position.set(200,500);
        hitBox = new BoxCollider(this,image.getWidth(),image.getHeight());
        hp = 10;
    }
    int count = 0; // dem so khung hinh

    @Override
    public void run() { // 60 fps >> 60 vien dan dc tao ra 1s >> 3 vien duoc tao ra 1s
        this.move();
        this.limit();
        this.fire();
        this.checkDied();
       // System.out.println(GameObject.objects.size());
    }


    private void checkDied() {
        this.checkBulletEnemy();
        this.checkEnemy();
        if(this.hp<=0) this.deactive();
    }

    private void checkBulletEnemy() {
        EnemyBullet enemyBullet = GameObject.findInterSects(EnemyBullet.class,hitBox);
        if(enemyBullet!=null){
            enemyBullet.deactive();
            this.hp--;

        }
    }

    private void checkEnemy() {
        Enemy enemy = GameObject.findInterSects(Enemy.class,hitBox);
        if(enemy!=null){
            enemy.deactive();
            this.hp--;
        }
    }

    private void fire() {
        count++;
        if(KeyEventPress.isFirePress && count > 20) {
//            PlayerBullet bullet = new PlayerBullet();
            PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
            bullet.position.set(this.position.x, this.position.y);
            bullet.velocity.setAngle(Math.toRadians(-90));

            PlayerBullet bullet2 = GameObject.recycle(PlayerBullet.class);
            bullet2.position.set(this.position.x - 10, this.position.y);
            bullet2.velocity.setAngle(Math.toRadians(-135));

            PlayerBullet bullet3 = GameObject.recycle(PlayerBullet.class);
            bullet3.position.set(this.position.x + 10, this.position.y);
            bullet3.velocity.setAngle(Math.toRadians(-45));

            count = 0;
        }
    }
    private void limit() {
        position.x = Mathx.clamp(position.x, 0, 384 - 32);
        position.y = Mathx.clamp(position.y, 0, 600 - 48);
    }
    private void move() {
        if(KeyEventPress.isUpPress) {
            position.y-=5;
        }
        if(KeyEventPress.isLeftPress) {
            position.x-=5;
        }
        if(KeyEventPress.isRightPress) {
            position.x+=5;
        }
        if(KeyEventPress.isDownPress) {
            position.y+=5 ;
        }
    }

}
