package io.sent.shootinggame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by sent13 on 16/05/17.
 */
public class GameView extends View implements View.OnTouchListener{

    Player player;
    Enemies enemies;
    Random random=new Random();


    public GameView(Context context){
        super(context);
        enemies=new Enemies();
        this.setOnTouchListener(this);
    }

    //描画処理
    @Override
    public void onDraw(Canvas canvas){
        if(player==null){
            Bitmap pBitmap=BitmapFactory.decodeResource(getResources(), R.drawable.nanaturao);
            Bitmap bulletBitmap=BitmapFactory.decodeResource(getResources(),R.drawable.bullet);
            int left=(canvas.getWidth()-pBitmap.getWidth())/2;
            int top=canvas.getHeight()-pBitmap.getHeight();
            player=new Player(pBitmap,bulletBitmap,left,top);
        }
        player.draw(canvas);
        player.bulletDraw(canvas);

        if(random.nextInt(200)==0){
            Bitmap b=BitmapFactory.decodeResource(getResources(),R.drawable.kutiki);
            enemies.addEnemy(new Enemy(b,random.nextInt(canvas.getWidth()-b.getWidth()),-b.getHeight(),0,3));
        }
        enemies.enemiesDraw(canvas);



        invalidate();
    }


    //画像をドラックした時の処理
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return player.touchEvent(event);
    }



}
