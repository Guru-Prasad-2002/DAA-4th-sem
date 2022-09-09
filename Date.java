public class Date{
    private int d;
    private int m;
    private int y;
    public Date(int a,int b,int c){
        this.d=a;
        this.m=b;
        this.y=c;
    }
    public void display(){
        System.out.println(this.d+" "+this.m+" "+this.y);
    }
    public void update(){
        this.d=this.d+1;
        System.out.println(this.d+" "+this.m+" "+this.y);
    }
    public static void main(String[]args){
        Date d;
        d=new Date(10,11,2002);
        d.display();
        d.update();
        d.display();
    } 
}



// Static members does not need any object to accesse it...can directly be accessed by class
// static method cannot accesse non static variables
// Non static method needs an object to accesse it...Non static method can accesse both static and 
// non static keyword
// Objects cannot accesse static functions 