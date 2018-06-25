package com.despilfarro.rguerrerop.despilfarro;

import android.graphics.drawable.Drawable;

public class ItemGasto {

    private Drawable usr;
    private String fecha;
    private String usuario;
    private String producto;
    private String importe;

    public ItemGasto(){
        super();
    }

    public void setUsr(Drawable usr) {
        this.usr = usr;
    }
    public Drawable getUsr() {
        return usr;
    }


    public String getFecha() {
        return fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getProducto() {
        return producto;
    }

    public String getImporte() {
        return importe;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public ItemGasto (Drawable usr, String fecha, String usuario, String producto, String importe){
    super();
    this.usr = usr;
    this.fecha = fecha;
    this.usuario = usuario;
    this.producto = producto;
    this.importe = importe;
}



}
