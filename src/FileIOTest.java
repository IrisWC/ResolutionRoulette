import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileIOTest {

    private static StringBuffer stringBufferOfData = new StringBuffer();
//    private static String filename = null;
//    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean fileRead = readFile("easy/input.txt");

        if (fileRead) {
            add("i am a monkey", "i eat monkeys");

            writeToFile("easy/input.txt");

        }
    }

    private static boolean readFile(String file) {
        Scanner fileToRead = null;
        try {
            fileToRead = new Scanner(new File(file));
            for (String line; fileToRead.hasNextLine() && (line = fileToRead.nextLine()) != null; ) {
                System.out.println(line);
                stringBufferOfData.append(line).append("\r\n");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("The file " + file + " could not be found! " + ex.getMessage());
            return false;

        } finally {
            fileToRead.close();
            return true;
        }
    }

    private static void writeToFile(String file) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(stringBufferOfData.toString());
            bw.close();

        } catch (Exception e) {
            System.out.println("Error occured while attempting to write to file: " + e.getMessage());
        }
    }

    private static void add(String toEdit, String edit) {
        int startIndex = stringBufferOfData.indexOf(toEdit);
        int endIndex = startIndex + toEdit.length();
        stringBufferOfData.delete(startIndex, endIndex);
        stringBufferOfData.insert(startIndex, edit);

//        stringBufferOfData.replace(startIndex, endIndex, edit);

    }
}