public class Main {
    public static void main(String[] args) {

        Vent instVent1 = new Vent("Vent1", 200);
        System.out.println(instVent1);
        instVent1.tocar();
        Corda instCorda1 = new Corda("Corda1", 150);
        Percussio instPercussio1 = new Percussio("Percussio1", 170);
        instCorda1.tocar();
        instVent1.tocar();
        instPercussio1.tocar();
        instVent1.tocar();


    }
}
