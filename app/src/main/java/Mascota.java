import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DIDACT on 06/03/2018.
 */

public class Mascota implements Parcelable {

    String nombre;
    int peso;
    String raza;
    int cp;


    public Mascota(String nombre, int peso, String password, int cp) {
        this.nombre = nombre;
        this.raza = raza;
        this.peso = peso;
        this.cp = cp;
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

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
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
        parcel.writeInt(this.cp);
        parcel.writeInt(this.peso);

    }

    private void readFromParcel(Parcel p) {

        this.nombre = p.readString();
        this.raza = p.readString();
        this.peso = p.readInt();
        this.cp = p.readInt();



    }

}