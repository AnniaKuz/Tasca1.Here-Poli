public class Corda extends Intrument{

    public Corda(String nom, int preu) {
        super(nom, preu);
    }
    {
        System.out.println("S'ha afegit un instrument de corda");
    }

    public void tocar(){
        System.out.println("Esta sonant un instrument de corda");
    }

    @Override
    public String toString() {
        return "Corda{} "+getNom()+" "+getPreu();
    }

}
