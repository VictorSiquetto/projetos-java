package projeto03;

public class Projeto03 {

    public static void main(String[] args) {
       Caneta c1 = new Caneta("BIC", "Preta", 0.7f);
       c1.setTampada(true);
       c1.status();
       Caneta c2 = new Caneta("PIC", "Vermelha", 0.5f);
       c2.status();
    }
    
}
