package com.purva.she;
import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
public class VerticlePagerAdapterFeed extends PagerAdapter {
    String mResources[] = {"Hey! there is no need to worry, You are awesome the way you are .\n","Chocolate contains magnesium, which can help alleviate cramps and increase energy. It also contains endorphins, or “happy hormones,” which can help improve your mood. Finally, dark chocolate is high in antioxidants called flavonoids, which may have a positive impact on your health.\n","Keep calm and have a good laugh\n","Yay !! that's great keep up the good spirit\n"};
    Context mContext;
    LayoutInflater mLayoutInflater;
    int user_mood;
    public VerticlePagerAdapterFeed(Context context, int mood) {
        user_mood = mood;
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return 20;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }
//    public void setMood(View buttonView){
//        int id = buttonView.getId();
//        switch(id){
//            case R.id.happyButton: mood = 1; break;
//            case R.id.angryButton: mood = 2; break;
//            case R.id.depressedButton: mood = 3; break;
//            case R.id.irritatedButton: mood = 4; break;
//            case R.id.neutralButon: mood = 5; break;
//            case R.id.confidentButton: mood = 6; break;
//        }
//    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.content_main, container, false);
        TextView label = (TextView) itemView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        Button like_button = (Button) itemView.findViewById(R.id.like_button);
//        VideoView mVideoView = (VideoView) itemView.findViewById(R.id.video_view);
//        mVideoView.setVideoURI(Uri.parse("android.resource://" + mContext.getPackageName() +"/"+R.raw.small_video));
//        mVideoView.setMediaController(new MediaController(this.mContext));
//        mVideoView.requestFocus();
        if (position % 10 == 0) {
            if(user_mood == 1){
                label.setText(mResources[3]);
                imageView.setImageResource(R.drawable.happy);
            }
            else if(user_mood == 3){
                label.setText(mResources[1]);
                imageView.setImageResource(R.drawable.choc);
            }
            else if(user_mood == 4){
                label.setText(mResources[2]);
                imageView.setImageResource(R.drawable.meme2);
            }
            else{
                label.setText(mResources[1]);
                imageView.setImageResource(R.drawable.choc);
            }
        }
        else if(position%10 == 1){
            if(user_mood == 3){
                label.setText(mResources[0]);
                imageView.setImageResource(R.drawable.dep1);
            }
            else{
                label.setText(mResources[0]);
                imageView.setImageResource(R.drawable.sad);
            }
        }
        else if(position%10 == 2){
            if(user_mood == 3){
                label.setText(mResources[0]);
                imageView.setImageResource(R.drawable.dep2);
            }
            label.setText(mResources[0]);
            imageView.setImageResource(R.drawable.dep3);
        }
        else if(position%10 == 3){
            if(user_mood == 3){
                label.setText(mResources[0]);
                imageView.setImageResource(R.drawable.dep3);
            }
            label.setText(mResources[0]);
            imageView.setImageResource(R.drawable.dep4);
        }
        else if(position%10 == 4){
            if(user_mood == 3){
                label.setText(mResources[0]);
                imageView.setImageResource(R.drawable.dep4);
            }
            label.setText(mResources[0]);
            imageView.setImageResource(R.drawable.dep5);
        }
        else if(position%10 == 5){
            if(user_mood == 3){
                label.setText(mResources[0]);
                imageView.setImageResource(R.drawable.dep5);
            }
            label.setText(mResources[0]);
            imageView.setImageResource(R.drawable.dep6);
        }
        else if(position%10 == 6){
            if(user_mood == 3){
                label.setText(mResources[0]);
                imageView.setImageResource(R.drawable.dep6);
            }
            label.setText(mResources[0]);
            imageView.setImageResource(R.drawable.dep7);
        }
        else if(position%10 == 7){
            if(user_mood == 3){
                label.setText(mResources[0]);
                imageView.setImageResource(R.drawable.dep7);
            }
            label.setText(mResources[0]);
            imageView.setImageResource(R.drawable.happy);
        }
        else if(position%10 == 8){
            if(user_mood == 3){
                label.setText(mResources[0]);
                imageView.setImageResource(R.drawable.choc);
            }
            label.setText(mResources[0]);
            imageView.setImageResource(R.drawable.exec);
        }
        else if(position%10 == 9){
            if(user_mood == 3){
                label.setText(mResources[0]);
                imageView.setImageResource(R.drawable.dep1);
            }
            label.setText(mResources[0]);
            imageView.setImageResource(R.drawable.meme1);
        }

        container.addView(itemView);
        return itemView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}