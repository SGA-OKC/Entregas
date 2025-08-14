package org.example.model;

import java.sql.Date;
import java.time.LocalDate;

public class Pedido {
    private int id;
    private int clienteID;
    private LocalDate dataPedido;
    private int volumeM3;
    private double pesoKG;
    private boolean status;

    public Pedido(int id, int clienteID, LocalDate dataPedido, int volumeM3, double pesoKG){
        this.id = id;
        this.clienteID = clienteID;
        this.dataPedido = dataPedido;
        this.volumeM3 = volumeM3;
        this.pesoKG = pesoKG;
        this.status = true;
    }

    public Pedido(int clienteID, LocalDate dataPedido, int volumeM3, double pesoKG){
        this.clienteID = clienteID;
        this.dataPedido = dataPedido;
        this.volumeM3 = volumeM3;
        this.pesoKG = pesoKG;
        this.status = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public int getVolumeM3() {
        return volumeM3;
    }

    public void setVolumeM3(int volumeM3) {
        this.volumeM3 = volumeM3;
    }

    public double getPesoKG() {
        return pesoKG;
    }

    public void setPesoKG(double pesoKG) {
        this.pesoKG = pesoKG;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
