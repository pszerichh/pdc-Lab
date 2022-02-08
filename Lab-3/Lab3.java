import java.util.Scanner;

public class Lab3 {
     public static void main(String[] args) {
          int sq, sl;
          Scanner scn = new Scanner(System.in);
          System.out.print("Enter upper bound for sum of squares: ");
          sq = scn.nextInt();
          System.out.print("Enter number of seconds to sleep: ");
          sl = scn.nextInt();
          scn.close();
          sqsum sqsm = new sqsum("square sum", sq);
          smeth slm = new smeth("sleep", sl);
          sqsm.start();
          slm.start();
          try{
               sqsm.join();
               slm.join();
          }
          catch(InterruptedException e){
               System.out.println("caught main thread inetrruption error.");
          }
          System.out.println("total sum o squares: "+sqsm.sum);
          System.out.println("time taken for sum of squares: "+sqsm.time+" milli seconds");
          System.out.println("time taken for sleeep(): "+slm.time+" milli seconds");
     }
}

class sqsum extends Thread{
     int n, sum;
     long time;
     sqsum(String name, int n){
          super(name);
          this.n = n;
          this.sum =0; this.time=0;
          System.out.println("thread initialized: "+this.getName()+" for sum of squares.");
     }
     public void run(){
          long begin = System.currentTimeMillis();
          for(int i=1; i<=n; i++){
               System.out.println("adding square of: "+i);
               sum += i*i;
          }
          time = System.currentTimeMillis() - begin;
     }
}
class smeth extends Thread{
     int n;
     long time;
     smeth(String name, int n){
          super(name);
          this.n = n;
          this.time =0;
          System.out.println("thread initialized: "+this.getName()+" for sleep()");
     }
     public void run(){
          long begin = System.currentTimeMillis();
          try{
               for(int i=1; i<=n; i++){
                    Thread.sleep(1000);
                    System.out.println("thread "+this.getName()+" slept for "+i+" seconds");
               }
          }
          catch(InterruptedException e){
               System.out.println("caught "+this.getName()+" interruption error.");
          }
          time = System.currentTimeMillis() - begin;
     }
}