package dataProcessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import util.FormatPath;

public class Classify{
	
	
	private static final Character[] NUMBER_CHARACTERS = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9'};
	private static final Character[] LETTERS_CHARACTERS = {'q','w','e','r','t','y','u','i','o','p','a','s',
			                                               'd','f','g','h','j','k','l','z','x','c','v','b','n','m'};

	public static void main(String[] args) {
		
		String strPath = FormatPath.getPath("data\\rawdata\\passwords.csv");
		
		File path = new File(strPath);
		
		String strTargetFilePath = FormatPath.getPath("data\\processedData\\passwords_classifier.csv");
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String firstLine = br.readLine();
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(strTargetFilePath))) {
				bw.write(firstLine + ",class");
				bw.newLine();	

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String line = br.readLine();
			
			System.out.println("Gerando o arquivo resultante...");
			while (line != null) {
				
				String password;
				int passwordLength;
				String[] data = line.split(",");
				
				if (data.length > 4) {
					password = concatenatePassword(data);
					passwordLength = Integer.parseInt(data[2 + (data.length - 4)]);
				}
				else {
					password = data[1];
					
					if (data[2].equals("")) {
						passwordLength = 0;
					}
					else {
						passwordLength = Integer.parseInt(data[2]);
					}
				}
				
				String passwordType = classifyPassword(password, passwordLength);
				
				if (passwordType != null) {
					try (BufferedWriter bw = new BufferedWriter(new FileWriter(strTargetFilePath, true))) {
						bw.write(line + "," + passwordType);
						bw.newLine();	
	
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				line = br.readLine();
			}
			System.out.println("\nO arquivo foi gerado no caminho: " + strTargetFilePath);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	private static String classifyPassword(String password, int passwordLength) {
		
		String result = null;
		
		String[] charactersPassword = password.split("");
		if (containsLowerCaseLetters(charactersPassword)) {
			
			if (containsUpperCaseLetters(charactersPassword)) {
				
				if (containsNumbers(charactersPassword)) {
					
					if (containsSpecialCharacters(charactersPassword)) {
						
						if (passwordLength > 7) {
							result = "Muito Boa";
						}
						else {
							result = "Boa";
						}
					}
				}
			}
		}
		return result;
		
	}
	
	private static boolean containsLowerCaseLetters(String[] characters) {

		for (String ch: characters) {
			
			for (Character lt: LETTERS_CHARACTERS) {
				if (ch.equals(lt + "")) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static boolean containsUpperCaseLetters(String[] characters) {

		for (String ch: characters) {
			
			for (Character lt: LETTERS_CHARACTERS) {
				if (ch.equals(Character.toUpperCase(lt) + "")) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static boolean containsNumbers(String[] characters) {

		for (String ch: characters) {
			
			for (Character num: NUMBER_CHARACTERS) {
				if (ch.equals(num + "")) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static boolean containsSpecialCharacters(String[] characters) {
		
		boolean result = false;
		
		boolean isNotLowerLetter = true;
		boolean isNotUpperLetter = true;
		boolean isNotNumber = true;
		
		for (String ch: characters) {
			
			for (Character lt: LETTERS_CHARACTERS) {
				if (ch.equals(lt + "")) {
					isNotLowerLetter = false;
				}		
			}
			
			for (Character lt: LETTERS_CHARACTERS) {
				if (ch.equals(Character.toUpperCase(lt) + "")) {
					isNotUpperLetter = false;
				}
			}
			
			for (Character lt: NUMBER_CHARACTERS) {
				if (ch.equals(lt + "")) {
					isNotNumber = false;
				}
			}
			
			result = isNotLowerLetter && isNotUpperLetter && isNotNumber;
			if (result) {
				break;
			}
			
			isNotLowerLetter = true;
			isNotUpperLetter = true;
			isNotNumber = true;
			
		}
		
		return result;
		
	}
	
	public static String concatenatePassword(String[] data) {
		
		String result = "";
		
		int interval = 1 + (data.length - 4);
		for (int i = 1; i <= interval; i++) {
			if (i < interval) {
				result += data[i] + ",";
			}
			else {
				result += data[i];
			}
		}
		
		return result;
	}
	

}
