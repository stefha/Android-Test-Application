package com.example.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by SWINE on 08.03.14.
 */
public class Main extends ActionBarActivity implements View.OnClickListener {

    private EditText editText;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("Stef", "Activity Main started");


        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        editText = (EditText) findViewById(R.id.editText);


        button1.setText("Save");
        button2.setText("Change ");
        button3.setText("Toast");
        button4.setText("Notify");
        button5.setText("Camera Activity");
        button6.setText("Video Activity");
        button7.setText("Animation Activity");
        button8.setText("Not Yet");
        button9.setText("Not Yet");
        button10.setText("Not Yet");

        registerForContextMenu(button1);
        registerForContextMenu(button2);
        registerForContextMenu(button3);
        registerForContextMenu(button4);
        registerForContextMenu(button5);
        registerForContextMenu(button6);
        registerForContextMenu(button7);
        registerForContextMenu(button8);
        registerForContextMenu(button9);
        registerForContextMenu(button10);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);

        SharedPreferences settings = getSharedPreferences("MYPREFS", 0);
        String defaultSettings = settings.getString("textvalue", "");
        editText.setText(defaultSettings);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == button1.getId()) {

        } else if (id == button1.getId()) {

        } else if (id == button2.getId()) {

        } else if (id == button3.getId()) {
            createToast();
        } else if (id == button4.getId()) {

        } else if (id == button5.getId()) {
            goToActivity(Camera.class);
        } else if (id == button6.getId()) {
            goToActivity(Video.class);
        } else if (id == button7.getId()) {
            goToActivity(Animation.class);
        } else if (id == button8.getId()) {

        } else if (id == button9.getId()) {

        } else if (id == button10.getId()) {

        } else {

        }
    }

    private void goToActivity(Class<?> targetClass) {
        Intent intent = new Intent(this, targetClass);
        startActivity(intent);
    }

    private void createToast() {
        Toast toast = Toast.makeText(Main.this, "This is a Toast!", 5000);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.context_item1) {
            Log.d("Stef", "Kontext Item 1 gedrückt");
        } else if (id == R.id.context_item2) {
            Log.d("Stef", "Kontext Item 2 gedrückt");
        }
        return super.onContextItemSelected(item);
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
        } else if (id == R.id.item3) {
            Log.d("Stef", "Item 3 wurde geklickt");
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences settings = getSharedPreferences("MYPREFS", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("textvalue", editText.getText().toString());
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }
}
