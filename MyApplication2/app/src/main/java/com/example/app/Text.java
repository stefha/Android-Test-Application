package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by SWINE on 06.03.14.
 */
public class Text extends Activity {
    private Button button1;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
        Log.d("Stef", "Activity Text started");

        textView = (TextView) findViewById(R.id.textView);

        button1 = (Button) findViewById(R.id.button);

        registerForContextMenu(button1);
        registerForContextMenu(textView);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Stef", "Button 1 gedrückt");
                Intent intent = new Intent(Text.this, Main3.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    };

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id== R.id.context_item1){
            Log.d("Stef","Kontext Item 1 geklickt");
            textView.setText("Damn you!!! Now you changed the Text because you clicked the 1 Option");
        }else if(id==R.id.context_item2){
            Log.d("Stef","Kontext Item 2 geklickt");
            textView.setText("Damn you!!! Now you changed the Text because you clicked the 2 Option." +
                    "Leave this Activity right now !!!!");
        }
        return super.onContextItemSelected(item);
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
        } else if (id == R.id.item2) {
            Log.d("Stef", "Item 2 wurde geklickt");
        }

        return super.onOptionsItemSelected(item);
    }
}
