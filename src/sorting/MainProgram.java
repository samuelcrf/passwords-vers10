package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import dataProcessing.DataPassword;
import enums.CaseSort;
import enums.OrderBy;
import sorting.divideAndConquer.MergeSort;
import sorting.divideAndConquer.QuickSort;
import sorting.heapSorting.HeapSort;
import sorting.linearSorting.CountingSort;
import sorting.simpleSorting.InsertionSort;
import sorting.simpleSorting.SelectionSort;
import util.FormatPath;
import sorting.divideAndConquer.variationsOfQuickSort.QuickSortMedianOfThree;
import sorting.divideAndConquer.variationsOfQuickSort.ThreeWayQuickSort;

public class MainProgram {
	
	private static Comparator<DataPassword> comparatorDate = (d1,d2) -> d1.getDate().compareTo(d2.getDate());
	private static Comparator<DataPassword> comparatorYearMonth = (d1,d2) -> d1.getYearMonth().compareTo(d2.getYearMonth());
	private static Comparator<DataPassword> comparatorLength = (d1,d2) -> ((Integer)d2.getLength()).compareTo(d1.getLength());

	public static void main(String[] args) 
			throws NumberFormatException, ParseException, FileNotFoundException, IOException, InterruptedException {
		
		String sourceFilePath = FormatPath.getPath("data\\processedData\\passwords_formated_data.csv");
		File path = new File(sourceFilePath);
		
		Scanner sc = new Scanner(System.in);
		
		boolean isValidOptSorting = false;
		boolean isValidOptOrder = false;
		boolean isValidOptCase = false;
		
		String option1Str = "";
		String option2Str = "";
		String option3Str = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			br.readLine();
	
			while (!isValidOptSorting) {
				System.out.println("Escolha o algoritmo de ordenacao desejado (1-8): \n"
							     + "1 - CountingSort\n"
							     + "2 - HeapSort\n"
							     + "3 - InsertionSort\n"
							     + "4 - MergeSort\n"
							     + "5 - QuickSort\n"
							     + "6 - QuickSortMedianOfThree\n"
							     + "7 - SelectionSort\n"
							     + "8 - ThreeWayQuickSort");
				
				System.out.print("\nOpcao: ");
				option1Str = sc.nextLine();
				
				isValidOptSorting = validateAlgorithmOption(option1Str);
				if (!isValidOptSorting) {
					System.out.println("\nOpcao invalida, tente novamente!");
					TimeUnit.SECONDS.sleep(2);
					clearScreen();
				}
				
			}
			
			clearScreen();
			while (!isValidOptOrder) {
				System.out.println("Escolha o parametro para a ordenacao (1-3): \n"
							     + "1 - Data\n"
							     + "2 - Mes e Ano\n"
							     + "3 - Comprimento da Senha"
							   );
				
				System.out.print("\nOpcao: ");
				option2Str = sc.nextLine();
				
				isValidOptOrder = validateOption(option2Str);
				if (!isValidOptOrder) {
					System.out.println("\nOpcao invalida, tente novamente!");
					TimeUnit.SECONDS.sleep(2);
					clearScreen();
				}
				
			}
			
			clearScreen();
			while (!isValidOptCase) {
				System.out.println("Escolha o caso para a ordenacao (1-3): \n"
							     + "1 - Melhor caso\n"
							     + "2 - Medio caso\n"
							     + "3 - Pior caso"
							   );
				
				System.out.print("\nOpcao: ");
				option3Str = sc.nextLine();
				
				isValidOptCase = validateOption(option3Str);
				if (!isValidOptCase) {
					System.out.println("\nOpcao invalida, tente novamente!");
					TimeUnit.SECONDS.sleep(2);
					clearScreen();
				}
				
			}		
			
			int option1 = Integer.parseInt(option1Str);
			int option2 = Integer.parseInt(option2Str);
			int option3 = Integer.parseInt(option3Str);
			
			if (option1 == 1) {
				generateResults(new CountingSort(null), option2, option3);
			}
			else if (option1 == 2) {
				generateResults(new HeapSort(null), option2, option3);
			}
			else if (option1 == 3) {
				generateResults(new InsertionSort(null), option2, option3);
			}
			else if (option1 == 4) {
				generateResults(new MergeSort(null), option2, option3);
			}
			else if (option1 == 5) {
				generateResults(new QuickSort(null), option2, option3);
			}
			else if (option1 == 6) {
				generateResults(new QuickSortMedianOfThree(null), option2, option3);
			}
			else if (option1 == 7) {
				generateResults(new SelectionSort(null), option2, option3);
			}
			else if (option1 == 8) {
				generateResults(new ThreeWayQuickSort(null), option2, option3);
			}
		}
		catch (IOException e) {
			System.out.println("Antes de executar o programa principal voce deve executar o metodo\n"
					         + "main da classe FormatDate no caminho: " + FormatPath.getPath("src\\dataProcessing\\FormatDate") + "\n");
		}
		
		sc.close();
	}
	
	private static void generateResults (Sorting sortAlgorithm, int option2, int option3)
			throws NumberFormatException, FileNotFoundException, ParseException, IOException {
		
		if (option2 == 1) {
			
			if (sortAlgorithm instanceof CountingSort) {
				((CountingSort) sortAlgorithm).setOrderBy(OrderBy.DATE);
			}
			else {
				((AbstractSorting) sortAlgorithm).setComparator(comparatorDate);
			}
			
			if (option3 == 1) {
				GenerateSortResults.generateResults(sortAlgorithm, OrderBy.DATE, CaseSort.BEST);
			} else if (option3 == 2) {
				GenerateSortResults.generateResults(sortAlgorithm, OrderBy.DATE, CaseSort.AVERAGE);
			} else if (option3 == 3) {
				GenerateSortResults.generateResults(sortAlgorithm, OrderBy.DATE, CaseSort.WORST);
			}

		} else if (option2 == 2) {
			
			if (sortAlgorithm instanceof CountingSort) {
				((CountingSort) sortAlgorithm).setOrderBy(OrderBy.MONTH);
			}
			else {
				((AbstractSorting) sortAlgorithm).setComparator(comparatorYearMonth);
			}
			
			if (!((sortAlgorithm instanceof QuickSort))) {
				if (option3 == 1) {
					GenerateSortResults.generateResults(sortAlgorithm, OrderBy.MONTH, CaseSort.BEST);
				} else if (option3 == 2) {
					GenerateSortResults.generateResults(sortAlgorithm, OrderBy.MONTH, CaseSort.AVERAGE);
				} else if (option3 == 3) {
					GenerateSortResults.generateResults(sortAlgorithm, OrderBy.MONTH, CaseSort.WORST);
				}
			}
			else {
				System.out.println("\nGera StackOverflowException!");
			}
		} else if (option2 == 3) {
			
			if (sortAlgorithm instanceof CountingSort) {
				((CountingSort) sortAlgorithm).setOrderBy(OrderBy.LENGTH);
			}
			else {
				((AbstractSorting) sortAlgorithm).setComparator(comparatorLength);
			}
			
			if (!(sortAlgorithm instanceof QuickSort || sortAlgorithm instanceof QuickSortMedianOfThree)) {
				if (option3 == 1) {
					GenerateSortResults.generateResults(sortAlgorithm, OrderBy.LENGTH, CaseSort.BEST);
				} else if (option3 == 2) {
					GenerateSortResults.generateResults(sortAlgorithm, OrderBy.LENGTH, CaseSort.AVERAGE);
				} else if (option3 == 3) {
					GenerateSortResults.generateResults(sortAlgorithm, OrderBy.LENGTH, CaseSort.WORST);
				}
			}
			else {
				System.out.println("\nGera StackOverflowException!");
			}

		}
	}	
	
	private static boolean validateAlgorithmOption(String num) {
		
		String[] numsString = {"1", "2", "3", "4", "5", "6", "7", "8"};
		
		boolean result = false;
		
		for (String s: numsString) {
			if (num.equals(s)) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	private static boolean validateOption(String num) {
		
		String[] numsString = {"1", "2", "3"};
		
		boolean result = false;
		
		for (String s: numsString) {
			if (num.equals(s)) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	private static void clearScreen() {  
		for (int i = 0; i <= 25; i++) {
			System.out.println();
		}
	}  
}
