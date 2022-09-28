public class F1 extends Noticia {
    private String escuderia;

    public F1(String titular, String text, int puntuacio, int preu, String escuderia) {
        super(titular, text, puntuacio, preu);
        this.escuderia = escuderia;
    }

    public F1() {

    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }
    public int calcularPreu(){
        int preuTotal = 0;
        preuTotal= super.getPreu();
        if(escuderia.equalsIgnoreCase("Ferrari") || escuderia.equalsIgnoreCase("Mercedes")){
            preuTotal = preuTotal + 50;
        }
        return preuTotal;
    }


    public int calcularPuntuacio(){
        int punts = 0;
        punts = super.getPuntuacio();
        if(escuderia.equalsIgnoreCase("Ferrari") || escuderia.equalsIgnoreCase("Mercedes")){
            punts = punts + 2;
        }
        return punts;
    }

    @Override
    public String toString() {
        return "F1{" +
                "titular='" + super.getTitular()+ '\'' +
                "} " + super.toString();
    }
}
