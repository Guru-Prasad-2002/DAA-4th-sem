import java.util.Scanner;
class Knapsack_datatype{
    double[] weight,profit,ratio,sol_vector;
    double capacity;
    int n;
    Scanner sc=new Scanner(System.in);
    public Knapsack_datatype(){
        System.out.println("Enter no of elements");
        n=sc.nextInt();
        System.out.println("Enter capacity of knapsack");
        capacity=sc.nextInt();
        weight=new double[n+1];
        profit=new double[n+1];
        ratio=new double[n+1];
        sol_vector=new double[n+1];
        System.out.println("Enter the weights of the items");
        for(int i=1;i<=n;i++){
            weight[i]=sc.nextDouble();
        }
        System.out.println("Enter the profitss of the items");
        for(int i=1;i<=n;i++){
            profit[i]=sc.nextDouble();
        }
    }
    public int getNext(){
        int index=-1;
        double max=-1;
        for(int i=1;i<=n;i++){
            if(ratio[i]>max){
                max=ratio[i];
                index=i;
            }
        }
        return index;
    }
    public void fill(){
        double current_profit=0;
        double current_weight=0;
        for(int i=1;i<=n;i++){
            ratio[i]=profit[i]/weight[i];
        }
        while(current_weight<capacity){
            int index=getNext();
            if(index==-1){
                break;
            }
            if(current_weight+weight[index]<=capacity){
                sol_vector[index]=1;
                current_weight+=weight[index];
                current_profit+=profit[index];
                ratio[index]=0;
            }
            else{
                sol_vector[index]=(capacity-current_weight)/weight[index];
                current_profit+=ratio[index]*(capacity-current_weight);
                break;
            }
        }
        System.out.println("Max Profit="+current_profit);
        System.out.println("Solution Vector");
        for(int i=1;i<=n;i++){
            System.out.print(sol_vector[i]+"\t");
        }
    }
}
public class Knapsack_Greedy {
    public static void main(String[] args){
        Knapsack_datatype k=new Knapsack_datatype();
        k.fill();
    }
}
