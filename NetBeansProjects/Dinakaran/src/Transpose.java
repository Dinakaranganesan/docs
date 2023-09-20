
public class Transpose {
    public static void main(String[] args) 
    {
        int [][]a={{1,2,3,4},{4,5,6,7},{7,8,9,10}};
        int [][]c=new int[4][3];
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)       
            {
               c[j][i]=a[i][j];
                    
                }
              }
        
    for(int[]d:c)
    {
        for(int e:d)
        {
            System.out.print(e +" ");
         }
        System.out.println(" ");
       }
    }
}
            



    
                