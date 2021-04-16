
package work.Sorts;

import static work.Sorts.SortUtils.less;
import static work.Sorts.SortUtils.print;
import static work.Sorts.SortUtils.swap;

/**
 * @author Jorge Alberto Gomez Gomez
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 */

public class SelectionSort implements SortAlgorithm {

    /**
     * This methods implements the Generic Selection Sort
     * @param arr The array to be sorted
     * Sorts the array in increasing order
     */

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Initial index of min
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }

            // Swapping if index of min is changed
            if (min != i) {
                swap(arr, i, min);
            }
        }
        return arr;
    }

    // Driver Program
    public static void main(String[] args) {
        Integer[] arr = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        SelectionSort selectionSort = new SelectionSort();
        Integer[] sorted = selectionSort.sort(arr);
        // OutPut => 1  4  6  9  12  23  54  78  231
        print(sorted);
        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        String[] sortedString = selectionSort.sort(strings);
        // OutPut => a  b  c  d  e
        print(sortedString);
    }
}
