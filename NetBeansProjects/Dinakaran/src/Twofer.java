/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Twofer {
    public String twofer(String name) {
        if(name==null)
        {
            return "One for you,one for me";
        }
        if(name.length()>0)
        {
            return "One for " +name+" ,one for me";
        }
        return "";
    }
    public static void main(String[] args) {
        Twofer t=new Twofer();
        System.out.println(t.twofer(null));
    }
}