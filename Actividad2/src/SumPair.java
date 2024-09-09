import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SumPair {
    public static int sumPair0(int[] V) {
        int result = 0;
        for (int i = 0; i < V.length; i++) {
            for (int j = i + 1; j < V.length; j++) {
                if ((V[i] + V[j]) % 2 == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 10000; // tamaño del array
        int[] V = new int[n];
        Random rand = new Random();
        
        for (int i = 0; i < n; i++) {
            V[i] = rand.nextInt(100); // Generar números aleatorios entre 0 y 99
        }

        try (FileWriter writer = new FileWriter("resultados.txt")) {
            long startTime = System.nanoTime();
            int result = sumPair0(V);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime); // en nanosegundos
            
            writer.write("Tamaño del array: " + n + "\n");
            writer.write("Número de pares: " + result + "\n");
            writer.write("Tiempo de ejecución: " + duration + " nanosegundos\n");
            
            System.out.println("Tamaño del array: " + n);
            System.out.println("Número de pares: " + result);
            System.out.println("Tiempo de ejecución: " + duration + " nanosegundos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}