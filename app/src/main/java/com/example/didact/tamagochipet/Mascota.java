package com.example.didact.tamagochipet;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DIDACT on 06/03/2018.
 */

public class Mascota implements Parcelable {

    String nombre;
    int peso;
    String raza;
    int CP;


    public Mascota(String nombre, int peso, String raza, int CP) {
        this.nombre = nombre;
        this.raza = raza;
        this.peso = peso;
        this.CP = CP;
    }

    public static final Creator <Mascota> CREATOR = new Creator <Mascota>() {
        @Override
        public Mascota createFromParcel(Parcel in) {
            return new Mascota(in);
        }

        @Override
        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };



    public Mascota() {
    }

    public Mascota (Parcel p){

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    public static Creator <Mascota> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(this.nombre);
        parcel.writeString(this.raza);
        parcel.writeInt(this.CP);
        parcel.writeInt(this.peso);

    }

    private void readFromParcel(Parcel p) {

        this.nombre = p.readString();
        this.raza = p.readString();
        this.peso = p.readInt();
        this.CP = p.readInt();



    }

}