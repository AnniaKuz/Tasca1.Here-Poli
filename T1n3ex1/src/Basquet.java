public class Basquet extends Noticia{
    private String competicio;
    private String club;
    private boolean isEurolliga = false;

    public Basquet(String titular, String text, int puntuacio, int preu, String competicio, String club, boolean isEurolliga) {
        super(titular, text, puntuacio, preu);
        this.competicio = competicio;
        this.club = club;
        this.isEurolliga = isEurolliga;
    }

    @Override
    public String toString() {
        return "Basquet{" +
                "titular='" + super.getTitular() + '\'' +
                "} " + super.toString();
    }

    public Basquet() {

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

    public boolean isEurolliga() {
        return isEurolliga;
    }

    public void setEurolliga(boolean eurolliga) {
        isEurolliga = eurolliga;
    }

    public int calcularPreu(){
        int preuTotal = 0;
        preuTotal = super.getPreu();
        if(isEurolliga==true){
            preuTotal = preuTotal + 75;
        }
        if(this.club.equalsIgnoreCase("Madrid")||this.club.equalsIgnoreCase("Barça")){
            preuTotal = preuTotal + 75;
        }
        return preuTotal;

    }

    @Override
    public int calcularPuntuacio() {
        int punts = 0;
        punts = super.getPuntuacio();
        if(this.competicio.equalsIgnoreCase("ACB")){
            punts = punts + 2;
        }
        if(isEurolliga==true){
            punts = punts + 3;
        }
        if(this.club.equalsIgnoreCase("Madrid")||this.club.equalsIgnoreCase("Barça")){
            punts = punts + 1;
        }
        return punts;
    }

}
