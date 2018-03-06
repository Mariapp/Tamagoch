package com.example.didact.tamagochipet;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DIDACT on 06/03/2018.
 */

public class Usuario implements Parcelable {

    String nombre;
    String email;
    String password;


    public Usuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public static final Creator <Usuario> CREATOR = new Creator <Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };



    public Usuario() {
    }

    public Usuario (Parcel p){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(this.nombre);
        parcel.writeString(this.email);
        parcel.writeString(this.password);

    }

    private void readFromParcel(Parcel p) {

        this.nombre = p.readString();
        this.email = p.readString();
        this.password = p.readString();


    }

}
