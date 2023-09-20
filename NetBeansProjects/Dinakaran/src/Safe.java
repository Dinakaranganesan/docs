/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Safe {
    static int mr;
    static int mc;
    static int minr;
    static int  minc;
    

    void max_min(int a[][])
    {
        int tempmax=a[0][0];
        int tempmin=a[0][0];
            for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
            {
                if(tempmax <a[i][j])
                {
                    tempmax=a[i][j];
                    mr=i;
                    mc=j;
                }
                if(tempmin>a[i][j])
                {
                    tempmin=a[i][j];
                    minr=i;
                    minc=j;
                }
}
}          
}
    void find(int a[][])
    {
          for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
            {
                if(mr!=i && mc!=j && minr!=i && minc!=j){
                    System.out.println(a[i][j]);
            }
            }
        }
    }
    
    
    public static void main(String[] args) {
     int [][] a={{8,8,3},{6,2,4},{12,1,2}};
     Safe s=new Safe();
     s.max_min(a);
     s.find(a); 
    }
    }
