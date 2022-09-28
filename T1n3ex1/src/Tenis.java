public class Tenis extends Noticia{
    private String competicio;
    private String jugador1;
    private String jugador2;

    public Tenis(String titular, String text, int puntuacio, int preu, String competicio, String jugador1, String jugador2) {
        super(titular, text, puntuacio, preu);
        this.competicio = competicio;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public Tenis() {

    }

    public String getCompeticio() {
        return competicio;
    }

    public void setCompeticio(String competicio) {
        this.competicio = competicio;
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public int calcularPuntuacio(){
        int punts = 0;
        punts = super.getPuntuacio();
        if(this.jugador1.equalsIgnoreCase("Federer")||this.jugador1.equalsIgnoreCase("Nadal")||
        this.jugador1.equalsIgnoreCase("Djokovic")||this.jugador2.equalsIgnoreCase("Federer")||
                this.jugador2.equalsIgnoreCase("Nadal")||
                this.jugador2.equalsIgnoreCase("Djokovic")){
            punts = punts + 3;
        }
        return punts;
    }
    public int calcularPreu(){
        int preuTotal = 0;
        preuTotal = super.getPreu();
        if(this.jugador1.equalsIgnoreCase("Federer")||this.jugador1.equalsIgnoreCase("Nadal")||
                this.jugador1.equalsIgnoreCase("Djokovic")||this.jugador2.equalsIgnoreCase("Federer")||
                this.jugador2.equalsIgnoreCase("Nadal")||
                this.jugador2.equalsIgnoreCase("Djokovic")){
            preuTotal = preuTotal + 100;
        }
        return preuTotal;
    }

    @Override
    public String toString() {
        return "Tenis{" +
                "titular='" + super.getTitular() + '\'' +
                "} " + super.toString();
    }
}
