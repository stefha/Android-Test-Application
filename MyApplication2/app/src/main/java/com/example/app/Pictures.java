package com.example.app;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by SWINE on 06.03.14.
 */
public class Pictures extends Activity implements View.OnClickListener {
    private ImageView imageView1;
    private ImageView imageView2;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pictures);
        Log.d("Stef", "Activity Pictures started");

        imageView1 = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        imageView1.setImageResource(R.drawable.p1);
        imageView2.setImageResource(R.drawable.p3);

        button.setOnClickListener(this);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.item1) {
            Log.d("Stef", "Item 1 wurde geklickt");
            editText.setText("Option 1 wurde gedrückt");
        } else if (id == R.id.item2) {
            Log.d("Stef", "Item 2 wurde geklickt");
            editText.setText("Option 1 wurde gedrückt");
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.imageView) {
            Log.d("Stef", "ImageView 1 wurde geklickt");

            imageView1.setImageResource(R.drawable.animation_00031);
        } else if (id == R.id.imageView2) {
            Log.d("Stef", "ImageView 2 wurde geklickt");
            imageView2.setImageResource(R.drawable.animation_00035);
        } else if (id == R.id.button) {
            Log.d("Stef", "Button 1 wurde geklickt");
            MediaPlayer mp = MediaPlayer.create(this, R.raw.beep);
            mp.start();
        }
    }
}