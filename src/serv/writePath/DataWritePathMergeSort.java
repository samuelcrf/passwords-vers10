package util.writePath;

import util.FormatPath;

public class DataWritePathMergeSort implements DataWritePath {
	
	private String pathDateBestCase = "data\\processedData\\sortingResults\\mergeSort\\passwords_date_mergeSort_melhorCaso.csv";
	private String pathDateAverageCase = "data\\processedData\\sortingResults\\mergeSort\\passwords_date_mergeSort_medioCaso.csv";
	private String pathDateWorstCase = "data\\processedData\\sortingResults\\mergeSort\\passwords_date_mergeSort_piorCaso.csv";
	
	private String pathMonthBestCase = "data\\processedData\\sortingResults\\mergeSort\\passwords_month_date_mergeSort_melhorCaso.csv";
	private String pathMonthAverageCase = "data\\processedData\\sortingResults\\mergeSort\\passwords_month_date_mergeSort_medioCaso.csv";
	private String pathMonthWorstCase = "data\\processedData\\sortingResults\\mergeSort\\passwords_month_date_mergeSort_piorCaso.csv";
	
	private String pathLengthBestCase = "data\\processedData\\sortingResults\\mergeSort\\passwords_length_mergeSort_melhorCaso.csv";
	private String pathLengthAverageCase = "data\\processedData\\sortingResults\\mergeSort\\passwords_length_mergeSort_medioCaso.csv";
	private String pathLengthWorstCase = "data\\processedData\\sortingResults\\mergeSort\\passwords_length_mergeSort_piorCaso.csv";
	
	
	public DataWritePathMergeSort() {
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
		return FormatPath.getPath(pathLengthBestCase);
	}
	
	@Override
	public String getPathLengthAverageCase() {
		return FormatPath.getPath(pathLengthAverageCase);
	}
	
	
	public String getPathLengthWorstCase() {
		return FormatPath.getPath(pathLengthWorstCase);
	}
	
	
	
	

}
