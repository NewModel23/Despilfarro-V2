package com.despilfarro.rguerrerop.despilfarro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    EditText txtdesc, importe;
    Button submit, ver;
    DatabaseReference rootRef,demoRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtdesc = (EditText) findViewById(R.id.txtdesc);
        importe = (EditText) findViewById(R.id.txtimporte);
        submit = (Button) findViewById(R.id.btnguardar);
        ver = (Button) findViewById(R.id.btnver);


        rootRef = FirebaseDatabase.getInstance().getReference();
        //database reference pointing to demo node
        demoRef = rootRef.child("gastos");

        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),verDatos.class);
                startActivity(intent);
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                Date date = new Date();
                String dateTime = dateFormat.format(date);
                String value1 = txtdesc.getText().toString();
                String value2 = importe.getText().toString();
                /* Hardcodeado por el momento*/
                String value0 = "Rulchis";
                //String value0 = "Elizabeth";

                if (value1.length() > 0 && value2.length() > 0) {

                    HashMap<String, Object> result = new HashMap<>();
                    result.put("usuario", value0);
                    result.put("fecha", dateTime);
                    result.put("producto", value1);
                    result.put("importe", value2);
                    //push creates a unique id in database
                    demoRef.push().setValue(result);

                    txtdesc.setText("");
                    importe.setText("");

                    //Toast.makeText(MainActivity.this, "Gracias Panteritha Mosha!", Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this    , "Gracias Rulchis!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "No hay nada que guardar, no pinshis mames", Toast.LENGTH_LONG).show();
                }



            }
        });
    }

}
