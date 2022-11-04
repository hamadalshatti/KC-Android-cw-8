package com.example.adaptertraining;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class Flightsadapte extends ArrayAdapter<Item> {
    List<Item> flightslist;

    public Flightsadapte(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        flightslist=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.flight_row,parent,false);
        Item currentflight= flightslist.get(position);
        TextView flightname= v.findViewById(R.id.flightname);
        TextView flightprice= v.findViewById(R.id.flightprice);
        ImageView flightimage= v.findViewById(R.id.flightimage);
        ImageView bin = v.findViewById(R.id.bin);


        flightname.setText(currentflight.getFlightname());
        flightprice.setText(currentflight.getFlightprice() + "KD");
        flightimage.setImageResource(currentflight.getFlightimage());
        bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                flightslist.remove(position);
//                notifyDataSetChanged();
                AlertDialog.Builder notybox= new AlertDialog.Builder(v.getRootView().getContext());
                notybox.setMessage("DO YOU TO DELETE THIS?");
                notybox.setTitle("confirmation");
                notybox.setPositiveButton("delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        flightslist.remove(currentflight);
                notifyDataSetChanged();
                        Snackbar.make(getContext(),v,"Your item has been deleted",3000).setAction("undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                flightslist.add(currentflight);
                                notifyDataSetChanged();
                            }
                        }).show();

                    }

                });

                notybox.setNegativeButton("return", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                   dialogInterface.dismiss();
                    }
                });
                notybox.show();



            }
        });

       return v;






    }
}
