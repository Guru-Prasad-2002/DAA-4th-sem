import java.util.Scanner;
import java.util.Random;
public class QuickSort {
    static int[] arr;
    public static void quicksort(int low,int high){
        if(low<high){
            int j=partition(low,high);
            quicksort(low, j-1);
            quicksort(j+1, high);
        }
    }
    public static int partition(int low,int high){
        int i=low,j=high;
        int pivot=arr[low];
        while(i<high && j>low){
            while(i<high && arr[i]<=pivot){
                i=i+1;
            }
            while(j>low && arr[j]>=pivot){
                j=j-1;
            }
            if(i<j){
                swap(i, j);
            }
            else{
                break;
            }
        }
        swap(low,j);
        return j;
    }
    public static void swap(int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n=sc.nextInt();
        arr=new int[n];
        Random r=new Random();
        for(int i=0;i<n;i++){
            arr[i]=r.nextInt(200);
        }
        long start=System.nanoTime();
        quicksort(0,n-1);
        long end=System.nanoTime();
        System.out.println("Sorted Array is ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
        System.out.println("Time Taken="+(end-start));
        sc.close();
    }
}
