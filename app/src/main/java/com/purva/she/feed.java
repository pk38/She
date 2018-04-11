package com.purva.she;
 import android.content.Intent;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;

public class feed extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        Intent intent = getIntent();
        int mood = intent.getIntExtra("mood",3);
        initSwipePager(mood);
    }
    private void initSwipePager(int mood){
        VerticalViewPager verticalViewPager = (VerticalViewPager) findViewById(R.id.vPager);
        verticalViewPager.setAdapter(new VerticlePagerAdapterFeed(this,mood));
    }
}
