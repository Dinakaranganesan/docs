/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class highest {
 public static void main(String args[]){
  int arr[]={12,14,15,16};
  int a[]=new int[arr.length];
  int n= arr.length-1;
    
      for(int j=0;j<arr.length;j++){
      a[j]=arr[n];
      n--;
    }
    
    for(int k=0;k<a.length;k++){
     System.out.println(a[k]);
    }
 }
}


