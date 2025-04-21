package AB.GameElements;

public interface Character2 {

    public static final String name = "I'm a character of a game The Legend od Zelda!";

    public void makeSound();

    // usage of static method with staic variable in the interface
    public static void whoAreYou() {
        System.out.println(name);
    }

}
