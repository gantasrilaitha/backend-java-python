package classes_and_objects;

public class Box {
    int ht, wt;

    public Box() {
        ht = 0;
        wt = 0; // default constructor(to be specified if other constructors are mentioned)
    }

    public Box(int h, int w) { // parametrised constructor
        this.ht = h; // (or) ht=h
        this.wt = w; // (or) wt=w
    }

    public Box(Box b) { // Cpoy constructor -that takes objects ,creates & returns copy of existing
        // object
        ht = b.ht;
        wt = b.wt;
    }

    public int volume() {
        return ht * wt;
    }
}
