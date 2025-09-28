public class AnimalMain {
    public static void main(String[] args) {
        AnimalFactory af = new AnimalFactory();
        Animal dog = af.getAnimal("Dog");
        dog.eat();
        Animal cat = af.getAnimal("Cat");
        cat.eat();
    }
}
