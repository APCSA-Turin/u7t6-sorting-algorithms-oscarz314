package com.example.project.Selection_Sort;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class SelectionSort {

    // PART A. implementing selection sort
    public static int[] selectionSort(int[] elements) {
       int minIndex = 0;

       for(int i = 0; i < elements.length - 1; i++){
        for (int j = i + 1; j < elements.length; j++){
            if (elements[j] < elements[minIndex]){
                minIndex = j;
            }
        }
        int temp = elements[minIndex];
        elements[minIndex] = elements[i];
        elements[i] = temp;
        minIndex = i + 1;
       }

       return elements;
    }


    // PART B. sorting a 1000-word list
    public static ArrayList<String> selectionSortWordList(ArrayList<String> words) {
        int minIndex = 0;

       for(int i = 0; i < words.size() - 1; i++){
        for (int j = i + 1; j < words.size(); j++){
            if (words.get(j).compareTo(words.get(minIndex)) < 0){
                minIndex = j;
            }
        }
        String temp = words.set(minIndex, words.get(i));
        words.set(i, temp);
        minIndex = i + 1;
       }

       return words;
    }

    public static void main(String[] args) {
        int[] arr = {3, 86, -20, 14, 40, 19, -4, 100, 89, 13, 54, 12, 77, -5, 0, 6};
        int[] newArr = selectionSort(arr);
        for(int i = 0; i < newArr.length; i++){
            System.out.print(newArr[i] + ", ");
        }
    }

    //call this method to load 1000 words into list. Use it to test Part B
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
