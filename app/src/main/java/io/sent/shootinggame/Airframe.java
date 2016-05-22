package io.sent.shootinggame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;


/**
 * Created by sent13 on 16/05/17.
 */
public class Airframe{
    protected Bitmap bitmap;   //機体の画像
    protected Rect rect;          //機体の座標
    private final Paint paint=new Paint();


    public Airframe(Bitmap bitmap,int left,int top){
        this.bitmap=bitmap;
        int right=left+bitmap.getWidth();
        int bottom=top+bitmap.getHeight();
        rect=new Rect(left,top,right,bottom);
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap,rect.left, rect.top, paint);
    }

    public void move(int x,int y){

    }

    //座標がこのオブジェクトと被っているか
    public boolean isPointContain(int x,int y){
        if((rect.left <= x && x<=rect.right) && (rect.top <=y && y<=rect.bottom)){
            return true;
        }else {
            return false;
        }
    }
}
