from abc import ABC, abstractmethod
# child classes can have concrete(non-abstract) methods too
class Car(ABC):
    def __init__(self,brand,yr):
        self.brand=brand
        self.yr=yr

    @abstractmethod
    def print_details(self,brand,yr):
        pass

    def acclerate(self):
        print("speedup")

class SuvCar(Car):
    def __init__(self,brand,yr):
        super().__init__(brand,yr)

    def print_details(self):
        print(self.brand,self.yr)
    
    def roof(self):
        print("suv has roof")

class BoxCar(Car):
    def __init__(self,brand,yr):
         super().__init__(brand,yr)

    def print_details(self):
        print(self.brand,self.yr)
    
    def roof(self):
        print("boxcar has roof")

    def milege(self):
        print("boxcar has milege")

s=SuvCar("suv",2000)
b=BoxCar("box",2023)
print(s.brand)
s.print_details()
b.print_details()
s.acclerate()
s.roof()
b.roof()
b.acclerate()
b.milege()
# s.milege() //SuvCar' object has no attribute 'milege'