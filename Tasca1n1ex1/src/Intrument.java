public abstract class Intrument {
    private String nom;
    private int preu;

    public Intrument(String nom, int preu) {
        this.nom = nom;
        this.preu = preu;
    }
    public Intrument() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPreu() {
        return preu;
    }

    public void setPreu(int preu) {
        this.preu = preu;
    }

    public  abstract void tocar();
    static{
        System.out.println("Silenci, si us plau. L'espectacle esta a punt de començar");
    }

    @Override
    public abstract String toString();
}
