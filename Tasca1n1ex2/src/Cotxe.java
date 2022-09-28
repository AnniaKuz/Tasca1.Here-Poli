public class Cotxe {
    private static final String marca = "Adi";
    private static int model;
    private final int potencia = 60;

    public Cotxe() {
    }
    {
        System.out.println("S'ha afegit un cotxe");
    }
    public static int getModel() {
        return model;
    }

    public static void setModel(int model) {
        Cotxe.model = model;
    }

    public int getPotencia() {
        return potencia;
    }

    public static void frenar(){
        System.out.println("El vehicle està frenant");
    }

    public void accelerar(){
        System.out.println("El vehicle està accelerant");
    }
}
