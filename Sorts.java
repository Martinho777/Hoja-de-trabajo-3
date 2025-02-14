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
public static class SelectionSort implements SortAlgorithm {
        @Override
        public int[] sort(int[] arr) {
            int[] sortedArr = arr.clone();
            int n = sortedArr.length;
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (sortedArr[j] < sortedArr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = sortedArr[minIndex];
                sortedArr[minIndex] = sortedArr[i];
                sortedArr[i] = temp;
            }
            return sortedArr;
        }
    }

    public static class QuickSort implements SortAlgorithm {
        @Override
        public int[] sort(int[] arr) {
            int[] sortedArr = arr.clone();
            quickSortHelper(sortedArr, 0, sortedArr.length - 1);
            return sortedArr;
        }

        private void quickSortHelper(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                quickSortHelper(arr, low, pi - 1);
                quickSortHelper(arr, pi + 1, high);
            }
        }

        private int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j] < pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            return i + 1;
        }
    }

    public static class RadixSort implements SortAlgorithm {
        @Override
        public int[] sort(int[] arr) {
            int[] sortedArr = arr.clone();
            int max = Arrays.stream(sortedArr).max().orElse(0);
            for (int exp = 1; max / exp > 0; exp *= 10) {
                int[] output = new int[sortedArr.length];
                int[] count = new int[10];
                for (int num : sortedArr) {
                    count[(num / exp) % 10]++;
                }
                for (int i = 1; i < 10; i++) {
                    count[i] += count[i - 1];
                }
                for (int i = sortedArr.length - 1; i >= 0; i--) {
                    output[count[(sortedArr[i] / exp) % 10] - 1] = sortedArr[i];
                    count[(sortedArr[i] / exp) % 10]--;
                }
                sortedArr = output.clone();
            }
            return sortedArr;
        }
    }
}
