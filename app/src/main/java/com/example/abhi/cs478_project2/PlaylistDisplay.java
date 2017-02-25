package com.example.abhi.cs478_project2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlaylistDisplay extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_display);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar5);

        // myToolbar.setBackgroundColor(Color.parseColor("#3f51b5"));
        setSupportActionBar(myToolbar);



        Bundle extras = getIntent().getExtras();
        ArrayList<String> songs_received = extras.getStringArrayList("songs");

        int len=songs_received.size();

        String [] songs=new String[len];

        Iterator<String> itr1= songs_received.iterator();
        int i=0;
        while(itr1.hasNext()&&i<7)
        {
            songs[i]=itr1.next();
            i=i+1;
        }



        GridView myGrid=(GridView)findViewById(R.id.Grid);

       // myGrid.setAdapter(new ArrayAdapter<String>(this,R.layout.cell, songs_received));

        // A custom Gridview is called which is responsible for displaying the images
        myGrid.setAdapter(new GridViewAdapter(this, songs));

        myGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
               String song_clicked= ((TextView) view.findViewById(R.id.grid_item_label)).getText().toString();

                Play_song(song_clicked);

                            }


        });

       registerForContextMenu(myGrid);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo)
    {
     super.onCreateContextMenu(menu, view, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.contextmenu, menu);
    }

   @Override
    public boolean onContextItemSelected(MenuItem item)
    {

        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();




        String song_clicked= ((TextView) info.targetView.findViewById(R.id.grid_item_label)).getText().toString();


        switch (item.getItemId())
        {
            case R.id.play_song:
                Play_song(song_clicked);
                return true;

            case R.id.song_wiki:
                Song_wiki(song_clicked);
                return true;

            case R.id.artist_wiki:
                Artist_wiki(song_clicked);
                return true;

            default:
                return super.onContextItemSelected(item);

        }




    }


public void Play_song(String song_clicked)
{
    if(song_clicked.equals("HymnForTheWeekend"))
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=YykjpeuMNEk")));
    }
    else if(song_clicked.equals("Perfect"))
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Ho32Oh6b4jc")));
    }
    else if(song_clicked.equals("ChannaMereya"))
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=z-diRlyLGzo")));
    }
    else if(song_clicked.equals("InTheEnd"))
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=eVTXPUF4Oz4")));
    }
    else if(song_clicked.equals("RangDeBasanti"))
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=-rkOODu58C0")));
    }
    else if(song_clicked.equals("TheScientist"))
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=RB-RcX5DS5A")));
    }


    Toast.makeText(
            getApplicationContext(), "Playing song...", Toast.LENGTH_SHORT).show();
}


    public void Song_wiki(String song_clicked)
    {
        if(song_clicked.equals("HymnForTheWeekend"))
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Hymn_for_the_Weekend")));
        }
        else if(song_clicked.equals("Perfect"))
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Perfect_(One_Direction_song)")));
        }
        else if(song_clicked.equals("ChannaMereya"))
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Ae_Dil_Hai_Mushkil")));
        }
        else if(song_clicked.equals("InTheEnd"))
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/In_the_End")));
        }
        else if(song_clicked.equals("RangDeBasanti"))
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Rang_De_Basanti_(soundtrack)")));
        }
        else if(song_clicked.equals("TheScientist"))
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/The_Scientist_(song)")));
        }


        Toast.makeText(
                getApplicationContext(), "Opening Song's wiki page", Toast.LENGTH_SHORT).show();
    }


    public void Artist_wiki(String song_clicked)
    {
        if(song_clicked.equals("HymnForTheWeekend"))
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Coldplay")));
        }
        else if(song_clicked.equals("Perfect"))
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/One_Direction")));
        }
        else if(song_clicked.equals("ChannaMereya"))
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Arijit_Singh")));
        }
        else if(song_clicked.equals("InTheEnd"))
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Linkin_Park")));
        }
        else if(song_clicked.equals("RangDeBasanti"))
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Daler_Mehndi")));
        }
        else if(song_clicked.equals("TheScientist"))
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Coldplay")));
        }


        Toast.makeText(
                getApplicationContext(), "Opening Artist's Wiki page..", Toast.LENGTH_SHORT).show();
    }



}