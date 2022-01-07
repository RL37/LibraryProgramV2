package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileHandling {

    private static ArrayList<String> booksLibrary = new ArrayList<>();

    public static void saveDetailsToFile(String Details,String fileToAccess){
        File fileHandler = new File(fileToAccess);
        try {
            FileWriter myWriter = new FileWriter(fileHandler.getName(), true); //True means append to file contents, False means overwrite
            myWriter.write(Details +"\n"); // Overwrites everything in the file
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readLibrary(String fileToAccess){
        File fileHandler = new File(fileToAccess);
        try {
            Scanner myReader = new Scanner(fileHandler);
            while (myReader.hasNextLine()) {
                String currentBookDetails = myReader.nextLine();
                String[] bookDetailsToShow = currentBookDetails.split(",");
                System.out.println("");
                for (int j = 0; j < 4; j++) {
                    System.out.print(bookDetailsToShow[j]+" ");
                }
            }
            System.out.println("");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void createFile(String fileToAccess) {
        File fileHandler = new File(fileToAccess);
        try {
            if (fileHandler.createNewFile()) {
                System.out.println("File created: " + fileHandler.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String getBookDetails(){
        String bookTitle = getInput("What is the book called:");
        String bookISBN = getInput("What is the book ISBN number:");
        String bookAuthor = getInput("Who is the author");
        String bookGenre = getInput("What is the books genre:");
        return (bookTitle + "," + bookISBN + "," + bookAuthor + "," + bookGenre);
    }

    public static void showBooksListAll(){
        for (int i = 0; i < booksLibrary.size(); i++) {
            System.out.println(booksLibrary.get(i));
            //System.out.println(booksLibrary.get(i).split(","));
        }
    }

    public static void saveBookDetailsToArray(String bookDetails) {
        System.out.println(bookDetails);
        booksLibrary.add(bookDetails);
    }


    private static String getInput(String caption){
        System.out.println(caption);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
