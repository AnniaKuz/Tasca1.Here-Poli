public abstract class Noticia {

private String titular;
private String text;
private  int puntuacio;
private  int preu;

    public Noticia(String titular, String text, int puntuacio, int preu) {
        this.titular = titular;
        this.text = text;
        this.puntuacio = puntuacio;
        this.preu = preu;
    }

    public Noticia() {

    }

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public int getPreu() {
        return preu;
    }

    public void setPreu(int preu) {
        this.preu = preu;
    }

    public abstract int calcularPreu();
    public abstract int calcularPuntuacio();

    @Override
    public String toString() {
        return "Noticia{" +
                "titular='" + titular + '\'' +
                ", text='" + text + '\'' +
                ", puntuacio=" + puntuacio +
                ", preu=" + preu +
                '}';
    }
}
