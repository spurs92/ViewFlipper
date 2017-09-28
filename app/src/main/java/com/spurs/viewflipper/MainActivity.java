package com.spurs.viewflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper flipper;
    ToggleButton toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper=(ViewFlipper)findViewById(R.id.flipper);
        flipper.setInAnimation(this,android.R.anim.slide_in_left);
        flipper.setOutAnimation(this,android.R.anim.slide_out_right);

        for(int i=0; i<4; i++){
            ImageView img=new ImageView(this);
            img.setImageResource(R.drawable.gametitle_04+i);
            flipper.addView(img);
        }

        toggle=(ToggleButton)findViewById(R.id.toggle);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){//켜졌을때..
                    flipper.setFlipInterval(1000);
                    flipper.startFlipping();
                }else{
                    flipper.stopFlipping();

                }
            }
        });
    }

    public void clickPre(View v){
        flipper.showPrevious();

    }

    public void clickNext(View v){
        flipper.showNext();

    }
}
