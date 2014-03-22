package com.example.app;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by SWINE on 08.03.14.
 */
public class Animation extends Activity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.anim.myanimation);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Stef", "Imageview gedrückt");
                AnimationDrawable animDrawable = (AnimationDrawable) imageView.getBackground();
                animDrawable.start();
            }
        });

    }


}
