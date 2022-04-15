package ru.geekbrains.summer.market.endpoints;

import com.geekbrains.ru.summer.market.productview.*;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrains.summer.market.services.ProductService;

@Endpoint
@RequiredArgsConstructor
public class ProductViewEndpoint {
    private static final String NAMESPACE_URI = "http://ru.geekbrains.com/summer/market/productview";
    private final ProductService productService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductViewByIdRequest")
    @ResponsePayload
    public GetProductViewByIdResponse getProductViewById (@RequestPayload GetProductViewByIdRequest request) {
        GetProductViewByIdResponse response = new GetProductViewByIdResponse();
        response.setProductView(productService.getProductViewById(request.getId()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllStudentsRequest")
    @ResponsePayload
    public GetAllProductViewResponse getAllStudents(@RequestPayload GetAllProductViewRequest request) {
        GetAllProductViewResponse response = new GetAllProductViewResponse();
        response.getProductViews().addAll(productService.getAllProductViews());
        return response;
    }
}
