package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yearup.data.ElfDao;
import org.yearup.models.Elf;

@RestController
@RequestMapping("api/elves")
@CrossOrigin(origins = "*")
public class ElfController {
    private ElfDao elfDao;

    @Autowired
    public ElfController(ElfDao elfDao){
        this.elfDao = elfDao;
    }

    @GetMapping("{id}")
    public Elf getById(@PathVariable int id){
        return elfDao.getById(id);
    }

}
