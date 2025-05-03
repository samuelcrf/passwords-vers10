package sorting.divideAndConquer;

import java.util.Comparator;

import dataProcessing.DataPassword;
import sorting.AbstractSorting;
import util.Util;
import util.writePath.DataWritePath;
import util.writePath.DataWritePathQuickSort;


public class QuickSort extends AbstractSorting {

	private DataWritePath dataWritePath;
	
	public QuickSort(Comparator<DataPassword> comparator) {
		super(comparator);
		dataWritePath = new DataWritePathQuickSort();
	}

	public void sort(DataPassword[] array) {
		sort(array, 0, array.length - 1);
	}

	public void sort(DataPassword[] array, int leftIndex, int rightIndex) {
		
		if (leftIndex < rightIndex) {
			
			int pivotIndex = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivotIndex-1);
			sort(array, pivotIndex+1, rightIndex);
			
		}
		
	}
	
	private int partition(DataPassword[] array, int leftIndex, int rightIndex) {
		
		int range = rightIndex - leftIndex + 1;
        int randPivotIndex = (int) (Math.random() * range) + leftIndex;
        
        Util.swap(array, leftIndex, randPivotIndex);
		
		DataPassword pivot = array[leftIndex];
		
		int i = leftIndex;
		
		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (getComparator().compare(array[j], pivot) <= 0) {
				i++;
				Util.swap(array, i, j);
			}
		}
		
		Util.swap(array, leftIndex, i);
		
		return i;
		
	}

	@Override
	public DataWritePath getDataWritePath() {
		return dataWritePath;
	}
	
}
