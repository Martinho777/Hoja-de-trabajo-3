import java.util.Arrays;
import java.util.Random;

public class SortBenchmark { 

    public static void benchmarkSort(String sortName, int[] arr, SortAlgorithm algorithm) {
        int[] copy = arr.clone();
        long startTime = System.nanoTime();
        algorithm.sort(copy);
        long endTime = System.nanoTime();
        System.out.println(sortName + " tomo " + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) {
        int size = 20; // Puedes cambiar el tamaño aquí
        int[] arr = new Random().ints(size, 0, 100).toArray();
        
        System.out.println("Ordenando " + size + " numeros:");
        System.out.println("Numeros generados: " + Arrays.toString(arr));
        
        System.out.println("\nEjecutando sorts:");
        benchmarkSort("Insertion Sort", arr, new Sorts.InsertionSort());
        benchmarkSort("Merge Sort", arr, new Sorts.MergeSort());
        benchmarkSort("Selection Sort", arr, new Sorts.SelectionSort());
        benchmarkSort("Quick Sort", arr, new Sorts.QuickSort());
        benchmarkSort("Radix Sort", arr, new Sorts.RadixSort());
        
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        
        System.out.println("\nEjecutando sorts con numeros ya ordenados:");
        benchmarkSort("Insertion Sort", sortedArr, new Sorts.InsertionSort());
        benchmarkSort("Merge Sort", sortedArr, new Sorts.MergeSort());
        benchmarkSort("Selection Sort", sortedArr, new Sorts.SelectionSort());
        benchmarkSort("Quick Sort", sortedArr, new Sorts.QuickSort());
        benchmarkSort("Radix Sort", sortedArr, new Sorts.RadixSort());
    }
}
