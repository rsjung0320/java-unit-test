package com.nextinno.unittest.aspect.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nextinno.unittest.aspect.Rsa;
import com.nextinno.unittest.aspect.rest.RsaDto.UpdatePasswd;

@RestController
@RequestMapping(value = "/rsa")
public class EncryptController {

    @Rsa(encryptedFields = {"id", "passwd"})
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String saytHelloWorld(UpdatePasswd passwd) {

        return "hello world";
    }
}
