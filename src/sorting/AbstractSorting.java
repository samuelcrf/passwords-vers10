package sorting;

import java.util.Comparator;

import dataProcessing.DataPassword;

public abstract class AbstractSorting implements Sorting {

	private Comparator<DataPassword> comparator;
	
	
	public AbstractSorting(Comparator<DataPassword> comparator) {
		this.comparator = comparator;
	}

	protected Comparator<DataPassword> getComparator() {
		return comparator;
	}
	
	protected void setComparator(Comparator<DataPassword> comparator) {
		this.comparator = comparator;
	}

}
