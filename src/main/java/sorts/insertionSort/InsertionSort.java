package sorts.insertionSort;

import sorts.AbstractSort;
import util.Util;

public class InsertionSort<T extends Comparable<T>> extends AbstractSort<T> {

    @Override
    public void sort(T[] array, int left, int right) {
        for (int i = 1; i < array.length; i++) {
			int indexSorted = i - 1;
			int indexValue = i;
			boolean isGreater = false;

			while (indexSorted >= 0 && !isGreater) {
				if (array[indexValue].compareTo(array[indexSorted]) < 0) {
					Util.swap(array, indexValue, indexSorted);
					indexValue--;
				} else {
					isGreater = true;
				}

				indexSorted--;
			}
		}
    }
    
}
