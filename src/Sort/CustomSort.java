package Sort;
import java.util.Collections;
import java.util.List;

class CustomSort implements SortingAlgorithm {
    public void sort(List<Integer> arr) {
        // Aquí puedes implementar tu propio algoritmo de ordenamiento, por ejemplo, Bubble Sort
        int n = arr.size();
        for (int i = 0; i < n-1; i++) {
        	for (int j = 0; j < n-i-1; j++) {
                if (arr.get(j) > arr.get(j+1)) {
                    Collections.swap(arr, j, j+1);
                }
            }
        }
    }

    public String getName() {
        return "Bubble Sort";
    }
}
