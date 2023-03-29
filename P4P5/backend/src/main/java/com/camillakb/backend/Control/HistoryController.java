package com.camillakb.backend.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camillakb.backend.DAO.CalcRepo;
import com.camillakb.backend.DAO.UserRepo;
import com.camillakb.backend.Entity.Calculation;

@RestController
@RequestMapping(value = "/history")
@EnableAutoConfiguration
@CrossOrigin
public class HistoryController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    CalcRepo calcRepo;

    @GetMapping(path = "")
    public Page<Calculation> getHistory(@RequestParam(defaultValue = "1") Integer page) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return calcRepo.findAllByUsername(username, PageRequest.of(page-1, 10));
    }
}
