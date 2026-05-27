/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class Dispositivo {
    private int id;
    private String nome;
    private String comodo;
    private String marca;
    private double potencia;
    private double horasUso;
    private int voltagem;
    private String status;
    private double consumoMensal;
    private String observacao;

    public int getId() { 
        return id; 
    }
    
    public void setId(int id) { 
        this.id = id; 
    }

    public String getNome() { 
        return nome; 
    }
    
    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public String getComodo() { 
        return comodo; 
    }
    
    public void setComodo(String comodo) { 
        this.comodo = comodo; 
    }

    public String getMarca() { 
        return marca; 
    }
    
    public void setMarca(String marca) { 
        this.marca = marca; 
    }

    public double getPotencia() { 
        return potencia; 
    }
    
    public void setPotencia(double potencia) { 
        this.potencia = potencia; 
    }

    public double getHorasUso() { 
        return horasUso; 
    }
    
    public void setHorasUso(double horasUso) { 
        this.horasUso = horasUso; 
    }

    public int getVoltagem() { 
        return voltagem; 
    }
    
    public void setVoltagem(int voltagem) { 
        this.voltagem = voltagem; 
    }

    public String getStatus() { 
        return status; 
    }
    
    public void setStatus(String status) { 
        this.status = status; 
    }

    public double getConsumoMensal() { 
        return consumoMensal; 
    }
    
    public void setConsumoMensal(double consumoMensal) { 
        this.consumoMensal = consumoMensal; 
    }

    public String getObservacao() { 
        return observacao; 
    }
    
    public void setObservacao(String observacao) { 
        this.observacao = observacao; 
    }
}
