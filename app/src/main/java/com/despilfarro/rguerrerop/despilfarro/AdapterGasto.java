package com.despilfarro.rguerrerop.despilfarro;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterGasto extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<ItemGasto> items;

    public AdapterGasto (Activity activity, ArrayList<ItemGasto> items) {
        this.activity = activity;
        this.items = items;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.list_item_layout, null);
        }

        ItemGasto dir = items.get(position);


        ImageView imagen = (ImageView) v.findViewById(R.id.usr);
        imagen.setImageDrawable(dir.getUsr());


        TextView producto = (TextView) v.findViewById(R.id.producto);
        producto.setText(dir.getProducto());

        TextView description = (TextView) v.findViewById(R.id.precio);
        description.setText(dir.getImporte());

        TextView fecha = (TextView) v.findViewById(R.id.fecha);
        fecha.setText(dir.getFecha());

        TextView usuario = (TextView) v.findViewById(R.id.usuario);
        usuario.setText(dir.getUsuario());


        return v;
    }
}
