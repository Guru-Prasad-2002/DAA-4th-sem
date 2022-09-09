class Parallel extends Thread{
    private int id;
    public Parallel(int x){
        this.id=x;
    }
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println("Thread id="+id);
        }
        try{
            sleep(1000);
        }catch(InterruptedException e){
        }
    }
}
class Test_Parallel{
    static Parallel[] arr;
    public static void main(String[] args){
        arr=new Parallel[5];
        for(int i=0;i<5;i++){
            arr[i]=new Parallel(i);
            arr[i].start();//Exceutes the threads in parallel
            // arr[i].run();//Does not execute the thread in parallel
        }
    }
}