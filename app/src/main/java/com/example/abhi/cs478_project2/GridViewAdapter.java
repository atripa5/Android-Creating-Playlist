package com.example.abhi.cs478_project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;


public class GridViewAdapter extends BaseAdapter {

    private Context c;
    private final String[] songs;

    public GridViewAdapter(Context c, String[] songs){

       this.c=c;
        this.songs=songs;


        }

        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View gridView = null;

            if (convertView == null) {

                gridView = new View(c);

                gridView = inflater.inflate(R.layout.grid_display, null);

                // set value into textview
                      TextView textView = (TextView) gridView.findViewById(R.id.grid_item_label);
                   textView.setText(songs[position]);

                // set image based on selected text
                ImageView imageView = (ImageView) gridView
                        .findViewById(R.id.grid_item_image);


                String songs_display = songs[position];


                if (songs_display.equals("HymnForTheWeekend")) {
                    imageView.setImageResource(R.drawable.hymn);
                } else if (songs_display.equals("Perfect")) {
                    imageView.setImageResource(R.drawable.perfect);

                } else if (songs_display.equals("ChannaMereya")) {
                    imageView.setImageResource(R.drawable.channa);
                }
                else if (songs_display.equals("InTheEnd")) {
                    imageView.setImageResource(R.drawable.intheend);

                } else if (songs_display.equals("RangDeBasanti")) {
                    imageView.setImageResource(R.drawable.rang);
                }
                else if (songs_display.equals("TheScientist")) {
                    imageView.setImageResource(R.drawable.scientist);
                }
            }
                    else {
                        gridView = (View) convertView;
                    }//else {
                        //imageView.setImageResource(R.drawable.android_logo);
                    //}



            return gridView;
        }








    @Override
    public int getCount() {
        return songs.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

}
