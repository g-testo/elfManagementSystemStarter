package org.yearup.data;

import org.yearup.models.Elf;

import java.util.List;

public interface ElfDao {
    Elf getById(int id);
    List<Elf> getAll();
    Elf create(Elf elf);
    void update(int id, Elf elf);
    void delete(int id);
}
