package org.example.model;

import java.time.LocalDate;

public class HistoricoEntrega {
    private int id;
    private int entregaID;
    private LocalDate dataEvento;
    private String descricao;

    public HistoricoEntrega(int id, int entregaID, LocalDate dataEvento, String descricao){
        this.id = id;
        this.entregaID = entregaID;
        this.dataEvento = dataEvento;
        this.descricao = descricao;
    }
    public HistoricoEntrega(int entregaID, LocalDate dataEvento, String descricao){
        this.entregaID = entregaID;
        this.dataEvento = dataEvento;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEntregaID() {
        return entregaID;
    }

    public void setEntregaID(int entregaID) {
        this.entregaID = entregaID;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
