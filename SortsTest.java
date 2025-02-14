import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SortsTest {

    @Test
    void testInsertionSort() {
        int[] input = {5, 3, 8, 1, 2};
        int[] expected = {1, 2, 3, 5, 8};
        SortAlgorithm sorter = new Sorts.InsertionSort();
        assertArrayEquals(expected, sorter.sort(input));
    }

    @Test
    void testMergeSort() {
        int[] input = {5, 3, 8, 1, 2};
        int[] expected = {1, 2, 3, 5, 8};
        SortAlgorithm sorter = new Sorts.MergeSort();
        assertArrayEquals(expected, sorter.sort(input));
    }

    @Test
    void testSelectionSort() {
        int[] input = {5, 3, 8, 1, 2};
        int[] expected = {1, 2, 3, 5, 8};
        SortAlgorithm sorter = new Sorts.SelectionSort();
        assertArrayEquals(expected, sorter.sort(input));
    }

    @Test
    void testQuickSort() {
        int[] input = {5, 3, 8, 1, 2};
        int[] expected = {1, 2, 3, 5, 8};
        SortAlgorithm sorter = new Sorts.QuickSort();
        assertArrayEquals(expected, sorter.sort(input));
    }

    @Test
    void testRadixSort() {
        int[] input = {5, 3, 8, 1, 2};
        int[] expected = {1, 2, 3, 5, 8};
        SortAlgorithm sorter = new Sorts.RadixSort();
        assertArrayEquals(expected, sorter.sort(input));
    }
}
