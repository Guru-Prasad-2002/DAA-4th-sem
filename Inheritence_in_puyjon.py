class Rectangle:
    def __init__(self,a=0,b=0):
        self.width=a
        self.height=b

    def area(self):
        print(self.width*self.height)
    
    def perimeter(self):
        print(2*(self.width+self.height))

class Square(Rectangle):
    def __init__(self, s=0):
        self.width=s
        self.height=s

S=Square(10)

S.area()
S.perimeter()

# class Rectangle:
#     def __init__(self,a=0,b=0):   #In this case private implementation is 
#         self.w=a                  #changed which will affect the code  
#         self.h=b

#     def area(self):
#         print(self.w*self.h)
    
#     def perimeter(self):
#         print(2*(self.w+self.h))

# class Square(Rectangle):
#     def __init__(self, s=0):
#         self.width=s
#         self.height=s

# S=Square(10)

# S.area()
# S.perimeter()

