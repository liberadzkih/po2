/*
    Klasa Firma ma miec nazwe i adres( w tym NrTelefonu).
 */

public class Firma extends Wpis {
    
    private String nazwa, adres;

    public Firma(String nazwa, String adres) {
        this.nazwa = nazwa;
        this.adres = adres;
    }
    
    
    @Override
    String opis() {
        return "Nazwa firmy: " + nazwa + ", Adres: " + adres;
    }
    
}
