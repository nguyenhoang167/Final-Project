package vn.edu.vnuk.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.vnuk.ecommerce.service.user.OrderAddressService;

@RestController
public class OrderAddressController {

    @Autowired
    private OrderAddressService orderAddressService;
}
