/*
Napisz klase NrTelefoniczny, posiadajaca 2 pola: nrkierunkowy i nrTelefonu i implementujaca interfejs Comparable. 
Nastepnie utworz abstrakcyjna klase Wpis a nastepnie dziedziczace z niej klasy Osoba i Firma. 
Klasa Wpis ma abstrakcyjna metode opis, ktora opisuje dany wpis. Byc moze ma rowniez inne metody abstrakcyjne lub nie w miare potrzeb. 
Klasa Osoba ma zawierac informacje o imieniu, nazwisku, adresie i (w tym nrTelefonu). 
Klasa Firma ma miec nazwe i adres( w tym NrTelefonu). 
Utworz kilka obiektow klasy Osoba i kilka obiektow klasy Firma i umiesc je w kontenerze TreeMap, poslugujac sie jako kluczem numerem telefonicznym.
Nastepnie wypisz utworzona w ten sposob ksiazke telefoniczna za pomoca iteratora.

*/

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class java6 {
    
    public static void main(String[] args) {
        TreeMap<NrTelefoniczny, Wpis> kontener = new TreeMap<>();//TreeMap<K,V>
        
        Osoba osoba1 = new Osoba("Hubert", "Liberadzki", "Gostynin");
        Osoba osoba2 = new Osoba("Marek", "Mostowiak", "Warszawa");
        Osoba osoba3 = new Osoba("Adam", "Malysz", "Lodz");
        Firma firma1 = new Firma("Apple", "California");
        Firma firma2 = new Firma("QWERTY", "Lodz");
        
        osoba1.nrKontaktowy = new NrTelefoniczny(24, 2222222);
        osoba2.nrKontaktowy = new NrTelefoniczny(25, 3433333);
        osoba3.nrKontaktowy = new NrTelefoniczny(10, 4444434);
        firma1.nrKontaktowy = new NrTelefoniczny(66, 8888888);
        firma2.nrKontaktowy = new NrTelefoniczny(91, 1111111);
        
        kontener.put(osoba1.nrKontaktowy, osoba1);
        kontener.put(osoba2.nrKontaktowy, osoba2);
        kontener.put(osoba3.nrKontaktowy, osoba3);
        kontener.put(firma1.nrKontaktowy, firma1);
        kontener.put(firma2.nrKontaktowy, firma2);
        
		//https://stackoverflow.com/questions/46898/how-do-i-efficiently-iterate-over-each-entry-in-a-java-map
		//Using iterator and Map.Entry
		Iterator<Map.Entry<NrTelefoniczny, Wpis>> it = kontener.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<NrTelefoniczny, Wpis> pair = it.next();
			System.out.println("Numer kontaktowy: " + pair.getKey().getWholeNumber());
			System.out.println(pair.getValue().opis() + "\n");
		}
    }
}
