package com.example.app;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Main3 extends ActionBarActivity {
    private EditText editText;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private int counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counter = 0;
        setContentView(R.layout.main);
        Log.d("Stef", "Activity Main started");

        SharedPreferences settings = getSharedPreferences("MYPREFS", 0);
        String defaultSettings = settings.getString("textvalue", "");

        Toast toast = Toast.makeText(Main3.this, defaultSettings, 5000);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();


        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        editText = (EditText) findViewById(R.id.editText);


        button1.setText("Change the text");
        button2.setText("Pictures Activity");
        button3.setText("Text Activity");
        button4.setText("Exit");
        button5.setText("Toast");
        button6.setText("Video Activity");
        button7.setText("Take a Picture");

        registerForContextMenu(button1);
        registerForContextMenu(button2);
        registerForContextMenu(button3);
        registerForContextMenu(button4);
        registerForContextMenu(button5);
        registerForContextMenu(button6);
        registerForContextMenu(button7);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                if (counter >= 5) {
                    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    Notification notification = new Notification(android.R.drawable.stat_notify_more, "This is important", System.currentTimeMillis());
                    Context context = Main3.this;
                    CharSequence title = "You have been notified";
                    CharSequence details = "These are the details";
                    Intent intent = new Intent(context, Main3.class);
                    PendingIntent pending = PendingIntent.getActivity(context, 0, intent, 0);
                    notification.setLatestEventInfo(context, title, details, pending);
                    notification.sound = Uri.parse("android.resource://com.example.app/" + R.raw.beep);
                    notificationManager.notify(0, notification);

                } else if (counter <= 5) {
                    Log.d("Stef", "Button 1 wurde zum " + counter + "ten mal gedrückt");
                    editText.setText("Button 1 wurde zum " + counter + "ten mal gedrückt");
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Stef", "Button 2 gedrückt");
                Intent intent = new Intent(Main3.this, Pictures.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Stef", "Button 3 gedrückt");
                Intent intent = new Intent(Main3.this, Text.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Stef", "Button \"Cancle\" gedrückt");
                AlertDialog.Builder builder = new AlertDialog.Builder(Main3.this);
                builder.setMessage("Willst du wirklich meine App verlassen :(");
                builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Main3.this.finish();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(Main3.this, "This is a Toast!", 5000);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main3.this, Video.class);
                startActivity(intent);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });


        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Stef", "EditText gedrückt");
            }
        });


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
       // imageView.setImageBitmap(bitmap);
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
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment, container, false);
            return rootView;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences("MYPREFS", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("textvalue", "The Settings have been loaded");
        editor.commit();
    }
}
