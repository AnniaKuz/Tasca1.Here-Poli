public class Futbol extends Noticia{
    private String competicio;
    private String club;
    private String jugador;
    private boolean lligaChampions = false;

    public Futbol(String titular, String text, int puntuacio, int preu, String competicio, String club, String jugador, boolean lligaChampions) {
        super(titular, text, puntuacio, preu);
        this.competicio = competicio;
        this.club = club;
        this.jugador = jugador;
        this.lligaChampions = lligaChampions;

    }

    public Futbol() {
        super();
    }

    public String getCompeticio() {
        return competicio;
    }

    public void setCompeticio(String competicio) {
        this.competicio = competicio;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public boolean isLligaChampions() {
        return lligaChampions;
    }

    public void setLligaChampions(boolean lligaChampions) {
        this.lligaChampions = lligaChampions;
    }

   @Override
    public int calcularPreu() {
        int preuTotal = 0;
        preuTotal = super.getPreu();
        if(isLligaChampions()==true){
            preuTotal = preuTotal + 100;
        }
        if(this.club.equalsIgnoreCase("Madrid")||this.club.equalsIgnoreCase("Barça")){
            preuTotal = preuTotal + 100;
        }
        if(jugador.equalsIgnoreCase("Ferran Torres") || jugador.equalsIgnoreCase("Benzema")){
            preuTotal = preuTotal + 50;
        }
        return preuTotal;
    }

    @Override
    public int calcularPuntuacio() {
        int punts = 0;
        punts = super.getPuntuacio();
        if(this.competicio.equalsIgnoreCase("lliga")) {
            punts = punts + 2;
        }
        if(isLligaChampions() == true) {
            punts = punts + 3;
        }
        if(this.club.equalsIgnoreCase("Madrid") || this.club.equalsIgnoreCase("Barça")){
            punts = punts + 1;
        }
        if(this.jugador.equalsIgnoreCase("Ferran Torres") || this.jugador.equalsIgnoreCase("Benzema")){
            punts = punts + 1;
        }
        return punts;
    }

    @Override
    public String toString() {
        return "Futbol{" +
                "titular='" + super.getTitular() + '\'' +
                "} " + super.toString();
    }
}
