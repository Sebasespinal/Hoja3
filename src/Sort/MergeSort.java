package Sort;

class MergeSort implements SortingAlgorithm {
    public void sort(List<Integer> arr) {
        mergeSort(arr, 0, arr.size() - 1);
    }

    private void mergeSort(List<Integer> arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(List<Integer> arr, int left, int mid, int right) {
        List<Integer> temp = new ArrayList<>(right - left + 1);
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr.get(i) <= arr.get(j)) {
                temp.add(arr.get(i++));
            } else {
                temp.add(arr.get(j++));
            }
        }
        while (i <= mid) {
            temp.add(arr.get(i++));
        }
        while (j <= right) {
            temp.add(arr.get(j++));
        }
        for (int k = left; k <= right; k++) {
            arr.set(k, temp.get(k - left));
        }
    }

    public String getName() {
        return "Merge Sort";
    }
}
