package com.example.shahnawazmandal.shruti;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class res_actions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_actions);
    }


    public void menu(View view){
        Intent intent=new Intent(getApplicationContext(),menu.class);
        startActivity(intent);
    }


    public void review(View view){

        Intent obj=new Intent(Intent.ACTION_VIEW);
        obj.setData(Uri.parse("https://www.yelp.com/writeareview/"));
        startActivity(obj);

    }


    public void complaint(View view){


        Intent obj=new Intent(Intent.ACTION_VIEW);
        obj.setData(Uri.parse("https://nationalconsumerhelpline.in/foodSafety.aspx/"));
        startActivity(obj);
    }


    public void call(View view)

    {
        Intent obj=new Intent(Intent.ACTION_DIAL);
        obj.setData(Uri.parse("tel:+8678768659"));
        startActivity(obj);

    }
}
