package com.purva.she;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;
import android.widget.Button;

public class feel extends AppCompatActivity {


    int mood;
    Button depressedButton;
    Button irritatedButton;
    Button happyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feel);
        depressedButton = (Button) findViewById(R.id.depressedButton);
        depressedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), feed.class);
                intent.putExtra("mood",3);
                startActivity(intent);
            }
        });
        irritatedButton = (Button) findViewById(R.id.irritatedButton);
        irritatedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), feed.class);
                intent.putExtra("mood",4);
                startActivity(intent);
            }
        });
        happyButton = (Button) findViewById(R.id.happyButton);
        happyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), feed.class);
                intent.putExtra("mood",1);
                startActivity(intent);
            }
        });
    }


//    public void setMood(View buttonView){
//        Toast toast = Toast.makeText(getApplicationContext(),"dhg", Toast.LENGTH_SHORT);
//        int id = buttonView.getId();
//        switch(id){
//            case R.id.happyButton: mood = 1; break;
//            case R.id.angryButton: mood = 2; break;
//            case R.id.depressedButton: mood = 3; break;
//            case R.id.irritatedButton: mood = 4; break;
//            case R.id.neutralButon: mood = 5; break;
//            case R.id.confidentButton: mood = 6; break;
//        }
//        Intent intent = new Intent(getApplicationContext(),feed.class);
//        intent.putExtra("mood",mood);
//        startActivity(intent);
//    }
}
