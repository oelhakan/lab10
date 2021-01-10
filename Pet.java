public class Pet extends LivingCreature {
    private MovementType mt;
    private boolean isDog;

    public Pet(String id, int year,boolean isDog, MovementType mt) {
        super(id, year);
        this.isDog = isDog;
        this.mt = mt;
    }

    private String ifDog(){
        if(isDog){
            return "The Pet Is A Dog.";
        }else{
            return "";
        }
    }

    public String toString(){
        return "Name : " + super.getName() + "\n" + "Age : " + super.getAge() + "\n" + "Movement Type : " + mt.name() + "\n"
                + ifDog();
    }


}
//    Remarks:
//    A pet knows only one way of moving.
//    The method toString must extensively describe a pet object. Add all necessary fields and methods.
