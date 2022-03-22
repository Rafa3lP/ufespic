/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.ufespic.service;

import br.ufes.ufespic.dao.IImagemDAO;
import br.ufes.ufespic.dao.ImagemDaoFactory;
import br.ufes.ufespic.model.ImagemProxy;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class ImagemService {
    private IImagemDAO imagemdao;
    private List<ImagemProxy> imagensDaPasta;
    private static ImagemService instancia = null;

    private ImagemService() {
        this.imagemdao = new ImagemDaoFactory().criar("sqlite");
        lerImagensDaPasta();
    }
    
    private void lerImagensDaPasta(){
        imagensDaPasta = imagemdao.getImagens();
    }
    
    public static ImagemService getInstancia(){
        if(instancia == null) {
            instancia = new ImagemService();
        }
        return instancia;
    }

    public List<ImagemProxy> getImagensDaPasta() {
        return imagensDaPasta;
    }
    
    
    
}
