
package cn.com.zysoft;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.com.zysoft package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.com.zysoft
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CallInterface }
     * 
     */
    public CallInterface createCallInterface() {
        return new CallInterface();
    }

    /**
     * Create an instance of {@link CallInterfaceFault }
     * 
     */
    public CallInterfaceFault createCallInterfaceFault() {
        return new CallInterfaceFault();
    }

    /**
     * Create an instance of {@link CallInterfaceResponse }
     * 
     */
    public CallInterfaceResponse createCallInterfaceResponse() {
        return new CallInterfaceResponse();
    }

}
