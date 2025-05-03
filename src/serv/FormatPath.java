package serv;

import java.io.File;

public class FormatPath {
	
	private static final String pathSeparator = File.separator;
	
	public static String getPath(String str) {
		
		String newStr = str.replace("\\", pathSeparator);
		
		return newStr;
		
	}

}
