package projetolivro;

public class ProjetoLivro {

    public static void main(String[] args) {
        Pessoa p[] = new Pessoa[2];
        Livro l[] = new Livro[3];
        
        p[0] = new Pessoa("Joao", 23, "M");
        p[1] = new Pessoa("Lucas", 19, "M");

        l[0] = new Livro("Turma da Monica", "Mauricio de Souza", 80, p[0]);
        l[1] = new Livro("Dom Quixote", "Miguel de Cervantes", 350, p[1]);
        l[2] = new Livro("O Pequeno Principe", "Antoine de Saint-Exupery", 240, p[0]);
        
        p[0].fazerAniver();
        l[0].abrir();
        l[0].folhear(55);
        l[0].avancarPag();
        System.out.println(l[0].detalhes());
        
        l[1].abrir();
        l[1].folhear(250);
        l[1].voltarPag();
        l[1].fechar();
        System.out.println("");
        System.out.println(l[1].detalhes());
    }
}
