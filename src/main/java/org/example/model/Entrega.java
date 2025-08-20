package org.example.model;

import java.time.LocalDate;

public class Entrega {
    private int id;
    private int pedidoID;
    private int motoristaID;
    private LocalDate dataSaida;
    private LocalDate dataEntrega;
    private StatusEntrega statusEntrega;

    public Entrega(int id, int pedidoID,int motoristaID, LocalDate dataSaida, StatusEntrega statusEntrega){
        this.id = id;
        this.pedidoID = pedidoID;
        this.motoristaID = motoristaID;
        this.dataSaida = dataSaida;
        this.statusEntrega = statusEntrega;
    }
    public Entrega(int pedidoID,int motoristaID, LocalDate dataSaida, StatusEntrega statusEntrega){
        this.pedidoID = pedidoID;
        this.motoristaID = motoristaID;
        this.dataSaida = dataSaida;
        this.statusEntrega = statusEntrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public int getMotoristaID() {
        return motoristaID;
    }

    public void setMotoristaID(int motoristaID) {
        this.motoristaID = motoristaID;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public StatusEntrega getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(StatusEntrega statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

}
