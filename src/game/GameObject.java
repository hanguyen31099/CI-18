package game;

import game.Physics.BoxCollider;
import game.player.Player;
import game.player.PlayerBullet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    // quan li doi tuong(static)
    public static ArrayList<GameObject> objects = new ArrayList<>();

    public static <E extends GameObject>E recycle(Class<E> cls){
        // 1. tim phan tu bi deactive >> reset phan tu thi >> tra ve
        E object = findInactive(cls);
        if(object!=null){
            object.reset();
            return object;
        }
        // 2. k tim thay thi tao moi
        try{
            object = cls.getConstructor().newInstance();
            return object;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }

    public static <E extends GameObject>E findInactive(Class<E> cls){
        // cls ~ Player.class || BackGround.class
        // E ~ player || background
        for (int i=0;i<objects.size();i++){
            GameObject object = objects.get(i);
            // object ~ cls
            if(cls.isAssignableFrom(object.getClass())
                && !object.active){
                return (E)object;
            }
        }
        return null;
    }

    public static <E extends GameObject>E findInterSects(Class<E> cls,BoxCollider hitBox){
        for (int i = 0; i <objects.size() ; i++) {
            GameObject object = objects.get(i);
            //1. active
            //2. object ~ cls
            //3. object.hitbox !=null ~ intersects(hitBox)
            if (object.active
                    && cls.isAssignableFrom(object.getClass())
                    && object.hitBox != null
                    && object.hitBox.interset(hitBox))
            {

                return (E) object;
            }
        }
        return null;
    }

    // dinh nghia doi tuong
    public boolean active;
    public BufferedImage image;
    public Vector2D position;
    public Vector2D velocity;
    public BoxCollider hitBox;

    public GameObject(){
        position = new Vector2D(0,0);
        velocity = new Vector2D(0,0);
        objects.add(this);
        active = true;
    }
    public void render(Graphics g){
        if(image!=null){
            g.drawImage(image,(int)position.x,(int)position.y,null);
        }
    }
    public void run(){
        position.add(velocity.x,velocity.y);
    }
    public void deactive(){
        active = false;
    }
    public void reset(){
        active = true;
    }
}
