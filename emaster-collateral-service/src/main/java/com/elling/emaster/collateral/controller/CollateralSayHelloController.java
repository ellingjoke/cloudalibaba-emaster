package com.elling.emaster.collateral.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/collateral/")
public class CollateralSayHelloController {

    @RequestMapping("sayHello/{who}")
    public String sayHello(@PathVariable String who){
        return new Date().getTime()+",Hello who are you: " + who;
    }


}
