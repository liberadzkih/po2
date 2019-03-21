/*
Klasa Osoba ma zawierac informacje o imieniu, nazwisku, adresie i (w tym nrTelefonu).
 */

public class Osoba extends Wpis {
    
    private String imie, nazwisko, adres;

    public Osoba(String imie, String nazwisko, String adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
    }
    
    @Override
    String opis() {
        return "Osoba: " + imie + " " + nazwisko + ", Adres: " + adres; 
    }
    
}
