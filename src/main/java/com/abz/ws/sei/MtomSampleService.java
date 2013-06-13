package com.abz.ws.sei;

import javax.jws.WebMethod;
import javax.jws.WebService;

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
}
