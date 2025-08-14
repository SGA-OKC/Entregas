package org.example.model;

import java.sql.Date;

public class Entrega {
    private int id;
    private int pedidoID;
    private int motoristaID;
    private Date dataSaida;
    private Date dataEntrega;
    private boolean Status;

    public Entrega(int id, int pedidoID,int motoristaID, Date dataSaida, Date dataEntrega){
        this.id = id;
        this.pedidoID = pedidoID;
        this.motoristaID = motoristaID;
        this.dataSaida = dataSaida;
        this.dataEntrega = dataEntrega;
        this.Status = true;
    }
    public Entrega(int pedidoID,int motoristaID, Date dataSaida, Date dataEntrega){
        this.pedidoID = pedidoID;
        this.motoristaID = motoristaID;
        this.dataSaida = dataSaida;
        this.dataEntrega = dataEntrega;
        this.Status = true;
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

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }
}
