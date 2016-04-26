package facebookintegration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * File Utilities
 *
 * @author abtahi
 */

public class FileUtil {
    
    public FileUtil() {
    
    }
    
    public void writeToFile(String filePath,
            String linesToWrite,
            boolean appendToFile) throws IOException{

        PrintWriter printWriter = null;

        try {
            if (appendToFile) {
                //If the file already exists, start writing at the end of it.
                printWriter = new PrintWriter(new FileWriter(filePath, true));
            } 
            else {
                printWriter = new PrintWriter(new FileWriter(filePath));
                //this is equal to:
                //printWriter = new PrintWriter(new FileWriter(filePath, false));
            }

            printWriter.println(linesToWrite);
            
            printWriter.flush();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
            //Close the PrintWriter
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    public void writeToFile(String filePath,
            String[] linesToWrite,
            boolean appendToFile) throws IOException{

        PrintWriter printWriter = null;

        try {
            if (appendToFile) {
                //If the file already exists, start writing at the end of it.
                printWriter = new PrintWriter(new FileWriter(filePath, true));
            } 
            else {
                printWriter = new PrintWriter(new FileWriter(filePath));
                //this is equal to:
                //printWriter = new PrintWriter(new FileWriter(filePath, false));
            }
            for (int i = 0; i < linesToWrite.length; i++) {
                printWriter.println(linesToWrite[i]);
            }
            
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //Close the PrintWriter
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    // 
    public void writeToFile(String filePath,
            ArrayList<String> linesToWrite,
            boolean appendToFile) throws IOException{

        PrintWriter printWriter = null;

        try {
            if (appendToFile) {
                //If the file already exists, start writing at the end of it.
                printWriter = new PrintWriter(new FileWriter(filePath, true));
            } 
            else {
                printWriter = new PrintWriter(new FileWriter(filePath));
                //this is equal to:
                //printWriter = new PrintWriter(new FileWriter(filePath, false));
            }

            for (int i = 0; i < linesToWrite.size(); i++) {
                printWriter.println(i+1);
                printWriter.println(linesToWrite.get(i));
                printWriter.println();
            }
            
            printWriter.flush();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
            //Close the PrintWriter
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}
