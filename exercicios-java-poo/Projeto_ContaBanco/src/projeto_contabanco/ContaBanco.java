package projeto_contabanco;

public class ContaBanco {
   public int numConta;
   protected String tipo;
   private String dono;
   private float saldo;
   private boolean status;

    public ContaBanco() {
        this.saldo = 0;
        this.status = false;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo.equals("cc") || tipo.equals("cp")){
            this.tipo = tipo;
        }else{
            this.tipo = "ERRO, tipo invalido";
        }    
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
   
   public void abrirConta(String t){
       this.setTipo(t);
       this.setStatus(true);
       if (this.getTipo().equals("cc")){
           this.setSaldo(50);
        }else if (this.getTipo().equals("cp")){
           this.setSaldo(150);
        }else{
        }
   }
   
   public void fecharConta(){
       if (this.getSaldo() == 0){
           System.out.println("Conta fechada com sucesso");
           this.setStatus(false);
       }else if (this.getSaldo() < 0){
           System.out.println("ERRO, voce esta devendo");
       }else{
           System.out.println("ERRO, voce ainda tem dinheiro na conta");
       }
   }
   
   public float depositar(float d){
       if (this.isStatus() == true){
           this.setSaldo(this.getSaldo() + d); 
       }else{
           System.out.println("ERRO, abra uma conta primeiro");
       }
       return saldo;
   }
   
   public float sacar(float s){
       if (this.isStatus() == true){
           if (s <= this.getSaldo()){
               this.setSaldo(this.getSaldo() - s);
               System.out.println("Voce sacou " + s + ", seu novo saldo é " + this.getSaldo());
           }else{
               System.out.println("ERRO, saldo insuficiente");
           }
               }else{
           System.out.println("ERRO, abra uma conta primeiro");
       }
       return saldo;
   }
   
   
   public float pagarMensal(){
       float v = 0;
       if (this.getTipo().equals("cc")){
           v = 12;
       }else if (this.getTipo().equals("cp")){
           v = 20;
       }
       if (this.isStatus() == true){
           if (this.getSaldo() > v){
               this.setSaldo(saldo - v);
           }else{
               System.out.println("ERRO, saldo insuficiente");
           }
       }else{
           System.out.println("ERRO, a conta nao esta aberta");
       }       
       return saldo;
   }
   
   public void status(){
        System.out.println("NumConta: " + this.getNumConta());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.isStatus());
    }
}
