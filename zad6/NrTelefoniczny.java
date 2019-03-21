/*
Napisz klase NrTelefoniczny, posiadajaca 2 pola: nrkierunkowy i nrTelefonu i implementujaca interfejs Comparable.
*/

public class NrTelefoniczny implements Comparable<NrTelefoniczny>{
    private int nrKierunkowy, nrTelefonu;

    public NrTelefoniczny(int nrKierunkowy, int nrTelefonu) {
        this.nrKierunkowy = nrKierunkowy;
        this.nrTelefonu = nrTelefonu;
    }

    public String getWholeNumber() {
        return Integer.toString(nrKierunkowy) + " " + Integer.toString(nrTelefonu);
    }
    
    @Override
    public int compareTo(NrTelefoniczny o) {
        return Integer.compare(this.nrTelefonu, o.nrTelefonu);
    }
    
}
