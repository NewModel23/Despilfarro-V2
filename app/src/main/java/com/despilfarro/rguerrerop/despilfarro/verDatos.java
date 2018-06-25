package com.despilfarro.rguerrerop.despilfarro;

import android.app.Activity;
import android.content.ContentValues;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Map;


public class verDatos extends AppCompatActivity {


    DatabaseReference dref;

    public static final String TAG ="verDatos" ;
    //ArrayAdapter<String> adapter;
    Drawable respi;

    int totalely;
    int totalrul;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verdata);

        final ListView listado = (ListView)findViewById(R.id.lvdatos);
        final ListView listado2 = (ListView)findViewById(R.id.lvdatos2);



        final TextView rulchis = (TextView)findViewById(R.id.totalrul);
        final TextView ely = (TextView)findViewById(R.id.totalely);

        final ArrayList ItemGasto = new ArrayList();
        final ArrayList ItemGasto2 = new ArrayList();

        //final ItemGasto itm = new ItemGasto(getResources().getDrawable(R.drawable.usermale),"2018-01-01","Rulas","Papas y refresco","$1500");
        //final ItemGasto itm2 = new ItemGasto(getResources().getDrawable(R.drawable.usermale),"2018-01-01","Rulas","Papas y refresco","$1500");

        final AdapterGasto adapter = new AdapterGasto(this, ItemGasto);
        final AdapterGasto adapter2 = new AdapterGasto(this, ItemGasto2);

        dref = FirebaseDatabase.getInstance().getReference();
        dref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                totalely = 0;
                totalrul = 0;
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String usuario = ds.child("usuario").getValue(String.class);
                    if (usuario.length() == 9 ){
                        respi = getResources().getDrawable(R.drawable.userfemale);
                        ItemGasto itm = new ItemGasto(respi,ds.child("fecha").getValue(String.class),ds.child("usuario").getValue(String.class),ds.child("producto").getValue(String.class).substring(0,Math.min( ds.child("producto").getValue(String.class).length(),21)),"$" + ds.child("importe").getValue(String.class));
                        ItemGasto.add(itm);
                        listado.setAdapter(adapter);
                        totalely = totalely + (Integer.parseInt(ds.child("importe").getValue(String.class)));
                        ely.setText("$" + String.valueOf(totalely));
                    }else{
                        respi = getResources().getDrawable(R.drawable.usermale);
                        ItemGasto itm2 = new ItemGasto(respi,ds.child("fecha").getValue(String.class),ds.child("usuario").getValue(String.class),ds.child("producto").getValue(String.class).substring(0,Math.min( ds.child("producto").getValue(String.class).length(),21)),"$" + ds.child("importe").getValue(String.class));
                        ItemGasto2.add(itm2);
                        listado2.setAdapter(adapter2);
                        totalrul = totalrul + (Integer.parseInt(ds.child("importe").getValue(String.class)));
                        rulchis.setText("$" + String.valueOf(totalrul));
                    }
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {






            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {






            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }




}
