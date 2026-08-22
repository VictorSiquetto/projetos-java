package projetopessoas;

public class Professor extends Pessoa{
    private String espec;
    private float salario;
    
    public void recerberAum(float v){
        this.salario += v;
    }

    public String getEspec() {
        return espec;
    }

    public void setEspec(String espec) {
        this.espec = espec;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
}
