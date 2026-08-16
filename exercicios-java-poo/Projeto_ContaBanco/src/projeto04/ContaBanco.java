package projeto04;

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
        }
       System.out.println("Conta aberta com sucesso");
   }
   
   public void fecharConta(){
       if (this.getSaldo() == 0){
           this.setStatus(false);
           System.out.println("Conta fechada com sucesso");
       }else if (this.getSaldo() < 0){
           System.out.println("ERRO, voce esta devendo");
       }else{
           System.out.println("ERRO, voce ainda tem dinheiro na conta");
       }
   }
   
   public void depositar(float d){
       if (this.isStatus()){
           this.setSaldo(this.getSaldo() + d); 
           System.out.println("Depósito realizado na conta de " + this.getDono());
       }else{
           System.out.println("ERRO, abra uma conta primeiro");
       }
   }
   
   public void sacar(float s){
       if (this.isStatus()){
           if (s <= this.getSaldo()){
               this.setSaldo(this.getSaldo() - s);
               System.out.println("Voce sacou " + s + ", seu novo saldo é " + this.getSaldo());
           }else{
               System.out.println("ERRO, saldo insuficiente");
           }
               }else{
           System.out.println("ERRO, abra uma conta primeiro");
       }
   }
   
   
   public void pagarMensal(){
       int v = 0;
       if (this.getTipo().equals("cc")){
           v = 12;
       }else if (this.getTipo().equals("cp")){
           v = 20;
       }
       if (this.isStatus()){
           if (this.getSaldo() > v){
               this.setSaldo(saldo - v);
               System.out.println("Mensalidade paga com sucesso por " + this.getDono());
           }else{
               System.out.println("ERRO, saldo insuficiente");
           }
       }else{
           System.out.println("ERRO, a conta nao esta aberta");
       }       

   }
   
   public void estadoAtual(){
       System.out.println("--------------------------------");
        System.out.println("NumConta: " + this.getNumConta());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.isStatus());
    }
}
