package serv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import dataProcessing.DataPassword;

public class UtilWriteLines {
	
	public static void writeLines(String targetFilePath, DataPassword[] arrayData) throws FileNotFoundException, IOException {
		
		String sourceFilePath = FormatPath.getPath("data\\processedData\\passwords_formated_data.csv");
		
		File path = new File(sourceFilePath);
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String firstLine = br.readLine();
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFilePath))) {
				bw.write(firstLine);
				bw.newLine();	

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for (DataPassword dp: arrayData) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFilePath, true))) {
				bw.write(dp.toString());
				bw.newLine();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
