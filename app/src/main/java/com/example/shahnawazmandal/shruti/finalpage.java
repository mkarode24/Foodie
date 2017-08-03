package com.example.shahnawazmandal.shruti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class finalpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpage);
    }

    public void neworder(View view)
    {

        Intent intent=new Intent(getApplicationContext(),res_list.class);
        startActivity(intent);
    }
}
