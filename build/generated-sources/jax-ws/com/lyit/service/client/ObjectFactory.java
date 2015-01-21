
package com.lyit.service.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lyit.service.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetLyitFlightCheckerboardArrayResponse_QNAME = new QName("http://service.flight.lyit.com/", "getLyitFlightCheckerboardArrayResponse");
    private final static QName _GetLyitFlightCheckerboardArray_QNAME = new QName("http://service.flight.lyit.com/", "getLyitFlightCheckerboardArray");
    private final static QName _LyitFlightCheckerboard_QNAME = new QName("http://service.flight.lyit.com/", "lyitFlightCheckerboard");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lyit.service.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLyitFlightCheckerboardArray }
     * 
     */
    public GetLyitFlightCheckerboardArray createGetLyitFlightCheckerboardArray() {
        return new GetLyitFlightCheckerboardArray();
    }

    /**
     * Create an instance of {@link LyitFlightCheckerboard }
     * 
     */
    public LyitFlightCheckerboard createLyitFlightCheckerboard() {
        return new LyitFlightCheckerboard();
    }

    /**
     * Create an instance of {@link GetLyitFlightCheckerboardArrayResponse }
     * 
     */
    public GetLyitFlightCheckerboardArrayResponse createGetLyitFlightCheckerboardArrayResponse() {
        return new GetLyitFlightCheckerboardArrayResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLyitFlightCheckerboardArrayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.flight.lyit.com/", name = "getLyitFlightCheckerboardArrayResponse")
    public JAXBElement<GetLyitFlightCheckerboardArrayResponse> createGetLyitFlightCheckerboardArrayResponse(GetLyitFlightCheckerboardArrayResponse value) {
        return new JAXBElement<GetLyitFlightCheckerboardArrayResponse>(_GetLyitFlightCheckerboardArrayResponse_QNAME, GetLyitFlightCheckerboardArrayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLyitFlightCheckerboardArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.flight.lyit.com/", name = "getLyitFlightCheckerboardArray")
    public JAXBElement<GetLyitFlightCheckerboardArray> createGetLyitFlightCheckerboardArray(GetLyitFlightCheckerboardArray value) {
        return new JAXBElement<GetLyitFlightCheckerboardArray>(_GetLyitFlightCheckerboardArray_QNAME, GetLyitFlightCheckerboardArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LyitFlightCheckerboard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.flight.lyit.com/", name = "lyitFlightCheckerboard")
    public JAXBElement<LyitFlightCheckerboard> createLyitFlightCheckerboard(LyitFlightCheckerboard value) {
        return new JAXBElement<LyitFlightCheckerboard>(_LyitFlightCheckerboard_QNAME, LyitFlightCheckerboard.class, null, value);
    }

}
