package com.abz.ws.sei;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;

/**
 * Created with IntelliJ IDEA.
 * User: Utilistateur
 * Date: 13/06/13
 * Time: 16:30
 * To change this template use File | Settings | File Templates.
 */
@WebService
public interface MtomSampleService {

    @WebMethod(operationName = "download")
    SampleVO downloadDocument();

    @WebMethod(operationName = "upload")
    String uploadDocument(@WebParam(name = "uFile") DataUploader uFile);
}
