public class AnimalFactory {
    public Animal getAnimal(String animal) {
        if (animal == "Dog") {
            return new Dog();
        }
        if (animal == "Cat") {
            return new Cat();
        }
        return null;
    }

}
