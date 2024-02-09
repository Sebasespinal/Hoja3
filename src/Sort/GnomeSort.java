package Sort;

import java.util.Collections;
import java.util.List;

class GnomeSort implements SortingAlgorithm {
    public void sort(List<Integer> arr) {
        int index = 0;
        while (index < arr.size()) {
            if (index == 0) {
                index++;
            }
            if (arr.get(index) >= arr.get(index - 1)) {
                index++;
            } else {
                Collections.swap(arr, index, index - 1);
                index--;
            }
        }
    }

    public String getName() {
        return "Gnome Sort";
    }
}

