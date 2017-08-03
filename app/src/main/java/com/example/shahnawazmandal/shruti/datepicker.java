package com.example.shahnawazmandal.shruti;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;

import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class datepicker extends Activity {
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    String order=" ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);

        dateView = (TextView) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        Bundle b= getIntent().getExtras();
        if(b==null)
            return;
        order= b.getString("order");
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
       // Toast.makeText(getApplicationContext(), "ca",
       //         Toast.LENGTH_SHORT)
        //        .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        StringBuilder s=new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year);
        dateView.setText(s);
    }

    public void time(View view)
    {
        StringBuilder s=new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year);
        String order1= "("+s+"):"+ order;
        Intent intent=new Intent(getApplicationContext(),timepicker.class);
        intent.putExtra("order",order1);
        startActivity(intent);

    }
}