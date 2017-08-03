package com.example.shahnawazmandal.shruti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class first extends AppCompatActivity {

    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        listView1=(ListView)findViewById(R.id.listView);

        ArrayAdapter<String> mAdapter= new ArrayAdapter<String>(first.this,android.R.layout.simple_list_item_1
                ,getResources().getStringArray(R.array.option));

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), first.class);
                intent.putExtra("restaurant", listView1.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
        listView1.setAdapter(mAdapter);

    }
}
