public class Vent extends Intrument{
    public Vent(String nom, int preu) {
        super(nom, preu);

    }
    public Vent() {
        super();
    }
    {
        System.out.println("S'ha afegit instrument de corda");
    }

    public void tocar(){
        System.out.println("Esta sonant un instrument de vent");
    }

    @Override
    public String toString() {
        return "Vent{} "+getNom()+" "+getPreu();
    }
}
