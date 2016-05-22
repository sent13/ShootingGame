package io.sent.shootinggame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by sent13 on 16/05/18.
 */
public class Tama {
    private final Paint paint=new Paint();
    Bitmap bitmap;  //弾の画像
    Rect rect;      //弾の座標
    int mx,my;      //弾の移動量

    public Tama(Bitmap bitmap,int left,int top, int mx,int my){
        this.bitmap=bitmap;
        this.mx=mx;
        this.my=my;
        int right=left+bitmap.getWidth();
        int bottom=top+bitmap.getHeight();
        rect=new Rect(left,top,right,bottom);
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap,rect.left,rect.top,paint);
    }

    public void move(){
        rect.left+=mx;
        rect.right+=mx;
        rect.top+=my;
        rect.bottom+=my;
    }

    public boolean isContainView(){
        if(rect.bottom<0){
            return false;
        }else{
            return true;
        }
    }
}
