package com.mcs.logoengine.controllers;

import com.mcs.logoengine.config.seller.SellerRegistration;
import com.mcs.logoengine.entity.seller.SellerEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SellerReglogController {

    @PostMapping("/seller/registration")
    public String Registration(@RequestBody SellerEntity sellerEntity){
        return SellerRegistration.RegisterSeller(sellerEntity);
    }
    @GetMapping("/test")
    public String OnlyTest(){
        return "{" +"\"name\":\"Tanay\""+"}";
    }
}
