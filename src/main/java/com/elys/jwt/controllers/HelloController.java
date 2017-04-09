package com.elys.jwt.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Elys Javier Rivero
 *
 * @since 09/04/17
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String publicMethod() {
        return "Public method";
    }

    @RequestMapping(value = "/xxx", method = RequestMethod.GET)
    public String privateMethod() {
        return "private method";
    }
}
