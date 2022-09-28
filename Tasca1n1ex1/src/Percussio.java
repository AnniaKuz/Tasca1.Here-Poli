public class Percussio extends Intrument{

    public Percussio(String nom, int preu) {
        super(nom, preu);
    }
    {
        System.out.println("S'ha afegit instrument de percussio");
    }

    public  void tocar(){
        System.out.println("Esta sonant un instrument de percussio");
    }

    @Override
    public String toString() {
        return "Percussió{} "+getNom()+" "+getPreu();
    }
}
