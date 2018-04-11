package com.purva.she;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by rizvan on 12/13/16.
 */

public class VerticlePagerAdapter extends PagerAdapter {

    String mResources[] = {"Child pose is the go-to resting pose in most active yoga classes. With many benefits, the pose is a great option for those suffering from menstrual pain originating in the back. By gently stretching the low back muscles, Child pose will soothe back aches while also quieting the mind. Focus on deeply breathing into the back and notice the rise and the fall of the breath in the body. Relax through the hips and let the torso rest upon the tops of the thighs which will help alleviate fatigue.",
    "Counteracting compression, Standing Forward Fold pose lengthens the spine and stretches the hips. It also help ease the pain that radiates down the legs and around the back by stretching the hamstrings, calves, and back.Although our bodies are exhausted when menstruating, it’s important to stand up (and bend over) after sitting or lying for long periods of time. Your body will thank you for getting the circulation moving!",
    "If you have mild menstrual cramps, take aspirin or another pain reliever, such as acetaminophen, ibuprofen, or naproxen. For best relief, you must take these medications as soon as bleeding or cramping starts. Heat can also help. Place a heating pad or hot water bottle on your lower back or tummy"
    ,"Wanna check out some more yoga assans now"};

    Context mContext;
    LayoutInflater mLayoutInflater;

    public VerticlePagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.content_main, container, false);

        TextView label = (TextView) itemView.findViewById(R.id.textView);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);

        if (position % 6 == 0) {
            label.setText(mResources[0]);
            imageView.setImageResource(R.drawable.child);
        }
        else if(position % 6 == 1){
            label.setText(mResources[1]);
            imageView.setImageResource(R.drawable.forward);
        }
        else if(position % 6 ==2){
            label.setText(mResources[2]);
            imageView.setImageResource(R.drawable.medicine);
        }
        else if(position % 6 ==3){
            label.setText(mResources[3]);
            imageView.setImageResource(R.drawable.yoga1);
        }
        else if(position % 6 ==4){
            label.setText(mResources[3]);
            imageView.setImageResource(R.drawable.yoga2);
        }
        else if(position % 6 == 5){
            label.setText(mResources[3]);
            imageView.setImageResource(R.drawable.yoga3);
        }
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}