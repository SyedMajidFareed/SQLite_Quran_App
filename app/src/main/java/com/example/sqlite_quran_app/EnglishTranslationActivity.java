package com.example.sqlite_quran_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EnglishTranslationActivity extends AppCompatActivity {
    String pos;
    int convtdpos;
    int sspPos;
    int endssp;
    DBhelper helper;
    ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_translation);
        helper = new DBhelper(this);
        Intent intent1 = getIntent();
        pos = intent1.getStringExtra("positionIndex");
        convtdpos = Integer.valueOf(pos);
        String[] EnglishText = helper.gettingEnglishMTU();
        ArrayList<String> data2 = new ArrayList<>();
        GivenData data1= new GivenData();

        sspPos = data1.SSP[convtdpos];
        endssp = data1.SSP[convtdpos+1] - 1;
        int i = 0;
        for(i=sspPos-1;i<endssp;i++)
        {
            data2.add(EnglishText[i]);
        }
        i=0;
        listView1 = findViewById(R.id.engtranslist);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data2);
        listView1.setAdapter(arrayAdapter1);
    }
}