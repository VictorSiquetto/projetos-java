package projeto04;

public class Projeto04 {

    public static void main(String[] args) {
        ContaBanco cb1 = new ContaBanco();
        cb1.setNumConta(12345);
        cb1.setDono("EU");
        cb1.abrirConta("cc");
        cb1.depositar(300);
        cb1.sacar(140);
        cb1.pagarMensal();
        cb1.sacar(198);
        cb1.fecharConta();
        cb1.estadoAtual();
    }
    
}
