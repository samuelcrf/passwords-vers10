package serv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import dataProcessing.ClassifyPassword;
import dataProcessing.DataPassword;

public class UtilGenerateArray {
	
	private static final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	private static final SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");
	
	public static DataPassword[] generateArrayData(String sourceFilePath) throws NumberFormatException, ParseException {
		
		File path = new File(sourceFilePath);
		
		
		int lengthArray = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			br.readLine();
			
			String line = br.readLine();
			
			while (line != null) {				
				lengthArray++;
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		DataPassword[] arrayData = new DataPassword[lengthArray];
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			br.readLine();
			String line = br.readLine();

			int i = 0;
			while (line != null) {
				String[] data = line.split(",");
				
				
				if (data.length > 4) {
					int interval = data.length - 4;
					
					String password = ClassifyPassword.concatenatePassword(data);
					if (data[2 + interval].equals("")) {
						arrayData[i++] = new DataPassword(Integer.parseInt(data[0]), password, 0, sdf1.parse(data[3 + interval]), sdf2.parse(data[3 + interval].substring(3)));
					}
					else {
						arrayData[i++] = new DataPassword(Integer.parseInt(data[0]), password, Integer.parseInt(data[2 + interval]), sdf1.parse(data[3 + interval]), 
								                                                                                                        sdf2.parse(data[3 + interval].substring(3)));
					}
					 
				}
				else {
					if (data[2].equals("")) {
						arrayData[i++] = new DataPassword(Integer.parseInt(data[0]), data[1], 0, sdf1.parse(data[3]), sdf2.parse(data[3].substring(3)));
					}
					else {
						arrayData[i++] = new DataPassword(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), sdf1.parse(data[3]), sdf2.parse(data[3].substring(3)));
					}
				}
				
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return arrayData;
	}

}
