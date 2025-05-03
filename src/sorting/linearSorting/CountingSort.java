package sorting.linearSorting;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import dataProcessing.DataPassword;
import enums.OrderBy;
import sorting.Sorting;
import util.writePath.DataWritePath;
import util.writePath.DataWritePathCountingSort;


public class CountingSort implements Sorting {

	private DataWritePath dataWritePath;
	
	private static final Calendar cal1 = Calendar.getInstance();
	private static final Calendar cal2 = Calendar.getInstance();
	
	private DataPassword[] result;
	private OrderBy orderBy;
	
	private int largestLength;
	
	public CountingSort(OrderBy orderBy) {
		this.orderBy = orderBy;
		dataWritePath = new DataWritePathCountingSort();
	}

	@Override
    public void sort(DataPassword[] array) {
 
        int[] auxiliar = new int[getArraySize(array)  + 1];

        for (int i = 0; i <= array.length-1; i++) {
            auxiliar[getCountValue(array[i])]++;
        }
        

        for (int i = 1; i < auxiliar.length; i++) {
            auxiliar[i] += auxiliar[i-1];
        }


        result = new DataPassword[array.length]; 
        
        for (int i = array.length-1; i >= 0; i--) {
        	
        	result[(auxiliar[getCountValue(array[i])] - 1)] = array[i];
            auxiliar[getCountValue(array[i])]--;
           
        }
    }
	
	public DataPassword[] getResult() {
		return result;
	}
	
	private int getDateBetween(Date date) {
		int result = 0;
		
		String year1 = String.valueOf(cal1.get(Calendar.YEAR));

		int monthInt1 = cal1.get(Calendar.MONTH) + 1;
		String month1 = (monthInt1 > 9) ? String.valueOf(monthInt1) : "0" + String.valueOf(monthInt1);

		int dayInt1 = cal1.get(Calendar.DAY_OF_MONTH);
		String day1 = (dayInt1 > 9) ? String.valueOf(dayInt1) : "0" + String.valueOf(dayInt1);
		
		cal2.setTime(date);
		String year2 = String.valueOf(cal2.get(Calendar.YEAR));
		
		int monthInt2 = cal2.get(Calendar.MONTH) + 1;
		String month2 = (monthInt2 > 9) ? String.valueOf(monthInt2) : "0" + String.valueOf(monthInt2);
		
		int dayInt2 = cal2.get(Calendar.DAY_OF_MONTH);
		String day2 = (dayInt2 > 9) ? String.valueOf(dayInt2) : "0" + String.valueOf(dayInt2);
		
		if (orderBy.equals(OrderBy.DATE)) {
			result = (int) ChronoUnit.DAYS.between(LocalDate.parse(year1 + "-" + month1 + "-" + day1),
												   LocalDate.parse(year2 + "-" + month2 + "-" + day2));
		}
		else if (orderBy.equals(OrderBy.MONTH)) {
			result = (int) ChronoUnit.MONTHS.between(LocalDate.parse(year1 + "-" + month1 + "-" + day1),
                    								 LocalDate.parse(year2 + "-" + month2 + "-" + day2));
		}
		
		
		return result;
	}
	
	private int getArraySize(DataPassword[] array) {
		
		int arraySize = 0;
		if (orderBy.equals(OrderBy.DATE) || orderBy.equals(OrderBy.MONTH)) {
			
			Date largestDate = array[0].getDate();
			Date smallestDate = array[0].getDate();
	        for (int i = 0; i <= array.length-1; i++) {
	            if (array[i].getDate().compareTo(largestDate) > 0) {
	            	largestDate = array[i].getDate();
	            }
	            
	            if (array[i].getDate().compareTo(smallestDate) < 0) {
	            	smallestDate = array[i].getDate();
	            }
	        }
	        
			cal1.setTime(smallestDate);

			arraySize = getDateBetween(largestDate); 
		}
		else if (orderBy.equals(OrderBy.LENGTH)) {
			
			int largestLength = array[0].getLength();
			for (int i = 0; i <= array.length-1; i++) {
				if (((Integer)array[i].getLength()).compareTo(largestLength) > 0) {
					largestLength = array[i].getLength();
				}
			}
			this.largestLength = largestLength;
			
			arraySize = largestLength;
		}
		
		return arraySize;	
	}
	
	private int getCountValue(DataPassword dataPassword) {
		
		int result = 0;
		if (orderBy.equals(OrderBy.DATE) || orderBy.equals(OrderBy.MONTH)) {
			result = getDateBetween(dataPassword.getDate());
		}
		else if (orderBy.equals(OrderBy.LENGTH)) {
			result = Math.abs(dataPassword.getLength() - largestLength);
		}
		
		return result;	
	}

	@Override
	public DataWritePath getDataWritePath() {
		return dataWritePath;
	}

	public void setOrderBy(OrderBy orderBy) {
		this.orderBy = orderBy;
	}

}
