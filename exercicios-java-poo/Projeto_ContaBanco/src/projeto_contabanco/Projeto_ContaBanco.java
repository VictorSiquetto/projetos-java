package projeto_contabanco;

public class Projeto_ContaBanco {

    public static void main(String[] args) {
        ContaBanco cb1 = new ContaBanco();
        cb1.setNumConta(12345);
        cb1.setDono("EU");
        cb1.abrirConta("cc");
        cb1.depositar(300.60f);
        cb1.status();
        cb1.sacar(140);
        cb1.pagarMensal();
        cb1.sacar(198.6f);
        cb1.fecharConta();
    }
    
}
