package com.example.shahnawazmandal.shruti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class show_records extends AppCompatActivity {

    mydbhandler dbhandler;
    EditText name;
    EditText order;

    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_records);

        name= (EditText)findViewById(R.id.name);
        order= (EditText)findViewById(R.id.order);

        dbhandler= new mydbhandler(this,null,null,1);

        Bundle b= getIntent().getExtras();
        if(b==null)
            return;
        user= b.getString("username");

        String result=dbhandler.access_record(user);
        order.setText(result);
        name.setText(user);



    }
}
