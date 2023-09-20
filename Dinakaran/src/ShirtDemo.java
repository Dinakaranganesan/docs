
public class ShirtDemo {
    public static void main(String[] args) {
        Shirt a=new Shirt();
        System.out.println(a.BRAND);
        System.out.println(a.COLOR);
        //private members price is accessed with the help of methods
        System.out.println(a.getPrice());
        //
        System.out.println(a.size);
        //passing Brand to Constructor
        Shirt b=new Shirt("Peter England");
        System.out.println(b.BRAND);
        System.out.println(b.COLOR);
        System.out.println(b.getPrice());
        System.out.println(b.size);
        //passing Brand and color to Construtor
       Shirt c=new Shirt("Raymond","Red");
        System.out.println(c.BRAND);
        System.out.println(c.COLOR);
        System.out.println(c.getPrice());
        System.out.println(c.size);
        //passing Brand,color,price,size
        Shirt d=new Shirt("Parx","Green",3000.0,"L");
        System.out.println(d.BRAND);
        System.out.println(d.COLOR);
        //Modifying private Members With the help of methods
       d.setPrice(3500.0);
        System.out.println(d.getPrice());
        System.out.println(d.size);
    }
}
