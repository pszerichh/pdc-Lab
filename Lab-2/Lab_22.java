import java.util.*;

//implementing single thread

public class Lab_22 {
     public static void main(String[] args) {
          int n, sq = 0;
          Scanner scn = new Scanner(System.in);
          System.out.print("Enter upper limit: ");
          n = scn.nextInt();
          long time = System.currentTimeMillis();
          for(int i=1; i<=n; i++){
               sq += i*i;
          }
          System.out.println("Sum of squares: "+sq);
          System.out.println("Total time taken: "+(System.nanoTime()-time)+" nano seconds");
     }
}
