package io.sent.shootinggame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by sent13 on 16/05/20.
 */
public class Enemy extends Airframe{

    int mx,my;
    public Enemy(Bitmap bitmap,int left,int top,int mx,int my){
        super(bitmap,left,top);
        this.mx=mx;
        this.my=my;
    }

    public void move(){
        rect.left+=mx;
        rect.right+=mx;
        rect.top+=my;
        rect.bottom+=my;
    }

    public boolean isEnemyContainView(Canvas canvas){
        if(rect.top>canvas.getHeight()){
            return false;
        }else{
            return true;
        }
    }
}
