package ultraemojicombat;

public class UltraEmojiCombat {

    public static void main(String[] args) {
        Lutador l[] = new Lutador[6];
             
        l[0] = new Lutador("Lucas", "Espanha", 29, 1.78f, 68.9f, 11, 2, 1);
        l[1] = new Lutador("Carlos", "Brasil", 31, 1.68f, 57.8f, 14, 2, 3);
        l[2] = new Lutador("Joao", "Franca", 27, 1.66f, 80.9f, 12, 5, 1);
        l[3] = new Lutador("Afonso", "EUA", 34, 1.93f, 81.6f, 8, 1, 0);
        l[4] = new Lutador("Felipe", "Uruguai", 26, 1.82f, 119.3f, 10, 3, 3);
        l[5] = new Lutador("Pedro", "Japao", 37, 1.75f, 105.7f, 15, 0, 2);
        
        l[4].perderLuta();
        l[4].ganharLuta();
        l[4].status();
    }
    
}
