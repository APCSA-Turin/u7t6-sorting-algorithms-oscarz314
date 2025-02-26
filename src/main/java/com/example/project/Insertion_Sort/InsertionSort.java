package com.example.project.Insertion_Sort;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    // PART A. implementing insertion sort
    public static int[] insertionSort(int[] elements) {
       int count = 0;

        for (int i = 0; i < elements.length - 1; i++){
            int j = i + 1;
            while(j >= 1 && elements[j - 1] > elements[j]){
                int temp = elements[j];
                elements[j] = elements[j - 1];
                elements[j - 1] = temp;
                j--;
                count++;
            }
        }

        System.out.println(count);
        return elements;
    }

   
    public static void selectionSort(int[] elements) {
        int count = 0;
        int minIndex = 0;

       for(int i = 0; i < elements.length - 1; i++){
        for (int j = i + 1; j < elements.length; j++){
            if (elements[j] < elements[minIndex]){
                minIndex = j;
            }
            count++;
        }
        int temp = elements[minIndex];
        elements[minIndex] = elements[i];
        elements[i] = temp;
        minIndex = i + 1;
       }

       System.out.println(count);
    }

    // PART B. sorting a 1000-word list
    public static ArrayList<String> insertionSortWordList(ArrayList<String> words) {
        int count = 0;
    
        for (int i = 0; i < words.size() - 1; i++){
            int j = i + 1;
            while(j >= 1 && words.get(j - 1).compareTo(words.get(j)) > 0){
                String temp = words.set(j, words.get(j - 1));
                words.set(j - 1, temp);
                j--;
                count++;
            }
            
        }

        System.out.println(count);
        return words;
    }

    public static void selectionSortWordList(ArrayList<String> words) {
        int minIndex = 0;
        int count = 0;;

        for(int i = 0; i < words.size() - 1; i++){
         for (int j = i + 1; j < words.size(); j++){
             if (words.get(j).compareTo(words.get(minIndex)) < 0){
                 minIndex = j;
             }
             count++;
         }
         String temp = words.set(minIndex, words.get(i));
         words.set(i, temp);
         minIndex = i + 1;
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList<>();
        test = loadWordsInto(test);
        test = insertionSortWordList(test);
    }

    public static ArrayList<String> loadWordsInto(ArrayList<String> wordList) {
        try {
            Scanner input = new Scanner(new File("src/main/java/com/example/project/Selection_Sort/words.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordList;
    }


}