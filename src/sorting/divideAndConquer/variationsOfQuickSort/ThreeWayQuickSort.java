package sorting.divideAndConquer.variationsOfQuickSort;

import java.util.Comparator;

import dataProcessing.DataPassword;
import sorting.AbstractSorting;
import util.Util;
import util.writePath.DataWritePath;
import util.writePath.DataWritePathThreeWayQuickSort;

public class ThreeWayQuickSort extends AbstractSorting {
	
	private DataWritePath dataWritePath;

	public ThreeWayQuickSort(Comparator<DataPassword> comparator) {
		super(comparator);
		dataWritePath = new DataWritePathThreeWayQuickSort();
	}
	
	public void sort(DataPassword[] array) {
		sort(array, 0, array.length - 1);
	}

	public void sort(DataPassword[] array, int leftIndex, int rightIndex) {
		
		
		if (leftIndex >= rightIndex)
	        return;
	    
	    int[] p = partition(array, leftIndex, rightIndex);
	    
	    sort(array, leftIndex, p[0] - 1);
  	  	sort(array, p[1] + 1, rightIndex);
	}
	
	public int[] partition(DataPassword[] array, int leftIndex, int rightIndex) {
		
		int range = rightIndex - leftIndex + 1;
        int randPivotIndex = (int) (Math.random() * range) + leftIndex;
        
        Util.swap(array, leftIndex, randPivotIndex);
		
		int i = leftIndex;
		DataPassword pivot = array[leftIndex];
		
		while (i <= rightIndex) {
			
			if (getComparator().compare(array[i], pivot) < 0) {					
				Util.swap(array, leftIndex++, i++);
			}	
			else if (getComparator().compare(array[i], pivot) > 0) {		
				Util.swap(array, i, rightIndex--);
			}
			else {
				i++;
			}
			
		}
		return new int[] {leftIndex, rightIndex} ;
	}

	@Override
	public DataWritePath getDataWritePath() {
		return dataWritePath;
	}

}
