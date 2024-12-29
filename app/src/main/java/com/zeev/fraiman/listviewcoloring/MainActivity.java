package com.zeev.fraiman.listviewcoloring;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> parts;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.lv);
        parts=new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            parts.add("Part #"+(i+1));
        }
        adapter=new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, parts)  {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view= super.getView(position, convertView, parent);
                TextView textView = view.findViewById(android.R.id.text1);;
                if (position%3==0) {
                    view.setBackgroundColor(Color.parseColor("#8989AA"));
                    view.setTranslationX(100f);
                }
                if (position%3==1) {
                    view.setBackgroundColor(Color.parseColor("#00FFFF"));
                    textView.setTextColor(Color.MAGENTA);
                    textView.animate().rotation(360).setDuration(2000).start();
                }
                if (position%3==2)  {
                    view.setBackgroundColor(Color.parseColor("#FAFA00"));
                    textView.setTextSize(30f);
                }
                return view;
            }
        };
        lv.setAdapter(adapter);
    }
}
