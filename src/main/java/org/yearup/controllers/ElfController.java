package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yearup.data.ElfDao;
import org.yearup.models.Elf;

import java.util.List;

@RestController
@RequestMapping("api/elves")
@CrossOrigin(origins = "*")
@PreAuthorize("permitAll()")
public class ElfController {
    private ElfDao elfDao;

    @Autowired
    public ElfController(ElfDao elfDao){
        this.elfDao = elfDao;
    }

    @GetMapping("{id}")
    public Elf getElfById(@PathVariable int id){
        return elfDao.getById(id);
    }

    @GetMapping
    public List<Elf> getAllElves(){
        return elfDao.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Elf createElf(@RequestBody Elf elf){
        return elfDao.create(elf);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateElf(@PathVariable int id, @RequestBody Elf elf){
        elfDao.update(id, elf);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteElf(@PathVariable int id){
        elfDao.delete(id);
    }
}
