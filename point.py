class point:
    def __init__(self,a=0,b=0): #init is a constructor
        self.x=a;               #constructor is automatically called when
        self.y=b;               #an object of a class is created
    def display(self):          #self is a default parameter which shud be passed 
        print("x=",self.x)      #to every function being declared
        print("y=",self.y)

p=point(10,20)
p.x=20                          #Syntax to create a object
p.display()                     #Syntax to call a function
#Python does not support Accesse Specifiers...so data can be accessed easily 
