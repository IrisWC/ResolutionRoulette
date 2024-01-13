package fileStuff;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileChanger {
	
	private static StringBuffer stringBufferOfData = new StringBuffer();
	private String file;
	
	public FileChanger(String f) {
		file = f;
	}
	
	public boolean readFile() {
		Scanner fileToRead = null;
		try {
			fileToRead = new Scanner(new File(file));
			for (String line; fileToRead.hasNextLine() && (line = fileToRead.nextLine()) != null; ) {
				System.out.println(line);
				stringBufferOfData.append(line).append("\r\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file " + file + " could not be found! " + e.getMessage());
			return false;
		} finally {
			fileToRead.close();
			return true;
		}
	}
	
	public void add(String toEdit, String edit) {
		if (toEdit == null) {
			stringBufferOfData.append(edit);
		}
		else {
			int startIndex = stringBufferOfData.indexOf(toEdit);
			int endIndex = startIndex + toEdit.length();
			stringBufferOfData.delete(startIndex, endIndex);
			stringBufferOfData.insert(startIndex, edit);
		}
	}
	
	public void writeToFile() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(stringBufferOfData.toString());
			bw.close();
		} catch (Exception e) {
			System.out.println("Error occured while attempting to write to file: " + e.getMessage());
		}
	}

    
}