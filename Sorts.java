import java.util.Arrays;

public class Sorts {
    
    public static class InsertionSort implements SortAlgorithm {
        @Override
        public int[] sort(int[] arr) {
            int[] sortedArr = arr.clone();
            for (int i = 1; i < sortedArr.length; i++) {
                int key = sortedArr[i];
                int j = i - 1;
                while (j >= 0 && sortedArr[j] > key) {
                    sortedArr[j + 1] = sortedArr[j];
                    j--;
                }
                sortedArr[j + 1] = key;
            }
            return sortedArr;
        }
    }

    public static class MergeSort implements SortAlgorithm {
        @Override
        public int[] sort(int[] arr) {
            if (arr.length <= 1) return arr;
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            left = sort(left);
            right = sort(right);
            int[] merged = new int[arr.length];
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                merged[k++] = (left[i] < right[j]) ? left[i++] : right[j++];
            }
            while (i < left.length) merged[k++] = left[i++];
            while (j < right.length) merged[k++] = right[j++];
            return merged;
        }
    }
//aaa
}
