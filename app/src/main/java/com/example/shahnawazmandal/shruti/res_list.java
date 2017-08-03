package com.example.shahnawazmandal.shruti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


public class res_list extends Activity{



    ListView list;

    String[] itemDes={"(4.6 out of 5) Authentic North Indian Food.",
                    "(4 out of 5) Known for its Desert Creations",
            "(4.7 out of 5)  Every known food of Indian Subcontinent Available here",
            "(3.9 out of 5)  Best Food At Best Prices","(4.5 out of 5)  25 Years of Delicious North Indian Food",};
    String[] itemname ={
            "Delhi Mess",
            "Mumbai Spice",
            "Desi Tadka",
            "North Indian Meals",
            "The Indian"


    };

    Integer[] imgid={
            R.drawable.res1,
            R.drawable.res2,
            R.drawable.res3,
            R.drawable.res4,
            R.drawable.res5




    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_list);

        CustomListAdapter1 adapter=new CustomListAdapter1(this, itemname, imgid, itemDes);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub

               Intent intent=new Intent(getApplicationContext(),res_actions.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Displaying menu for "+itemname[+position], Toast.LENGTH_SHORT).show();

            }
        });
    }



}