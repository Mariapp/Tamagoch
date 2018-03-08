package com.example.didact.tamagochipet;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DIDACT on 06/03/2018.
 */



 public class Mascota implements Parcelable{
        String nombre;
        String raza;
        String CP;
        String imagen;
        String tipo;

    public Mascota(String nombre, String raza, String CP, String imagen, String tipo) {
        this.nombre = nombre;
        this.raza = raza;
        this.CP = CP;
        this.imagen = imagen;
        this.tipo=tipo;
    }

    public Mascota() {
    }

    public Mascota(Parcel in) {
        nombre = in.readString();
        raza = in.readString();
        CP = in.readString();
        imagen = in.readString();
        tipo=in.readString();

    }

    public static final Creator <Mascota> CREATOR = new Creator <Mascota>() {
        @Override
        public Mascota createFromParcel(Parcel in) {
            return new Mascota(in);
        }

        @Override
        public Mascota [] newArray(int size) {
            return new Mascota[size];
        }
    };


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nombre);
        parcel.writeString(this.raza);
        parcel.writeString(this.imagen);
        parcel.writeString(this.CP);
        parcel.writeString(this.tipo);

    }
    private void readFromParcel(Parcel p) {

        this.nombre = p.readString();
        this.raza = p.readString();
        this.CP = p.readString();
        this.imagen = p.readString();
        this.tipo=p.readString();

    }

}