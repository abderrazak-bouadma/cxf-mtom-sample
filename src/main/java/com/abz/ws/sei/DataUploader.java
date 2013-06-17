package com.abz.ws.sei;

import javax.activation.DataHandler;

/**
 * Created with IntelliJ IDEA.
 * User: Utilistateur
 * Date: 17/06/13
 * Time: 16:40
 * To change this template use File | Settings | File Templates.
 */

public class DataUploader {

    private String filename;


    private DataHandler document;

    public DataHandler getDocument() {
        return document;
    }

    public void setDocument(DataHandler document) {
        this.document = document;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
