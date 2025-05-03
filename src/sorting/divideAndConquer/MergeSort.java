package sorting.divideAndConquer;

import java.util.Comparator;

import dataProcessing.DataPassword;
import sorting.AbstractSorting;
import util.writePath.DataWritePath;
import util.writePath.DataWritePathMergeSort;

public class MergeSort extends AbstractSorting {
	
	private DataWritePath dataWritePath;
	
	public MergeSort(Comparator<DataPassword> comparator) {
		super(comparator);
		dataWritePath = new DataWritePathMergeSort();
	}
	
	@Override
	public void sort(DataPassword[] array) {
		sort(array, 0, array.length -1);
	}


	private void sort(DataPassword[] array, int leftIndex, int rightIndex) {
		
		if (leftIndex < rightIndex) {
			
			int middleIndex = (leftIndex + rightIndex)/2;
			
			sort(array, leftIndex, middleIndex);
			sort(array, middleIndex+1, rightIndex);
			
			merge(array, leftIndex, middleIndex, rightIndex);
			
		}
	}
	
	public void merge(DataPassword[] array, int leftIndex, int middleIndex, int rightIndex) {
		
		DataPassword[] tempArray = new DataPassword[array.length];
		for (int i = leftIndex; i <= rightIndex; i++) {
			tempArray[i] = array[i];
		}
		
		int i = leftIndex;
		int j = middleIndex + 1;
		int k = leftIndex;
		
		while (i <= middleIndex && j <= rightIndex) {
			
			if (getComparator().compare(tempArray[i], tempArray[j]) <= 0) {
				array[k++] = tempArray[i++];
			}
			else {
				array[k++] = tempArray[j++];
			}
		}
		
		while (i <= middleIndex) {
			array[k++] = tempArray[i++];
		}
		
		while (j <= rightIndex) {
			array[k++] = tempArray[j++];
		}
		
		
	}

	@Override
	public DataWritePath getDataWritePath() {
		return dataWritePath;
	}
	
	
	
}
