import java.util.ArrayList;

public class Redactor {
    private String DNI;
    private String nom;
    private static int sou = 1500;
    private boolean isDNI = false;
    ArrayList<Noticia> noticias = new ArrayList<Noticia>();

    public Redactor(String DNI, String nom, boolean isDNI) {
        this.DNI = DNI;
        this.nom = nom;
        this.isDNI = isDNI;
    }

    public Redactor() {

    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        if(!isDNI){
            this.DNI = DNI;
            isDNI = true;
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static int getSou() {
        return sou;
    }

    public static void setSou(int sou) {
        Redactor.sou = sou;
    }
    public ArrayList<Noticia> getNoticia(){
        return this.noticias;
    }
    public void setNoticia(Noticia noticia){
        this.noticias.add(noticia);
    }

}
