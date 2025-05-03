package util.writePath;

import util.FormatPath;

public class DataWritePathQuickSort implements DataWritePath {
	
	private String pathDateBestCase = "data\\processedData\\sortingResults\\quickSort\\passwords_date_quickSort_melhorCaso.csv";
	private String pathDateAverageCase = "data\\processedData\\sortingResults\\quickSort\\passwords_date_quickSort_medioCaso.csv";
	private String pathDateWorstCase = "data\\processedData\\sortingResults\\quickSort\\passwords_date_quickSort_piorCaso.csv";
	

	public DataWritePathQuickSort() {
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
		return null;
	}
	
	@Override
	public String getPathMonthAverageCase() {
		return null;
	}
	
	@Override
	public String getPathMonthWorstCase() {
		return null;
	}
	
	@Override
	public String getPathLengthBestCase() {
		return null;
	}
	
	@Override
	public String getPathLengthAverageCase() {
		return null;
	}
	
	@Override
	public String getPathLengthWorstCase() {
		return null;
	}
	
	
	
	

}
