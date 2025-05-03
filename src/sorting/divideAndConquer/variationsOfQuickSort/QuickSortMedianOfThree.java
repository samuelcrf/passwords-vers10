package sorting.divideAndConquer.variationsOfQuickSort;

import java.util.Comparator;

import dataProcessing.DataPassword;
import sorting.AbstractSorting;
import util.Util;
import util.writePath.DataWritePath;
import util.writePath.DataWritePathQuickSortMedianOfThree;

public class QuickSortMedianOfThree extends AbstractSorting {
	
	private DataWritePath dataWritePath;
 
	public QuickSortMedianOfThree(Comparator<DataPassword> comparator) {
		super(comparator);
		dataWritePath = new DataWritePathQuickSortMedianOfThree();
	}
	
	@Override
	public void sort(DataPassword[] array) {
		sort(array, 0, array.length-1);
	}

	public void sort(DataPassword[] array, int leftIndex, int rightIndex) {
		
		
		if (leftIndex < rightIndex) {
			
			int pivotIndex = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivotIndex-1);
			sort(array, pivotIndex+1, rightIndex);
			
		}
	}
	
	private int partition(DataPassword[] array, int leftIndex, int rightIndex) {
		
		
		int pivotIndex = medianOfThree(array, leftIndex, rightIndex);
		DataPassword pivot = array[pivotIndex];
		
		Util.swap(array, rightIndex - 1, pivotIndex);
		
		int i = rightIndex - 1;
		
		for (int j = rightIndex - 2; j >= leftIndex + 1; j--) {
			if (getComparator().compare(array[j], pivot) >= 0) {
				i--;
				Util.swap(array, i, j);
			}
		}
		
		Util.swap(array, rightIndex - 1, i);
		
		return i;
		
	}
	
	public int medianOfThree(DataPassword[] array, int leftIndex, int rightIndex) {
	      int middle = (leftIndex + rightIndex) / 2;
	      
	      if (getComparator().compare(array[rightIndex], array[leftIndex]) < 0)
	         Util.swap(array, rightIndex, leftIndex);
	      
	      if (getComparator().compare(array[middle], array[leftIndex]) < 0)
	         Util.swap(array, middle, leftIndex);
	      
	      if (getComparator().compare(array[rightIndex], array[middle]) < 0)
	         Util.swap(array, rightIndex, middle);
	      
	      return middle;
	 }

	@Override
	public DataWritePath getDataWritePath() {
		return dataWritePath;
	}
	
}
