package ru.geekbrains.summer.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.summer.market.dto.OrderDto;
import ru.geekbrains.summer.market.dto.OrderItemDto;
import ru.geekbrains.summer.market.exceptions.ResourceNotFoundException;
import ru.geekbrains.summer.market.model.Order;
import ru.geekbrains.summer.market.model.OrderItem;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.model.User;
import ru.geekbrains.summer.market.repositories.OrderRepository;
import ru.geekbrains.summer.market.utils.Cart;
import ru.geekbrains.summer.market.utils.OrderStatus;
import ru.geekbrains.summer.market.utils.OrderValidationMessages;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final CartService cartService;

    @Transactional
    public void createOrder(User user, String address, String phone) {
        Cart cart = cartService.getCurrentCart(cartService.getCartUuidFromSuffix(user.getUsername()));
        Order order = new Order();
        order.setPrice(cart.getPrice());
        order.setItems(new ArrayList<>());
        order.setUser(user);
        order.setPhone(phone);
        order.setAddress(address);
        order.setStatus(OrderStatus.NEW);
        for (OrderItemDto o : cart.getItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setQuantity(o.getQuantity());
            Product product = productService.findById(o.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
            orderItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(o.getQuantity())));
            orderItem.setPricePerProduct(product.getPrice());
            orderItem.setProduct(product);
            order.getItems().add(orderItem);
        }
        orderRepository.save(order);
        cart.clear();
        cartService.updateCart(cartService.getCartUuidFromSuffix(user.getUsername()), cart);
    }

    @Transactional
    public List<OrderDto> findAllDtosByUsername(String username) {
        return orderRepository.findAllByUsername(username).stream().map(OrderDto::new).collect(Collectors.toList());
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Transactional
    public Order setOrderPaymentResponce(Long id, boolean isPayed) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setStatus(isPayed ? OrderStatus.PAYED : OrderStatus.PENDING);
            orderRepository.save(order);
            return order;
        }
        throw new NoSuchElementException();
    }

    @Transactional
    public OrderDto findDtoById(Long id) {
        return new OrderDto(findById(id).get());
    }

    @Transactional
    public List<OrderValidationMessages> orderPrepaymentValidation(Long orderId, String requestingUserName) {
        List<OrderValidationMessages> validationMessages = new ArrayList<>();
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            if (order.getStatus() != OrderStatus.NEW && order.getStatus() != OrderStatus.PENDING) {
                validationMessages.add(OrderValidationMessages.INVALID_ORDER_STATUS);
            }
            if (!requestingUserName.equals(order.getUser().getUsername())) {
                validationMessages.add(OrderValidationMessages.INVALID_CUSTOMER);
            }
        } else {
            validationMessages.add(OrderValidationMessages.ORDER_NOT_FOUND);
        }
        return validationMessages;
    }
}
