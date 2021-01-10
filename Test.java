public class Test {

    public static double averagePeopleAge(LivingCreature[] arr) {

        double sumOfAges = 0;
        double numberOfPeople = 0;

        for (LivingCreature x : arr) {
            if (x instanceof Person) {
                sumOfAges += x.getAge();
                numberOfPeople++;
            }
        }
        return sumOfAges / numberOfPeople;
    }

    public static double averagePetAge(LivingCreature[] arr) {

        int sumOfAges = 0;
        int numberOfPets = 0;

        for (LivingCreature x : arr) {
            if (x instanceof Pet) {
                sumOfAges += x.getAge();
                numberOfPets++;
            }
        }
        return sumOfAges / numberOfPets;
    }

    public static void main(String[] args) {
        Person Onur = new Person("Onur", 2001, "RW");
        Person Aiden = new Person("Aiden", 1990, "S");
        Person Marvin = new Person("Marvin", 1980, "R");
        Person Tanya = new Person("Tanya", 1970, "RW");
        Person Beatrice = new Person("Beatrice", 1998, "RW");

        Onur.addMovementType(MovementType.WALK);
        Onur.addMovementType(MovementType.CRAWL);
        Onur.addMovementType(MovementType.JUMP);

        System.out.println(Onur.toString());

        Pet Cat = new Pet("Cat", 2015, false, MovementType.WALK);
        Pet Fish = new Pet("Fish", 2021, false, MovementType.SWIM);
        Pet Dog = new Pet("Dog", 2015, true, MovementType.RUN);
        Pet Turtle = new Pet("Turtle", 1990, false, MovementType.CRAWL);
        Pet Goat = new Pet("Goat", 2018, false, MovementType.WALK);

        System.out.println(Cat.toString());

        LivingCreature[] array = new LivingCreature[10];
        array[0] = Onur;
        array[1] = Aiden;
        array[2] = Marvin;
        array[3] = Tanya;
        array[4] = Beatrice;
        array[5] = Cat;
        array[6] = Fish;
        array[7] = Dog;
        array[8] = Turtle;
        array[9] = Goat;

        System.out.println(averagePeopleAge(array));
        System.out.println(averagePetAge(array));

    }

}
