class mydate:
    def __init__(self,d,m,y):
        self.d=d
        self.m=m
        self.y=y
    def __str__ (self):
        return str(self.d)
    
class event:
    def __init__(self,dt,m,y,eve):
        self.dt=mydate(dt,m,y)
        self.eve=eve
    def __str__(self):
        return str(self.dt) +' '+str(self.eve)
    
e=event(12,11,2011,'hbd')
print(e)