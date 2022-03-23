/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.model;

/**
 *
 * @author Heflain
 */
public class PermissaoImagem {
    private boolean permitidoVisualizar;
    private boolean permitidoAplicarFiltro;
    private boolean permitidoExportar;
    private boolean permitidoExcluir;

    public PermissaoImagem(boolean permitidoVisualizar, boolean permitidoAplicarFiltro, boolean permitidoExportar, boolean permitidoExcluir) {
        this.permitidoVisualizar = permitidoVisualizar;
        this.permitidoAplicarFiltro = permitidoAplicarFiltro;
        this.permitidoExportar = permitidoExportar;
        this.permitidoExcluir = permitidoExcluir;
    }

    public boolean isPermitidoVisualizar() {
        return permitidoVisualizar;
    }

    public void setPermitidoVisualizar(boolean permitidoVisualizar) {
        this.permitidoVisualizar = permitidoVisualizar;
    }

    public boolean isPermitidoAplicarFiltro() {
        return permitidoAplicarFiltro;
    }

    public void setPermitidoAplicarFiltro(boolean permitidoAplicarFiltro) {
        this.permitidoAplicarFiltro = permitidoAplicarFiltro;
    }

    public boolean isPermitidoExportar() {
        return permitidoExportar;
    }

    public void setPermitidoExportar(boolean permitidoExportar) {
        this.permitidoExportar = permitidoExportar;
    }

    public boolean isPermitidoExcluir() {
        return permitidoExcluir;
    }

    public void setPermitidoExcluir(boolean permitidoExcluir) {
        this.permitidoExcluir = permitidoExcluir;
    }
    
}
