package io.sent.shootinggame;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by sent13 on 16/05/20.
 */
public class Enemies {
    ArrayList<Enemy> enemies=new ArrayList<>();
    Iterator iterator;

    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }

    public void enemiesDraw(Canvas canvas){
        //自分の弾の描画
        iterator=enemies.iterator();
        while(iterator.hasNext()){
            Enemy e=(Enemy)iterator.next();

            if(e.isEnemyContainView(canvas)){      //弾が画面内かどうか
                e.move();
                e.draw(canvas);
            }else{
                iterator.remove();
            }

        }
    }
}
