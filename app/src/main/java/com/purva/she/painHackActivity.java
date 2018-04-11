package com.purva.she;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class painHackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pain_hack);
        initSwipePager();
    }

    private void initSwipePager(){
        VerticalViewPager verticalViewPager = (VerticalViewPager) findViewById(R.id.vPager);
        verticalViewPager.setAdapter(new VerticlePagerAdapter(this));
    }
}
