package com.example.abhi.cs478_project2;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.checked;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> selections= new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar4);

       // myToolbar.setBackgroundColor(Color.parseColor("#3f51b5"));
        setSupportActionBar(myToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        CheckBox checkBox1 = (CheckBox)findViewById(R.id.Hymn);
        CheckBox checkBox4 = (CheckBox)findViewById(R.id.InTheEnd);
        CheckBox checkBox2 = (CheckBox)findViewById(R.id.Perfect);
        CheckBox checkBox3 = (CheckBox)findViewById(R.id.ChannaMereya);
        CheckBox checkBox5 = (CheckBox)findViewById(R.id.RangDeBasanti);
        CheckBox checkBox6 = (CheckBox)findViewById(R.id.TheScientist);


        View view = null;
        switch (item.getItemId()) {
            case R.id.create_playlist:
                FinalSelection(view);

                return true;

            case R.id.clear_all:

                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                checkBox4.setChecked(false);
                checkBox5.setChecked(false);
                checkBox6.setChecked(false);

                return true;

            case R.id.invert_selection:
                checkBox1.setChecked(!checkBox1.isChecked());
                checkBox2.setChecked(!checkBox2.isChecked());
                checkBox3.setChecked(!checkBox3.isChecked());
                checkBox4.setChecked(!checkBox4.isChecked());
                checkBox5.setChecked(!checkBox5.isChecked());
                checkBox6.setChecked(!checkBox6.isChecked());

                return true;

            case R.id.select_all:
                checkBox1.setChecked(true);
                checkBox2.setChecked(true);
                checkBox3.setChecked(true);
                checkBox4.setChecked(true);
                checkBox5.setChecked(true);
                checkBox6.setChecked(true);

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }



    public void SelectedItems()
    {
        CheckBox checkBox1 = (CheckBox)findViewById(R.id.Hymn);
        CheckBox checkBox4 = (CheckBox)findViewById(R.id.InTheEnd);
        CheckBox checkBox2 = (CheckBox)findViewById(R.id.Perfect);
        CheckBox checkBox3 = (CheckBox)findViewById(R.id.ChannaMereya);
        CheckBox checkBox5 = (CheckBox)findViewById(R.id.RangDeBasanti);
        CheckBox checkBox6 = (CheckBox)findViewById(R.id.TheScientist);

        if(checkBox1.isChecked())
        { if(!selections.contains("HymnForTheWeekend"))
            selections.add("HymnForTheWeekend");
        }
        else{
            selections.remove("HymnForTheWeekend");
        }



        if(checkBox2.isChecked())
        { if(!selections.contains("Perfect"))
                {
                    selections.add("Perfect");
                }}
        else{
                    selections.remove("Perfect");

                }


        if(checkBox3.isChecked())
                {if(!selections.contains("ChannaMereya"))
                    selections.add("ChannaMereya");
                }
                else{
                    selections.remove("ChannaMereya");
                }

        if(checkBox4.isChecked())
                { if(!selections.contains("InTheEnd"))
                    selections.add("InTheEnd");
                }
                else{
                    selections.remove("InTheEnd");
                }

        if(checkBox5.isChecked())
                { if(!selections.contains("RangDeBasanti"))
                    selections.add("RangDeBasanti");
                }
                else{
                    selections.remove("RangDeBasanti");
                }

        if(checkBox6.isChecked())
                { if(!selections.contains("TheScientist"))
                    selections.add("TheScientist");
                }
                else{
                    selections.remove("TheScientist");
                }



    }


    public void FinalSelection(View view)
    {


       SelectedItems();


        Intent Playlist_display = new Intent(MainActivity.this, PlaylistDisplay.class);
        Playlist_display.putStringArrayListExtra("songs", selections);


        if(selections.isEmpty()) {
            Toast.makeText(MainActivity.this, "Select at least one song to create a playlist!",
                    Toast.LENGTH_LONG).show();




        }
        else
        {
            startActivity(Playlist_display);
        }

    }



}
