//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.08.29 at 11:44:18 PM MSK 
//


package com.geekbrains.ru.summer.market.productview;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.geekbrains.ru.summer.market.productview package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.geekbrains.ru.summer.market.productview
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProductViewByIdRequest }
     * 
     */
    public GetProductViewByIdRequest createGetProductViewByIdRequest() {
        return new GetProductViewByIdRequest();
    }

    /**
     * Create an instance of {@link GetAllProductViewRequest }
     * 
     */
    public GetAllProductViewRequest createGetAllProductViewRequest() {
        return new GetAllProductViewRequest();
    }

    /**
     * Create an instance of {@link GetProductViewByIdResponse }
     * 
     */
    public GetProductViewByIdResponse createGetProductViewByIdResponse() {
        return new GetProductViewByIdResponse();
    }

    /**
     * Create an instance of {@link ProductView }
     * 
     */
    public ProductView createProductView() {
        return new ProductView();
    }

    /**
     * Create an instance of {@link GetAllProductViewResponse }
     * 
     */
    public GetAllProductViewResponse createGetAllProductViewResponse() {
        return new GetAllProductViewResponse();
    }

}
