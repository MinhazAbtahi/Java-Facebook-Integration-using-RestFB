package facebookintegration;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * File Writer Utilities
 *
 * @author abtahi
 */

public class FileWrite {

    String filePath;

    File file;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;

    public FileWrite() {

    }

    public FileWrite(String filePath) {
        this.filePath = filePath;
    }

    public void writeInFile(String message) throws IOException {
        try {
            file = new File(filePath);

            if (!file.exists()) {
                System.out.println("Creating new File...");
                file.createNewFile();

                if (file.exists()) {
                    System.out.println("New File Created");
                }

                fileWriter = new FileWriter(file.getAbsoluteFile(), true);
                bufferedWriter = new BufferedWriter(fileWriter);

                System.out.println("Writting in File...");
                bufferedWriter.write(message);
                bufferedWriter.newLine();

                bufferedWriter.flush();

                System.out.println("Writting in File Successfully Completed");
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println(ioException);
        } finally {
            bufferedWriter.close();
        }
    }

    public void writeInFile(ArrayList<String> messages) throws IOException {
        try {
            file = new File(filePath);

            if (!file.exists()) {
                System.out.println("Creating new File...");
                file.createNewFile();

                if (file.exists()) {
                    System.out.println("New File Created");
                }

                fileWriter = new FileWriter(file.getAbsoluteFile());
                bufferedWriter = new BufferedWriter(fileWriter);

                System.out.println("Writting in File...");

                for (int i = 0; i < messages.size(); i++) {
                    bufferedWriter.write(messages.get(i));
                    bufferedWriter.newLine();
                }

                bufferedWriter.flush();

                System.out.println("Writting in File Successfully Completed");
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println(ioException);
        } finally {
            bufferedWriter.close();
        }
    }
}
