package com.example.sqlite_quran_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecitationActivity extends AppCompatActivity {

    ListView listView;
    DBhelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recitation);
        listView = findViewById(R.id.list);
        helper = new DBhelper(this);
        ArrayList<SurahModel> arrayList = new ArrayList<>();
        arrayList = helper.gettingSurah();
        ArrayAdapter<SurahModel> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String text = "You Clicked on Position " + i;
            Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
            //Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            //intent.putExtra("positionIndex",String.valueOf(pos));
            //startActivity(intent);

        });
    }
}