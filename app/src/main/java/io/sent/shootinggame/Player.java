package io.sent.shootinggame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.System.currentTimeMillis;

/**
 * Created by sent13 on 16/05/17.
 */
public class Player extends Airframe{

    ArrayList<Bullet> bullets;
    Iterator iterator;
    Bitmap bulletBitmap;
    long touchStartTime=0,touchStopTime=0;
    
    public Player(Bitmap bitmap,Bitmap bulletBitmap,int left, int top){
        super(bitmap,left,top);
        bullets=new ArrayList<>();
        this.bulletBitmap=bulletBitmap;
    }

    public boolean touchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (isPointContain(x, y)) {
                    touchStartTime = currentTimeMillis();
                    return true;
                } else {
                    addBulletFire();
                    return false;
                }

            case MotionEvent.ACTION_MOVE:
                move(x, y);
                break;

            case MotionEvent.ACTION_UP:
                touchStopTime = currentTimeMillis();
                if ((touchStopTime - touchStartTime) < 150) {
                    addBulletFire();
                }
                break;
        }
        return false;
    }

    @Override
    public void move(int x,int y){
        rect.left=x-bitmap.getWidth()/2;
        rect.top=y-bitmap.getHeight()/2;
        rect.right=rect.left+bitmap.getWidth();
        rect.bottom=rect.top+bitmap.getHeight();
    }

    public void bulletDraw(Canvas canvas){
        //自分の弾の描画
        iterator=bullets.iterator();
        while(iterator.hasNext()){
            Bullet b=(Bullet)iterator.next();

            if(b.isContainView()){      //弾が画面内かどうか
                b.move();
                b.draw(canvas);
            }else{
                iterator.remove();
            }

        }
    }

    private void addBulletFire(){
        int left =rect.left + (bitmap.getWidth() - bulletBitmap.getWidth()) / 2;
        int top =rect.top - bulletBitmap.getHeight();
        bullets.add(new Bullet(bulletBitmap, left, top, 0, -3));
    }

}
