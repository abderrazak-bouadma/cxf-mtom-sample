package com.abz.ws.sei;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: Utilistateur
 * Date: 13/06/13
 * Time: 16:30
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "SampleVO")
@XmlAccessorType(XmlAccessType.FIELD)
public class SampleVO {

    @XmlMimeType(value = "application/octet-stream")
    private DataHandler content;

    public DataHandler getContent() {
        return content;
    }

    public void setContent(DataHandler content) {
        this.content = content;
    }
}
