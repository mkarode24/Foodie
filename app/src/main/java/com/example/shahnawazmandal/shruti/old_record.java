package com.example.shahnawazmandal.shruti;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class old_record extends AppCompatActivity {

    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_record);


        Bundle b= getIntent().getExtras();
        if(b==null)
            return;
         user= b.getString("username");

    }
    public void oldorders(View view)
    {
        Intent intent1 = new Intent(getApplicationContext(),show_records.class);
        intent1.putExtra("username",user);
        startActivity(intent1);

    }
    public  void next(View view)
    {
        Intent intent2 = new Intent(getApplicationContext(),res_list.class);
        startActivity(intent2);
    }
}