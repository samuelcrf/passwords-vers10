package sorting.simpleSorting;

import java.util.Comparator;

import dataProcessing.DataPassword;
import sorting.AbstractSorting;
import util.Util;
import util.writePath.DataWritePath;
import util.writePath.DataWritePathSelectionSort;


public class SelectionSort extends AbstractSorting {
	
	private DataWritePath dataWritePath;
	
	public SelectionSort(Comparator<DataPassword> comparator) {
		super(comparator);
		dataWritePath = new DataWritePathSelectionSort();
	}

	@Override
	public void sort(DataPassword[] array) {
		
		for (int i = 0; i < array.length -1; i++) {
			
			int min = i;
			for (int j = i+1; j <= array.length -1; j++) {
				if (getComparator().compare(array[j], array[min]) < 0) {
					min = j;
				}
			}
			
			Util.swap(array, i, min);
		}
	}

	@Override
	public DataWritePath getDataWritePath() {
		return dataWritePath;
	}
	
}
