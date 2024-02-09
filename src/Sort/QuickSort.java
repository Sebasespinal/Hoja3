package Sort;

import java.util.Collections;
import java.util.List;

class QuickSort implements SortingAlgorithm {
    public void sort(List<Integer> arr) {
        quickSort(arr, 0, arr.size() - 1);
    }

    private void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j) < pivot) {
                i++;
                Collections.swap(arr, i, j);
            }
        }
        Collections.swap(arr, i + 1, high);
        return i + 1;
    }

    public String getName() {
        return "Quick Sort";
    }
}
