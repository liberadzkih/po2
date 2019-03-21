/*
Napisz program proszacy o podanie 2 wektorow. 
Koniec wektora oznacza sie za pomoca wcisniecia klawisza enter. 
Jezeli podany ciag nie jest liczba, jest ignorowany. 
Nastepnie nalezy sprobowac dodac wektory, jezeli sa rownej dlugosci. 
Jezeli nie, sa, rzucany jest wlasny wyjatek WektoryRoznejDlugosciException, 
za pomoca ktorego mozna podac a nastepnie odczytac dlugosci tych wektorow. 
Jezeli sa rownej dlugosci, wynik dodawania zapisywany jest do pliku. 
Jezeli nie sa rownej dlugosci, uzytkownik jest proszony o ponowne wprowadzenie tych wektorow.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class java5 {
    
    public static void main(String[] args) {
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        Wektor vector1, vector2, vector3;
        
        boolean vectorsAreCorrect = false;
        
        while(!vectorsAreCorrect){
			try{
				System.out.print("Podaj pierwszy wektor:  ");
				vector1 = new Wektor(reader.readLine());
				System.out.print("Podaj drugi wektor:  ");
				vector2 = new Wektor(reader.readLine());
				
				System.out.print(vector1.getVector());
				System.out.print(" + ");
				System.out.print(vector2.getVector());
				System.out.print(" = ");
				vectorsAreCorrect = true;
			
                vector3 = new Wektor();
                vector3.addVector(vector1.getVector(), vector2.getVector());
                
                Zapis.saveToFile(vector3.getVector());
                System.out.println(vector3.getVector());
            }
            catch(WektoryRoznejDlugosciException e) {
                e.printStackTrace(System.err);
                System.err.println("Wrong sizes of Vectors\n" + e.value1() + " != " + e.value2() );
                vectorsAreCorrect = false;
            }
			catch(IOException e){
				e.printStackTrace(System.err);
				System.err.println("Something went wrong with saving to file");
				vectorsAreCorrect = false;
			}	
        }
    }
}
 
