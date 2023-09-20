/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
abstract class Car {
    double price;
   static int noofseats=5;
 public Car(double price, int noofseats){
     this.price=price;
     this.noofseats=noofseats;
     
 }
    abstract int changeGear();
   static void speed(){
        System.out.println("Speed of the car");
    }
    public static void main(String[] args) {
        speed();
    }
}

 

class Maruticar extends Car{
    String model;
    public Maruticar(String model){
        super(1200,5);
        this.model=model;
    }
    @Override
    public int changeGear(){
     return  4; 
    }
}
    
  class Audicar extends Car{
      double aprice;

    public Audicar(double aprice) {
        super(150000.0,5);
        this.aprice=aprice;
    }
       
       @Override
       public int changeGear(){
           return 5;
       }
      
   } 

   