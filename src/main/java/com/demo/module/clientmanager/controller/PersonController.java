package com.demo.module.clientmanager.controller;

import com.demo.message.Response;
import com.demo.module.clientmanager.entry.Person;
import com.demo.module.clientmanager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("Person")
public class PersonController {
    @Autowired
    PersonService personService;



    @PostMapping(value = "QryPerson0001")
    public Response getPersonById(){

        return new Response(personService.getPersonInfo("1400121424",0,1));
    }
}
