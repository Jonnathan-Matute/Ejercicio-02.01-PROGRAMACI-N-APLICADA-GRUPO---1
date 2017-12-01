/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.FileCA;

/**
 *
 * @author Pulpo
 */
public class GestionDato {
    private List<FileCA> fileCAList;

    public GestionDato(List<FileCA> fileList) {
        this.fileCAList = fileList;
    }

    public List<FileCA> getFileCAList() {
        return fileCAList;
    }

    public void setFileCAList(List<FileCA> fileList) {
        this.fileCAList = fileList;
    }
     
    public boolean addFileCA(FileCA fCA){
        return this.fileCAList.add(fCA);
    }
    
    
    
    
}
