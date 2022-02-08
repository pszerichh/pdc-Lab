import java.lang.management.ThreadInfo;
import java.util.*;
import javax.swing.text.Highlighter.Highlight;

//implementing multi threads
public class Lab_2 {
     public static void main(String[] args) {
          System.out.print("Enter upper limit: ");
          Scanner scn = new Scanner(System.in);
          int n = scn.nextInt();
          scn.close();
          Square sq1 = new Square("One", 1, n/2);
          Square sq2 = new Square("Two", (n/2+1), n);
          long time = System.nanoTime();
          sq1.td.start();
          sq2.td.start();
          try{
               sq1.td.join();
               sq2.td.join();
          }
          catch(InterruptedException e){
               System.out.println("Interrupted main thread: "+e);
          }
          System.out.println("sum of squares: "+(sq1.sq+sq2.sq));
          System.out.println("Total time: "+(System.nanoTime()-time)+" milli seconds");
     }
}

class Square implements Runnable{
     Thread td;
     int low, high;
     int sq;
     Square(String name, int low, int high){
          td = new Thread(this, name);
          this.low = low; this.high = high; sq = 0;
     }
     public void run(){
          long time = System.nanoTime();
          for(int i=this.low; i<=this.high; i++){
               sq += i*i;
          }
          time = System.nanoTime() - time;
          System.out.println("Total time taken: "+time+" milli seconds"+" by thread: "+td);
     }

}
