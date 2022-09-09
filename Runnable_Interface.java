//Since it is not possible to extend more than one class it is better to implement Runnable interface than
//extend Thread class
class Parallel implements Runnable{
    private int id;
    public Parallel(int x){
        this.id=x;
    }
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Thread id="+this.id);
        }
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
        }
    }
}
public class Runnable_Interface {
    public static void main(String[] args){
        Parallel[] p=new Parallel[5];
        Thread[] t=new Thread[5];//Make a thread t[i] from p[i]
        for(int i=0;i<5;i++){
            p[i]=new Parallel(i);
            t[i]=new Thread(p[i]);
            t[i].start();//Start of p[i].run 
        }
    }
}
