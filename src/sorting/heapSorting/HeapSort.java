package sorting.heapSorting;

import java.util.Comparator;

import dataProcessing.DataPassword;
import sorting.AbstractSorting;
import util.Util;
import util.writePath.DataWritePath;
import util.writePath.DataWritePathHeapSort;

public class HeapSort extends AbstractSorting {
	
	private DataWritePath dataWritePath;

	private int index = -1;
	
	public HeapSort(Comparator<DataPassword> comparator) {
		super(comparator);
		dataWritePath = new DataWritePathHeapSort();
	}


	private int parent(int i) {
		return (i - 1) / 2;
	}
	
	private int left(int i) {
		return (i * 2 + 1);
	}

	private int right(int i) {
		return (i * 2 + 1) + 1;
	}
	

	private void heapify(int position, DataPassword[] array) {
		if (isValidPosition(position)) {
			
			int heapifyPos = position;
			int right = right(position);
			int left = left(position);
			if (left <= index && (getComparator().compare(array[left], array[heapifyPos])) > 0) {
				heapifyPos = left;
			}
	
			if (right <= index && (getComparator().compare(array[right], array[heapifyPos])) > 0) {
				heapifyPos = right;
			}
	
			if (heapifyPos != position) {
				Util.swap(array, position, heapifyPos);
				heapify(heapifyPos, array);
			}
		}
	}

	private boolean isValidPosition(int position) {
		return position >= 0 && position <= index;
	}

	
	public void buildHeap(DataPassword[] array) {
		
		index = array.length - 1;
		for (int i = parent(index); i >= 0; i--) {
			heapify(i, array);
		}
		
	}

	@Override
	public void sort(DataPassword[] array) {
		
		if (array != null) {
			
			buildHeap(array);
			for (int i = index; i > 0; i--) {
				Util.swap(array, 0, i);
				index--;
				heapify(0, array);
			}
			index--;
			
		}
	}

	
	@Override
	public DataWritePath getDataWritePath() {
		return dataWritePath;
	}	
	

}
