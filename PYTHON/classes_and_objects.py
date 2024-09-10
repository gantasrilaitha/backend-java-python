class Box:
    def __init__(self,h=0,w=0,otherbox=None): # h & w are now default arguments #Box.__init__(b1) implicitly
        if otherbox:
            h=otherbox.ht
            w=otherbox.wt
        self.ht=h
        self.wt=w
        
    def volume(self):
        return self.ht*self.wt
b1=Box(2,3)#parametrised constructor
b2=Box()#default constructor since arguments are made default
b3=Box(0,0,b1) # Copy constructor
print("b1 is",b1.__dict__,"volume of b1", b1.volume())
print("b2 is",b2.__dict__,"volume of b2", b2.volume())
print("b3 is",b3.__dict__,"volume of b3", b3.volume())
