public class Telephone {
    private String marca;
    private String model;

    public Telephone(String marca, String model) {
        this.marca = marca;
        this.model = model;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void trucar(String numTel){
        System.out.println("Estàs trucant a " +numTel);
    }
}


