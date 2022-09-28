public class Motociclisme extends Noticia{
    private String equip;

    public Motociclisme(String titular, String text, int puntuacio, int preu, String equip) {
        super(titular, text, puntuacio, preu);
        this.equip = equip;
    }

    public Motociclisme() {

    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }
    public int calcularPreu(){
        int preuTotal = 0;
        preuTotal = super.getPreu();
        if(equip.equalsIgnoreCase("Honda")||equip.equalsIgnoreCase("Yamaha")){
            preuTotal = preuTotal + 50;
        }
        return preuTotal;
    }

    public int calcularPuntuacio(){
        int punts = 0;
        punts = super.getPuntuacio();
        if(equip.equalsIgnoreCase("Honda")||equip.equalsIgnoreCase("Yamaha")){
            punts = punts + 3;
        }
        return punts;
    }

    @Override
    public String toString() {
        return "Motociclisme{" +
                "titular='" + super.getTitular() + '\'' +
                "} " + super.toString();
    }
}
