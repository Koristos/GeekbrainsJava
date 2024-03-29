package ru.geekbrains.summer.market.paypal;

import com.paypal.core.PayPalHttpClient;
import com.paypal.http.HttpResponse;
import com.paypal.orders.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.exceptions.ExecuteOperationException;
import ru.geekbrains.summer.market.exceptions.ResourceNotFoundException;
import ru.geekbrains.summer.market.services.OrderService;
import ru.geekbrains.summer.market.utils.OrderStatus;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/paypal")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PayPalController {
    private final PayPalHttpClient payPalClient;
    private final OrderService orderService;
    private final PayPalService payPalService;

    @PostMapping("/create/{orderId}")
    public ResponseEntity<?> createOrder(@PathVariable Long orderId) throws IOException {
        OrdersCreateRequest request = new OrdersCreateRequest();
        request.prefer("return=representation");
        request.requestBody(payPalService.createOrderRequest(orderId));
        HttpResponse<Order> response = payPalClient.execute(request);
        return new ResponseEntity<>(response.result().id(), HttpStatus.valueOf(response.statusCode()));
    }

    @PostMapping("/capture/{payPalId}")
    public ResponseEntity<?> captureOrder(@PathVariable String payPalId) throws IOException {
        OrdersCaptureRequest request = new OrdersCaptureRequest(payPalId);
        request.requestBody(new OrderRequest());

        HttpResponse<com.paypal.orders.Order> response = payPalClient.execute(request);
        com.paypal.orders.Order payPalOrder = response.result();
        long orderId = Long.parseLong(payPalOrder.purchaseUnits().get(0).referenceId());
        if ("COMPLETED".equals(payPalOrder.status())) {
            orderService.setOrderPaymentResponce(orderId, true);
            return new ResponseEntity<>("Order completed!", HttpStatus.valueOf(response.statusCode()));
        }
        orderService.setOrderPaymentResponce(orderId, false);
        return new ResponseEntity<>(payPalOrder, HttpStatus.valueOf(response.statusCode()));
    }
}
