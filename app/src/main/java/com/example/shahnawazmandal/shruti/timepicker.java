package com.example.shahnawazmandal.shruti;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class timepicker extends Activity {
    private TimePicker timePicker1;
    private TextView time;
    private Calendar calendar;
    private String format = "";

    StringBuilder time1;
    String order;
    String order1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);

        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        time = (TextView) findViewById(R.id.textView1);
        calendar = Calendar.getInstance();

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        showTime(hour, min);


        Bundle b= getIntent().getExtras();
        if(b==null)
            return;
        order= b.getString("order");
    }

    public void setTime(View view) {
        int hour = timePicker1.getCurrentHour();
        int min = timePicker1.getCurrentMinute();
        showTime(hour, min);
    }

    public void showTime(int hour, int min) {
        if (hour == 0) {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }

        time1=new StringBuilder().append(hour).append(" : ").append(min)
                .append(" ").append(format);

        time.setText(time1);
    }

    public void checkout(View view)
    {
        order1= "("+time1+")"+ order;
        Intent intent=new Intent(getApplicationContext(),order_disp.class);
        intent.putExtra("order",order1);
        Toast.makeText(getApplicationContext(), "Displaying your final order",
                Toast.LENGTH_SHORT)
                .show();
        startActivity(intent);

    }


}
