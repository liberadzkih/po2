
import java.util.Scanner;
import java.util.Vector;

public class Wektor {
    
    Vector<Double> vector;

    public Wektor() {
        vector = new Vector<>();
    }
    
    public Wektor(String s){
        Scanner in = new Scanner(s);
        vector = new Vector<>();
        while(in.hasNext()){
            if(in.hasNextDouble())
                vector.add(in.nextDouble());
            else
                in.next();
        }
        in.close();
    }

    public Vector<Double> getVector() {
        return vector;
    }
    
    public Vector<Double> addVector(Vector<Double> vec, Vector<Double> vec2) throws WektoryRoznejDlugosciException{
        
        if(vec.size() != vec2.size()){
            System.err.print("\nThrowing WektoryRoznejDlugosciException from method addVector\n");
            throw new WektoryRoznejDlugosciException("Originatd in addVector", vec.size(), vec2.size() );
        }
        
        for(int i=0; i<vec.size(); i++){
            vector.add(vec.elementAt(i) + vec2.elementAt(i));
        }
        return vector;
    }
    
    
}
