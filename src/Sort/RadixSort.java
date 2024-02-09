package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class RadixSort implements SortingAlgorithm {
    public void sort(List<Integer> arr) {
        int max = Collections.max(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private void countingSort(List<Integer> arr, int exp) {
        int[] count = new int[10];
        List<Integer> output = new ArrayList<>(Collections.nCopies(arr.size(), 0));
        for (int num : arr) {
            count[(num / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.size() - 1; i >= 0; i--) {
            output.set(count[(arr.get(i) / exp) % 10] - 1, arr.get(i));
            count[(arr.get(i) / exp) % 10]--;
        }
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, output.get(i));
        }
    }

    public String getName() {
        return "Radix Sort";
    }
}

