package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> mergedList = new ArrayList<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader("src/input1.txt"))) {
            String line;
            while ((line = br1.readLine()) != null) {
                try {
                    list1.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input in input1.txt");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Error reading file");
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader("src/input2.txt"))) {
            String line;
            while ((line = br2.readLine()) != null) {
                try {
                    list2.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input in input1.txt");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Error reading file");
        }

        mergedList.addAll(list1);
        mergedList.addAll(list2);
        System.out.println(mergedList);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/merged.txt"));
            for (Integer i : mergedList) {
                String elem = Integer.toString(i);
                writer.write(elem + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            System.err.println("Error writing file");
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/common.txt"));
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (list1.get(i) == list2.get(j)) {
                        writer.write(list1.get(i) + "\n");
                        writer.flush();
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing file");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Index out of bounds");
        }
    }
}