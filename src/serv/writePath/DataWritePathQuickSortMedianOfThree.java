package util.writePath;

import util.FormatPath;

public class DataWritePathQuickSortMedianOfThree implements DataWritePath {
	
	private String pathDateBestCase = "data\\processedData\\sortingResults\\quickSortMedianOfThree\\passwords_date_quickSortMedianOfThree_melhorCaso.csv";
	private String pathDateAverageCase = "data\\processedData\\sortingResults\\quickSortMedianOfThree\\passwords_date_quickSortMedianOfThree_medioCaso.csv";
	private String pathDateWorstCase = "data\\processedData\\sortingResults\\quickSortMedianOfThree\\passwords_date_quickSortMedianOfThree_piorCaso.csv";
	
	private String pathMonthBestCase = "data\\processedData\\sortingResults\\quickSortMedianOfThree\\passwords_month_date_quickSortMedianOfThree_melhorCaso.csv";
	private String pathMonthAverageCase = "data\\processedData\\sortingResults\\quickSortMedianOfThree\\passwords_month_date_quickSortMedianOfThree_medioCaso.csv";
	private String pathMonthWorstCase = "data\\processedData\\sortingResults\\quickSortMedianOfThree\\passwords_month_date_quickSortMedianOfThree_piorCaso.csv";
	
	
	public DataWritePathQuickSortMedianOfThree() {
	}

	@Override
	public String getPathDateBestCase() {
		return FormatPath.getPath(pathDateBestCase);
	}
	
	@Override
	public String getPathDateAverageCase() {
		return FormatPath.getPath(pathDateAverageCase);
	}
	
	@Override
	public String getPathDateWorstCase() {
		return FormatPath.getPath(pathDateWorstCase);
	}
	
	@Override
	public String getPathMonthBestCase() {
		return FormatPath.getPath(pathMonthBestCase);
	}
	
	@Override
	public String getPathMonthAverageCase() {
		return FormatPath.getPath(pathMonthAverageCase);
	}
	
	@Override
	public String getPathMonthWorstCase() {
		return FormatPath.getPath(pathMonthWorstCase);
	}
	
	@Override
	public String getPathLengthBestCase() {
		return null;
	}
	
	@Override
	public String getPathLengthAverageCase() {
		return null;
	}
	
	
	public String getPathLengthWorstCase() {
		return null;
	}
	
	
	
	

}
