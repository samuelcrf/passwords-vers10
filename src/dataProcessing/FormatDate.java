package dataProcessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import util.FormatPath;

public class FormatDate {
	

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		
		String strPath = FormatPath.getPath("data\\rawdata\\passwords.csv");
		
		File path = new File(strPath);
		
		String strTargetFilePath = FormatPath.getPath("data\\processedData\\passwords_formated_data.csv");
		

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String firstLine = br.readLine();
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(strTargetFilePath))) {
				bw.write(firstLine);
				bw.newLine();	

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String line = br.readLine();

			System.out.println("Gerando o arquivo resultante...");
			while (line != null) {
				
				String[] data = line.split(",");
				
				String date;
				if (data.length > 4) {
					int dif = data.length - 4;
					
					date = data[3 + dif];
					data = Arrays.copyOf(data, 4 + dif);
					data[3 + dif] = sdf2.format(sdf1.parse(date));
				}
				else {
					date = data[3];
					data = Arrays.copyOf(data, 4);
					data[3] = sdf2.format(sdf1.parse(date));
				}
				
				String result = String.join(",", data);
				
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(strTargetFilePath, true))) {
					bw.write(result);
					bw.newLine();

				} catch (IOException e) {
					e.printStackTrace();
				}
				
				line = br.readLine();
			}
			System.out.println("\nO arquivo foi gerado no caminho: " + strTargetFilePath);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}
	

