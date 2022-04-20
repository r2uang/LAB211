/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0001;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class Main {
    public int checkInput(){
        Scanner sc = new Scanner(System.in); //System.input
        int n = 0;
        System.out.print("Enter number of array: ");
        while (true) {            
            try {
                 n = Integer.parseInt(sc.nextLine());
                 if(n<=0){
                     System.out.print("Please input positive number and greater than 0: ");
                 }
                 else{
                     break;
                 }
                 
            } catch (Exception e) {
                System.out.println("Invalid number,please input again: ");
            }
        }
        
        return n;
    }
    
    public void display(int arr[],int n ,String mess){
        System.out.print(mess);
        for (int i = 0; i < n; i++) {
            if(i == n-1){
               System.out.print( arr[i] + "]");
            }
            else{
                System.out.print(arr[i] + ", ");
            }
        }
    }
    public void randomArray(int arr[],int n){
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(n);
        }
    }
    
    public  void bbsort(int arr[], int n) {
     for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]){
                 // swap arr[j+1] và arr[i]
                 int temp =arr[j];
                 arr[j] = arr[j+1];
                 arr[j+1] =temp;   
                }
            }
        }

     
}
    
            
    public static void main(String[] args) {
        //https://docs.google.com/document/d/11DS62akFAwbSEDqGB3h8nlIeqLgJnd0z/edit
        Main bs = new Main();
        int n = bs.checkInput();
        int arr[] = new int[n];
        
        bs.randomArray(arr, n);
        bs.display(arr, n, "Unsorted array: [");
        bs.bbsort(arr, n);
        System.out.println("");
        bs.display(arr, n, "Sorted array: [");
        System.out.println("");
    }    
}
