package sorting.simpleSorting;

import java.util.Comparator;

import dataProcessing.DataPassword;
import sorting.AbstractSorting;
import util.writePath.DataWritePath;
import util.writePath.DataWritePathInsertionSort;


public class InsertionSort extends AbstractSorting {

	private DataWritePath dataWritePath;

	public InsertionSort(Comparator<DataPassword> comparator) {
		super(comparator);
		dataWritePath = new DataWritePathInsertionSort();
	}

	@Override
	public void sort(DataPassword[] array) {
		
		for (int i = 0 + 1; i <= array.length-1; i++) {
			DataPassword key = array[i];
			int j = i-1;
			
			while(j >= 0 && getComparator().compare(array[j], key) > 0) {
				array[j+1] = array[j];
				j--;
			array[j+1] = key;
			}
			
		}

	}

	@Override
	public DataWritePath getDataWritePath() {
		return dataWritePath;
	}
}
