package com.example.shahnawazmandal.shruti;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class order_disp extends AppCompatActivity {


    String user="";
    TextView username;
    TextView order;
    EditText address;
    String order1;

    mydbhandler dbhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_disp);

      username=(TextView)findViewById(R.id.username);

        order=(TextView)findViewById(R.id.order);

        address=(EditText)findViewById(R.id.address);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
         user = sharedPref.getString("userName", "Not Available");
        username.setText(user);

        dbhandler= new mydbhandler(this,null,null,1);

        String address1= dbhandler.getAddress(user);

        address.setText(address1);


        Bundle b= getIntent().getExtras();
        if(b==null)
            return;
        order1= b.getString("order");
        order.setText(order1);
    }

    public void confirm(View view)
    {
     dbhandler.updateProduct(user,order1);
        Intent intent =new Intent(getApplicationContext(),finalpage.class);
        startActivity(intent);
    }
}
