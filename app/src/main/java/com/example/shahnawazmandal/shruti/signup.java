package com.example.shahnawazmandal.shruti;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText name;
    EditText password;
    EditText address;
    EditText phone;

    mydbhandler dbhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        address=(EditText)findViewById(R.id.address);
        phone=(EditText)findViewById(R.id.phone);


        dbhandler=  new mydbhandler(this,null,null,1);


    }




    public void submit(View view)
    {
      products product=new products(name.getText().toString()," ",address.getText().toString(),password.getText().toString());
        dbhandler.addProduct(product);


        // Create object of SharedPreferences.
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        //now get Editor
        SharedPreferences.Editor editor = sharedPref.edit();
        //put your value
        editor.putString("userName", name.getText().toString());

        //commits your edits
        editor.commit();

        Intent intent =new Intent(getApplicationContext(),res_list.class);
        Toast.makeText(getApplicationContext(), "Welcome... showing you nearest restaurants",
                Toast.LENGTH_SHORT)
                .show();

        startActivity(intent);

    }
    public void clear(View view)
    {
        name.setText("");
        password.setText("");
        phone.setText("");
        address.setText("");

       /* String s=dbhandler.databaseToString1();
        use.setText(s);*/
    }
}
