
/**
 * PetChecker creates two instances of pets of each type Snake, Bird, Cat, Dog, and Bat.
 * 
 *
 * @author Johnnie Meredith
 * @version 1
 */
public class PetChecker
{
    
    public PetChecker()
    {
        
    }

    
    public static void main(String[] args)
    {
        Snake snake = new Snake("Spike", true, false, "mice", false);
        Bird bird = new Bird("Flappy", false, false, "seed", true);
        Cat cat = new Cat("Mew", false, false, "tuna", false);
        Dog dog = new Dog("Good boi", false, false, "mice", false);
        Bat bat = new Bat("Bruce Wayne", false, true, "mice", true);
        
        Snake snake2 = new Snake();
        Bird bird2 = new Bird();
        Cat cat2 = new Cat();
        Dog dog2 = new Dog();
        Bat bat2 = new Bat();
        
        snake2.setName("sss");
        snake2.setPoisonous(true);
        snake2.setNocturnal(false);
        snake2.setFlies(false);
        snake2.setDiet("eggs");
        
        snake.getName();
        snake.getPoisonous();
        snake.getNocturnal();
        snake.getFlies();
        snake.getDiet();
        
        snake2.getName();
        snake2.getPoisonous();
        snake2.getNocturnal();
        snake2.getFlies();
        snake2.getDiet();
        
        bird2.setName("birby");
        bird2.setPoisonous(false);
        bird2.setNocturnal(true);
        bird2.setFlies(true);
        bird2.setDiet("bugs");
        
        bird.getName();
        bird.getPoisonous();
        bird.getNocturnal();
        bird.getFlies();
        bird.getDiet();
        
        bird2.getName();
        bird2.getPoisonous();
        bird2.getNocturnal();
        bird2.getFlies();
        bird2.getDiet();
        
        cat2.setName("Floofy");
        cat2.setPoisonous(false);
        cat2.setNocturnal(true);
        cat2.setFlies(false);
        cat2.setDiet("Meow Mix only");
        
        cat.getName();
        cat.getPoisonous();
        cat.getNocturnal();
        cat.getFlies();
        cat.getDiet();
        
        cat2.getName();
        cat2.getPoisonous();
        cat2.getNocturnal();
        cat2.getFlies();
        cat2.getDiet();
        
        dog2.setName("Maneater");
        dog2.setPoisonous(true);
        dog2.setNocturnal(true);
        dog2.setFlies(true);
        dog2.setDiet("HUMANS... BEWARE!!!");
        
        dog.getName();
        dog.getPoisonous();
        dog.getNocturnal();
        dog.getFlies();
        dog.getDiet();
        
        dog2.getName();
        dog2.getPoisonous();
        dog2.getNocturnal();
        dog2.getFlies();
        dog2.getDiet();
        
        bat2.setName("Squeaky");
        bat2.setPoisonous(false);
        bat2.setNocturnal(true);
        bat2.setFlies(true);
        bat2.setDiet("mosquitos");
        
        bat.getName();
        bat.getPoisonous();
        bat.getNocturnal();
        bat.getFlies();
        bat.getDiet();
        
        bat2.getName();
        bat2.getPoisonous();
        bat2.getNocturnal();
        bat2.getFlies();
        bat2.getDiet();
        
        
    }
}
