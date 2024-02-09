package Sort;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SortingExperiment {
	 public static void main(String[] args) {
	        int[] intervals = {10, 100, 500, 1000, 1500, 2000, 2500, 3000};
	        
	        List<SortingAlgorithm> algorithms = new ArrayList<>();
	        algorithms.add(new GnomeSort());
	        algorithms.add(new MergeSort());
	        algorithms.add(new QuickSort());
	        algorithms.add(new RadixSort());
	        algorithms.add(new CustomSort());
	        
	        List<List<Double>> results = new ArrayList<>();
	        
	        // Generar números aleatorios y guardar en un archivo
	        generateNumbersFile("random_numbers.txt", 3000);
	        
	        // Leer los números del archivo
	        List<Integer> numbers = readNumbers("random_numbers.txt");
	        
	        for (SortingAlgorithm algorithm : algorithms) {
	            List<Double> timings = new ArrayList<>();
	            for (int interval : intervals) {
	                List<Integer> subset = numbers.subList(0, interval);
	                long startTime = System.nanoTime();
	                algorithm.sort(subset);
	                long endTime = System.nanoTime();
	                double elapsedTime = (endTime - startTime) / 1e6; // convert to milliseconds
	                timings.add(elapsedTime);
	            }
	            results.add(timings);
	        }
	        
	        // Imprimir los resultados
	        for (int i = 0; i < algorithms.size(); i++) {
	            System.out.println(algorithms.get(i).getName() + ": " + results.get(i));
	        }
	    }
	    
	    // Función para generar números aleatorios y guardarlos en un archivo
	    public static void generateNumbersFile(String filename, int count) {
	        Random random = new Random();
	        try (FileWriter writer = new FileWriter(filename)) {
	            for (int i = 0; i < count; i++) {
	                writer.write(String.valueOf(random.nextInt(10000)) + "\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    // Función para leer números enteros de un archivo
	    public static List<Integer> readNumbers(String filename) {
	        List<Integer> numbers = new ArrayList<>();
	        try (Scanner scanner = new Scanner(new File(filename))) {
	            while (scanner.hasNextInt()) {
	                numbers.add(scanner.nextInt());
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return numbers;
	    }
	}

	// Interfaz para los algoritmos de ordenamiento
	interface SortingAlgorithm {
	    void sort(List<Integer> arr);
	    String getName();
	}

