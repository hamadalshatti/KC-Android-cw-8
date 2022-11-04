package com.example.adaptertraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FlightsDetiels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights_detiels);
        Bundle a = getIntent().getExtras();
        ImageView b = findViewById(R.id.disimage);
        TextView c = findViewById(R.id.disname);
        TextView d = findViewById(R.id.disprice);

        Item taxi = (Item) a.getSerializable("dits");
        b.setImageResource(taxi.getFlightimage());
        c.setText(taxi.getFlightname());
        d.setText(taxi.getFlightprice()+"KD");

    }
}