package com.example.shahnawazmandal.shruti;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText use,password;
    Button B1,B2;
    mydbhandler dbhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        use = (EditText)findViewById(R.id.username);
        password= (EditText)findViewById(R.id.pass);
        B1=(Button)findViewById(R.id.login);
        B2=(Button)findViewById(R.id.clear);

        dbhandler= new mydbhandler(this,null,null,1);

    }


    public void Login(View view)
    {
        String n= use.getText().toString();
        String m= password.getText().toString();

        if(n.equals("")|| m.equals(""))
            Toast.makeText(getApplicationContext(),"please fill both entries",Toast.LENGTH_LONG).show();



        else if(dbhandler.verify(n, m)==1)
        {
            // Create object of SharedPreferences.
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            //now get Editor
            SharedPreferences.Editor editor = sharedPref.edit();
            //put your value
            editor.putString("userName", n);

            //commits your edits
            editor.commit();

            Toast.makeText(getApplicationContext(),"WELCOME",Toast.LENGTH_LONG).show();
            Intent intent= new Intent(getApplicationContext(),old_record.class);
            intent.putExtra("username",n);
            startActivity(intent);
        }
        else  Toast.makeText(getApplicationContext(),"INVALID USER",Toast.LENGTH_LONG).show();




      /*  if(n.equals("Shru") &&m.equals("1")){
            Context context = getApplicationContext();
            CharSequence text = "Hello toast!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            Intent intent= new Intent(getApplicationContext(),menu.class);
            startActivity(intent);
        }

        else{
            Context context = getApplicationContext();
            CharSequence text = "Fuck u";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }*/

    }

    public void CLear(View view)
    {
        use.setText("");
        password.setText("");
       /* String s=dbhandler.databaseToString1();
        use.setText(s);*/
    }


    public void signin(View view)
    {
        Intent intent= new Intent(getApplicationContext(),signup.class);
        startActivity(intent);
    }
}
