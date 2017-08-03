package com.example.shahnawazmandal.shruti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


public class menu extends Activity{

    String order=" ";

    ListView list;

    String[] itemDes={"Aloo mutter is a Punjabi dish from the Indian " +
            "subcontinent which is made from potatoes and" +
            " peas in a spiced creamy tomato based sauce.\n Price: Rs.40",
            "Butter chicken or murgh makhani is an " +
            "Indian dish of chicken in a mildly spiced curry sauce.",
             "Chana masala, also known as channay or " +
                     "chole masala or chole or chholay, " +
                     "is a dish in Indian cuisine and Pakistani cuisine.\n Price: Rs.60 ",
               "Gajar ka halwa, also known as gajrela or" +
                       " gajorer halwa, is a sweet " +
                       " pudding originating from the Indian subcontinent","Chapati, also known as roti and roshi, " +
            "is an unleavened flatbread from the Indian" +
            " Subcontinent; and popular staple in India," +
            " Nepal, Bangladesh, Pakistan, and Sri Lanka.\n Price: Rs.90","Kheer is a rice pudding from the cuisine of the Indian Subcontinent, made by boiling rice, broken wheat," +
            " tapioca, or vermicelli with milk and sugar;" +
            " it is flavoured with cardamom, raisins, saffron, cashews, pistachios or almonds.\n Price: Rs.40"};
    String[] itemname ={
            "Aloo Matar ",
            "Butter Chicken",
            "Chana Masala",
            "Carrot Halwa",
            "Chapati",
            "Kheer"


    };

    Integer[] imgid={
            R.drawable.aloo_matar,
            R.drawable.butter_chicken,
            R.drawable.chana_masala,
            R.drawable.carrot_halwa,
            R.drawable.chappati,
            R.drawable.kheer



    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        CustomListAdapter adapter= new CustomListAdapter(this, itemname, imgid, itemDes);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub


                order=order+ itemname[+position]+"\n";
                Toast.makeText(getApplicationContext(), itemname[+position]+" added to cart", Toast.LENGTH_SHORT).show();

            }
        });
    }


    public  void done(View view)
    {
        Intent intent= new Intent(getApplicationContext(),order_one.class);
        intent.putExtra("order",order);
        startActivity(intent);
    }
}