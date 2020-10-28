package com.example.bradch06_thread;

/*  參考資料：從Java到Android行動裝置程式設計必修的15堂課 (趙令文)
    P.6-6頁

    通常 UI Thread 的表現方式是由Activity來負責處理，而背景執行緒
    可能會從Activity的生命週期中分支出來，如果沒有特別去處理該分支出
    來的執行緒，該分支的執行緒將會在背景中持續執行，而會因為Activity
    進入死亡狀態而受到影響，此一觀念一樣存在於 Timer / TimerTask

    執行結果：
    執行緒啟動後，i值開始計數。計數中按下Back，
    App雖然收起來，但執行緒仍繼續數。
    再次招喚App時，舊的Thread繼續數、另外新創Thread開始從0開始計數。
    i值抵達上限會結束執行緒，新創的Thread會繼續數。
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new MyThread().start();
    }

    private class MyThread extends Thread {
        @Override
        public void run() {
            //super.run();
            for (int i = 0; i < 20; i++) {
                Log.i("sean", " i = " + i);
                try {
                    Thread.sleep(1 * 1000); // 休眠1秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}