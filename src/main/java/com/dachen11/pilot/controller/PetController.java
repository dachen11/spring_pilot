package com.dachen11.pilot.controller;
import com.dachen11.pilot.dao.PetDao;
import com.dachen11.pilot.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/pet")
public class PetController {
    private final PetDao petDao;

    @Autowired
    public PetController(PetDao petDao) {
        this.petDao = petDao;
    }
    @GetMapping("/all")
    public List<Pet> findAll() {
        return petDao.findAll();
    }
}
