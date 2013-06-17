package com.abz.ws.service;

import com.abz.ws.sei.DataUploader;
import com.abz.ws.sei.MtomSampleService;
import com.abz.ws.sei.SampleVO;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.jws.WebService;
import javax.mail.util.ByteArrayDataSource;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;
import java.io.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Utilistateur
 * Date: 13/06/13
 * Time: 16:43
 * To change this template use File | Settings | File Templates.
 */

@WebService(endpointInterface = "com.abz.ws.sei.MtomSampleService", portName = "MtomPort", targetNamespace = "MtomTarget")
public class MtomSampleServiceImpl implements MtomSampleService {
    @Override
    public SampleVO downloadDocument() {

        //
        SampleVO sampleVO = new SampleVO();

        //
        DataSource ds = null;
        try {
            InputStream inputStream = new FileInputStream(loadPdf());
            ds = new ByteArrayDataSource(inputStream, "application/pdf");
            sampleVO.setContent(new DataHandler(ds));
        } catch (Exception e) {
            SOAPFault fault = null;
            try {
                fault = SOAPFactory.newInstance().createFault();
                fault.setFaultString(e.getMessage());
                fault.setFaultCode(new QName("URI_NS_SOAP_ENVELOPE", "Server"));
                throw new SOAPFaultException(fault);
            } catch (SOAPException e1) {
                throw new RuntimeException(e1);
            }
        }
        return sampleVO;
    }

    @Override
    public String uploadDocument(DataUploader uFile) {
        try {
            //
            DataHandler handler = uFile.getDocument();
            InputStream inputStream = handler.getInputStream();

            //
            File tmp = File.createTempFile(uFile.getFilename(),".pdf");
            FileOutputStream outputStream = new FileOutputStream(tmp);

            //
            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while((bytesRead=inputStream.read(buffer)) != -1) {
                outputStream.write(buffer,0,bytesRead);
            }

            //
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            SOAPFault fault = null;
            try {
                fault = SOAPFactory.newInstance().createFault();
                fault.setFaultString("Server Side Error : impossible to create a temporary file.\r\n" + e.getMessage());
                throw new SOAPFaultException(fault);
            } catch (SOAPException e1) {
                throw new RuntimeException(e1);
            }
        }
        return new Date().toString();
    }

    private File loadPdf() {
        return new File("c:/paas.pdf");
    }
}
