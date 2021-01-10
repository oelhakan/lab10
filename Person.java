public class Person extends LivingCreature implements MentalSkills {

    private String skills = "";

    private MovementType moves[] = new MovementType[MovementType.values().length];

    public Person(String id, int year, String skills) {
        super(id, year);
        if (skillsCheck(skills)) {
            this.skills = skills;
        } else
            throw new IllegalArgumentException("INVALID VALUE : SKILLS");
    }

    @Override
    public String toString() {
        return "Name : " + super.getName() + "\nAge : " + super.getAge() + "\n" + skillsToString(this.getSkills())
                + "\n" + this.getMovements();
    }

    @Override
    public boolean canRead() {
        return this.can('R');
    }

    @Override
    public boolean canWrite() {
        return this.can('W');
    }

    @Override
    public boolean canSing() {
        return this.can('S');
    }

    private boolean can(char x) {
        int i = 0;
        while (i < this.getSkills().length()) {
            if (this.getSkills().charAt(i) == x)
                return true;
        }
        return false;
    }

    private boolean skillsCheck(String string) {
        if (!isProper(string)) {
            return false;
        } else
            return true;
    }

    private boolean isProper(String str) {

        if (str.length() == 1) {
            if (str.equals("R"))
                return true;
            if (str.equals("W"))
                return true;
            if (str.equals("S"))
                return true;
        }

        if (str.length() == 2) {
            if (str.contains("R") && str.contains("W"))
                return true;
            if (str.contains("S") && str.contains("W"))
                return true;
            if (str.contains("R") && str.contains("S"))
                return true;
        }

        if (str.length() == 3) {
            if (str.contains("R") && str.contains("W") && str.contains("S"))
                return true;
        }

        return false;

    }

    public String getSkills() {
        return this.skills;
    }

    public String skillsToString(String skills) {

        String string = "Skills :  ";
        if (skills.contains("R"))
            string += "\nREAD ";
        if (skills.contains("W"))
            string += "\nWRITE ";
        if (skills.contains("S"))
            string += "\nSING ";
        if(skills == null){
            string += "\nNONE";
        }

        return string;
    }

    public void addMovementType(MovementType mt) {

        int duplicateMovementCheck = 0;
        for (MovementType t : moves) {
            if (t == mt) {
                duplicateMovementCheck++;
            }
        }
        if (duplicateMovementCheck == 0) {
            moves[findEmptyIndex(moves)] = mt;
            System.out.println("ADDED MOVEMENT TYPE!");
        } else
            throw new IllegalArgumentException("DUPLICATED MOVEMENT TYPE - ERROR!");

    }

    private int findEmptyIndex(MovementType[] arr) {

        int index = 0;
        for (int i = arr.length - 1; i > -1; i--) {
            if (arr[i] == null) {
                index = i;
            }
        }
        return index;
    }


    private MovementType[] getMovementArray() {
        return this.moves;
    }

    private String getMovements() {
        String string = "";
        for (MovementType x : this.getMovementArray()) {
            if (x != null) {
                string += x.name()+ "\n";
            }
        }

        return "Movement Types : " + "\n" + string;
    }
}