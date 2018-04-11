package com.purva.she;

import android.database.SQLException;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import java.util.Calendar;
import android.database.Cursor;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    Button painHacksButton;
    Button profileButton;
    private GestureDetectorCompat gestureDetectorCompat;
    static {
        System.loadLibrary("native-lib");
    }

    TextView remDays;
   DatabaseHelper mydb;
    int k = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb =  DatabaseHelper.getInstance(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, new MyGestureListener());

        initialise();
        remDays = (TextView) findViewById(R.id.remDaysTextView);

        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Calendar calender = Calendar.getInstance();
                                int thisDay = calender.get(Calendar.DAY_OF_MONTH);
                                try {

//                                    Cursor res = mydb.getAllData();
//                                    if(res!=null) {
//                                        String p = res.getString(2);
//                                        k = Integer.parseInt(p);
//                                    }
//                                    else
                                        k = 0;
                                }
                                catch (SQLException e){
                                    k = 0;
                                }
                                if (thisDay < k) {
                                    int print = k - thisDay;
                                    String s = Integer.toString(print);
                                    remDays.setText("days left " + s);
                                } else {
                                    int print = 30 - thisDay + k;
                                    String s = Integer.toString(print);
                                    remDays.setText("days left " + s);
                                }
                            }
                        });
                    }
                }
                catch (InterruptedException e) {
                }
            }
        };

        t.start();




        painHacksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), painHackActivity.class);
                startActivity(intent);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), profile.class);
                startActivity(intent);
            }
        });
    }
    protected void initialise(){

        painHacksButton = (Button) findViewById(R.id.painHacksButton);
        profileButton = (Button) findViewById (R.id.profileButton);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        //handle 'swipe left' action only

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {

         /*
         Toast.makeText(getBaseContext(),
          event1.toString() + "\n\n" +event2.toString(),
          Toast.LENGTH_SHORT).show();
         */

            if(event2.getX() < event1.getX()){
                Toast.makeText(getBaseContext(),
                        "Swipe left - startActivity()",
                        Toast.LENGTH_SHORT).show();

                //switch another activity
                Intent intent = new Intent(
                        MainActivity.this, feel.class);
                startActivity(intent);
            }

            return true;
        }
    }
}


