package com.example.shahnawazmandal.shruti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class order_one extends AppCompatActivity {

    String order;
    EditText show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_one);

        show=(EditText)findViewById(R.id.order);

        Bundle b= getIntent().getExtras();
        if(b==null)
            return;
        order= b.getString("order");

        show.setText(order);
    }

    public void place_order(View view)
    {
          Intent intent=new Intent(getApplicationContext(),datepicker.class);
         intent.putExtra("order",order);
        startActivity(intent);
    }


    public void Undo(View view)
    {
        Intent intent=new Intent(getApplicationContext(),old_record.class);
        startActivity(intent);
    }
}
