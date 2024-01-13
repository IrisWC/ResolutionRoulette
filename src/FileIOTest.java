import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileIOTest {

//    private static StringBuffer stringBufferOfData = new StringBuffer();
//    private static String filename = null;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        StringBuffer fileRead = readFile("easy/input");

        if (fileRead.length() != 0) {
            replacement();

            writeToFile();

        }

        System.exit(0);
    }

    private static StringBuffer readFile(String file) {
        Scanner fileToRead = null;
        StringBuffer sb = new StringBuffer();
        try {
            fileToRead = new Scanner(new File(file));
            for (String line = null; fileToRead.hasNextLine() && (line = fileToRead.nextLine()) != null; ) {
            	sb.append(line).append("\r\n");
            }
            fileToRead.close();
            return sb;
        } catch (FileNotFoundException ex) {
            System.out.println("The file " + file + " could not be found! " + ex.getMessage());
//            return null;
        }
//        } finally {
//            fileToRead.close();
//            return sb;
//        }
    }

    // use the returned sb from readFile
    private static void writeToFile(String file, StringBuffer sb) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(sb.toString());
            bw.close();

        } catch (Exception e) {//if an exception occurs
            System.out.println("Error occured while attempting to write to file: " + e.getMessage());
        }
    }

    private static void replacement() {
        System.out.println("Please enter the contents of a line you would like to edit: ");//prompt for a line in file to edit
        String lineToEdit = sc.nextLine();//read the line to edit

        System.out.println("Please enter the the replacement text: ");//prompt for a line in file to replace
        String replacementText = sc.nextLine();//read the line to replace

        //System.out.println(sb);//used for debugging to check that my stringbuffer has correct contents and spacing

        int startIndex = stringBufferOfData.indexOf(lineToEdit);//now we get the starting point of the text we want to edit
        int endIndex = startIndex + lineToEdit.length();//now we add the staring index of the text with text length to get the end index

        stringBufferOfData.replace(startIndex, endIndex, replacementText);//this is where the actual replacement of the text happens

        System.out.println("Here is the new edited text:\n" + stringBufferOfData); //used to debug and check the string was replaced


    }
}