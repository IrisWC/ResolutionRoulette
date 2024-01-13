package fileStuff;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JFrame;

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
			int start = stringBufferOfData.indexOf(toEdit);
			int end = start + toEdit.length();
			stringBufferOfData.delete(start, end);
			stringBufferOfData.insert(start, edit);
		}
	}
	
	public void delete(String line) {
		int start = stringBufferOfData.indexOf(line);
		int end = start + line.length();
		stringBufferOfData.delete(start, end);
	}
	
	public void deleteFirstChar() {
//		int start = stringBufferOfData.indexOf(line);
//		int end = start + line.length();
		stringBufferOfData.delete(0, 1);
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
	
	public String toString() {
		int start = file.indexOf("/") + 1;
		int end = file.indexOf(".");
		return file.substring(start, end);
	}
	
	public String readFileContents() {
		String contents = "";
		Scanner fileToRead = null;
		try {
			fileToRead = new Scanner(new File(file));
			for (String line; fileToRead.hasNextLine() && (line = fileToRead.nextLine()) != null; ) {
				contents = contents + line + "\r\n";
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file " + file + " could not be found! " + e.getMessage());
			return "";
		} finally {
			fileToRead.close();
		}
		return contents;
	}

    
}