/*
Nastepnie utworz abstrakcyjna klase Wpis a nastepnie dziedziczace z niej klasy Osoba i Firma. 
Klasa Wpis ma abstrakcyjna metode opis, ktora opisuje dany wpis. Byc moze ma rowniez inne metody abstrakcyjne lub nie w miare potrzeb. 
*/

abstract class Wpis {
    abstract String opis();
    public NrTelefoniczny nrKontaktowy;
}
