public class Test extends Thread{
    public void run(){
        System.out.println("Thread running");
    }

   public static void main(String[] args) {
       Thread t1=new Thread();
       t1.start();
   }
}
