package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandle {
    public static void main(String[] args) {

        //create new file
        createNewFile();

        //write to file
        writeToFile();

        //read from file
        readFromFile();

        //get file info
        getFileInfo();

        //delete file
        deleteFile();

    }

    public static void createNewFile() {
        try {
            String home = System.getProperty("user.home");
            File newFile = new File(home + "/Desktop/testFile.txt");
            //file for delete method
            File tempFile = new File(home + "/Desktop/tempFile.txt");
            tempFile.createNewFile();
            //
            if(newFile.createNewFile()) {
                System.out.println("new java file created.");
            } else {
                System.out.println("this java file already exists.");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void writeToFile() {
        try {
            String home = System.getProperty("user.home");
            FileWriter writeFile = new FileWriter(home + "/Desktop/testFile.txt");
            writeFile.write("this text was written with java write to file method.");
            writeFile.close();
            System.out.println("file successfully written to.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void readFromFile() {
        try {
            String home = System.getProperty("user.home");
            File myFile = new File(home + "/Desktop/testFile.txt");
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void getFileInfo() {
        String home = System.getProperty("user.home");
        File myFile = new File(home + "/Desktop/testFile.txt");
        if (myFile.exists()) {
            System.out.println("File name --> " + myFile.getName());
            System.out.println("Absolute path --> " + myFile.getAbsolutePath());
            System.out.println("Readable --> " + myFile.canRead());
            System.out.println("Writable --> " + myFile.canWrite());
            System.out.println("File size bytes --> " + myFile.length());
        } else {
            System.out.println("such file does not exist.");
        }
    }

    public static void deleteFile() {
        String home = System.getProperty("user.home");
        File tempFile = new File(home + "/Desktop/tempFile.txt");
        if (tempFile.delete()) {
            System.out.println("file deleted successfully.");
        } else {
            System.out.println("cannot delete file.");
        }
    }
}
