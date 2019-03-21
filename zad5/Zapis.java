
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Vector;

public class Zapis {
    public static void saveToFile(Vector<Double> vector) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("vector3.txt");
        writer.println(vector);
        writer.close();
    }
}
