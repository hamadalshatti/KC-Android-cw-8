package com.example.adaptertraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Item> flights=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    //String flightname, int flightimage, double flightprice)
    //30 dubai,300 edinbruh
      Item f1=new Item("Kuwait to Rome",R.drawable.rome , 149.99);
      Item f2= new Item("Kuwait to Dubai",R.drawable.dubai,29.99);
      Item f3=new Item("Kuwait to Edinbruh",R.drawable.edinbruh,299.99);
      flights.add(f1);
      flights.add(f2);
      flights.add(f3);
        ListView flights2=(findViewById(R.id.flightslist));

        Flightsadapte flightsadapte= new Flightsadapte(this,0,flights);

        flights2.setAdapter(flightsadapte);


        flights2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Item currentitem= flights.get(position);

                Intent in = new Intent(MainActivity.this , FlightsDetiels.class);
                in.putExtra("dits",currentitem);
                startActivity(in);





            }
        });



    }
}