package com.camillakb.backend.Control;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@EnableAutoConfiguration
@CrossOrigin("*")
public class HistoryController {
    //fiks at brukeren kan hente kalkulator-logg fra database
}
