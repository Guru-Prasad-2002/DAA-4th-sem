#include<iostream>
using namespace std;

int main(){
    int a,b,c;
    cout<<"Enter no 1"<<endl;
    cin>>a;
    cout<<"Enter no 2"<<endl;
    cin>>b;
    cout<<"Enter no 3"<<endl;
    cin>>c;
    if(a>=b){
        if(a>=c){
            cout<<a;
            return 1;
        }
        else{
            cout<<c;
            return 1;
        }
    }
    else{
        cout<<b;
        return 1;
    }
    
}
