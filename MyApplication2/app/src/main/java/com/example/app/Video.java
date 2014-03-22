package com.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by SWINE on 08.03.14.
 */
public class Video extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.video);
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath("/sdcard/vid.mp4");
        videoView.setMediaController(new MediaController(this));
        videoView.start();
        videoView.requestFocus();
    }
}
