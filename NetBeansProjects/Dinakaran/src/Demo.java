public class Demo
{int d=45;
    public static void main(String[] args) {
        Demo d=new Demo();
            System.out.println(d.getClass());
            System.out.println(d.getClass().getName());
          System.out.println(System.identityHashCode(d));  
    }
}
