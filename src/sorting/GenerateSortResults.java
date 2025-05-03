package sorting;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import dataProcessing.DataPassword;
import enums.CaseSort;
import enums.OrderBy;
import sorting.linearSorting.CountingSort;
import util.FormatPath;
import util.UtilGenerateArray;
import util.UtilWriteLines;

public class GenerateSortResults {
		
	public static void generateResults(Sorting sortAlgorithm, OrderBy orderBy, CaseSort caseSort) 
			throws NumberFormatException, ParseException, FileNotFoundException, IOException {
		
		
		String sourceFilePathAverageCase = FormatPath.getPath("data\\processedData\\passwords_formated_data.csv");
		
		
		String sourceFilePathBestCaseDate = FormatPath.getPath("data\\processedData\\sortingInputDataForDate\\best_case_date.csv");
		
		String sourceFilePathWorstCaseDate = FormatPath.getPath("data\\processedData\\sortingInputDataForDate\\worst_case_date.csv");
		
		
		String sourceFilePathBestCaseMonth = FormatPath.getPath("data\\processedData\\sortingInputDataForYearMonth\\best_case_year_month.csv");
		
		String sourceFilePathWorstCaseMonth = FormatPath.getPath("data\\processedData\\sortingInputDataForYearMonth\\worst_case_year_month.csv");
		
		
		String sourceFilePathBestCaseLength = FormatPath.getPath("data\\processedData\\sortingInputDataForLength\\best_case_length.csv");
		
		String sourceFilePathWorstCaseLength = FormatPath.getPath("data\\processedData\\sortingInputDataForLength\\worst_case_length.csv"); 
		
		
		System.out.println("\nO processo pode demorar um tempo. Aguarde, por favor!");
		
		if (orderBy.equals(OrderBy.DATE)) {

			if (caseSort.equals(CaseSort.BEST)) {
				generateSortingAndWriteFile(sortAlgorithm, sourceFilePathBestCaseDate,
						sortAlgorithm.getDataWritePath().getPathDateBestCase());
			
			} else if (caseSort.equals(CaseSort.AVERAGE)) {
				generateSortingAndWriteFile(sortAlgorithm, sourceFilePathAverageCase,
						sortAlgorithm.getDataWritePath().getPathDateAverageCase());

			} else if (caseSort.equals(CaseSort.WORST)) {
				generateSortingAndWriteFile(sortAlgorithm, sourceFilePathWorstCaseDate,
						sortAlgorithm.getDataWritePath().getPathDateWorstCase());
			}
		}
		else if (orderBy.equals(OrderBy.MONTH)) {

			if (caseSort.equals(CaseSort.BEST)) {
				generateSortingAndWriteFile(sortAlgorithm, sourceFilePathBestCaseMonth,
						sortAlgorithm.getDataWritePath().getPathMonthBestCase());
			
			} else if (caseSort.equals(CaseSort.AVERAGE)) {
				generateSortingAndWriteFile(sortAlgorithm, sourceFilePathAverageCase,
						sortAlgorithm.getDataWritePath().getPathMonthAverageCase());

			} else if (caseSort.equals(CaseSort.WORST)) {
				generateSortingAndWriteFile(sortAlgorithm, sourceFilePathWorstCaseMonth,
						sortAlgorithm.getDataWritePath().getPathMonthWorstCase());
			}
		}
		else if (orderBy.equals(OrderBy.LENGTH)) {

			if (caseSort.equals(CaseSort.BEST)) {
				generateSortingAndWriteFile(sortAlgorithm, sourceFilePathBestCaseLength,
						sortAlgorithm.getDataWritePath().getPathLengthBestCase());
			
			} else if (caseSort.equals(CaseSort.AVERAGE)) {
				generateSortingAndWriteFile(sortAlgorithm, sourceFilePathAverageCase,
						sortAlgorithm.getDataWritePath().getPathLengthAverageCase());

			} else if (caseSort.equals(CaseSort.WORST)) {
				generateSortingAndWriteFile(sortAlgorithm, sourceFilePathWorstCaseLength,
						sortAlgorithm.getDataWritePath().getPathLengthWorstCase());
			}
		}
		
	}
		
		
	private static void generateSortingAndWriteFile(Sorting sortAlgorithm, String sourceFilePath, String targetFilePath)
			throws FileNotFoundException, IOException, NumberFormatException, ParseException {

		DataPassword[] arrayData = UtilGenerateArray.generateArrayData(sourceFilePath);

		Sorting sorting = sortAlgorithm;

		
		long initTime = new Date().getTime();

		sorting.sort(arrayData);

		long endTime = new Date().getTime();
		
		
		if (sortAlgorithm instanceof CountingSort) {
			arrayData = ((CountingSort) sortAlgorithm).getResult();
		}

		System.out.println("\nTempo de execucao: " + (endTime - initTime) + " milisegundos");
		
		
		System.out.println("\nGerando o arquivo resultante...");

		UtilWriteLines.writeLines(targetFilePath, arrayData);
		
		System.out.println("\nO arquivo foi gerado no caminho: " + targetFilePath);

	}
			
		
	

}
