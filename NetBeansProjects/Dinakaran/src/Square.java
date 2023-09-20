public class Square
{
int sum=0;
int square=0;
int sum1=0;
int square1=0;

    int computeSquareOfSumTo(int input) {
        for(int i=input;i>0;i--)
            {
                sum+=i;
              }
        square=sum*sum;
        return square;
     }
      int computeSumOfSquaresTo(int input) {
        for(int i=input;i>0;i--)
            {
                square1=i*i;
                sum1+=square1;
                
}
        return sum1;
    }
        int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input)-computeSumOfSquaresTo(input);
    }
    public static void main(String[] args) {
       Square i=new Square();
        System.out.println(i.computeDifferenceOfSquares(10));
    }
}
