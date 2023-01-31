public class Current_Thread {
    public static void main(String[] args){
        Thread t=Thread.currentThread();
        System.out.println(t.isAlive());
        System.out.println("Name of the thread="+t.getName());
        t.setName("Second name");
        System.out.println("Name after changing="+t.getName());
        try{
            for(int i=1;i<=5;i++){
                System.out.println(i);
                System.out.println(t.isAlive());
                Thread.sleep(1000);
                System.out.println(t.isAlive());
            }
        }catch(InterruptedException e){
            System.out.println("Main Thread Interrupted");
            System.out.println(t.isAlive());
        }
    }    
}
