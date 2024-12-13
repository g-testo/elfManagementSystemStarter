//package org.yearup.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//import org.yearup.data.RoleDao;
//import org.yearup.models.Role;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/roles")
//@CrossOrigin(origins = "*")
//@PreAuthorize("permitAll()")
//public class RoleController {
//    private RoleDao roleDao;
//
//    @Autowired
//    public RoleController(RoleDao roleDao){x
//        this.roleDao = roleDao;
//    }
//
//    @GetMapping("{id}")
//    public Role getRoleById(@PathVariable int id){
//        return roleDao.getById(id);
//    }
//
//    @GetMapping
//    public List<Role> getAllRoles(){
//        return roleDao.getAll();
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Role createRole(@RequestBody Role role){
//        return roleDao.create(role);
//    }
//
//    @PutMapping("{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateRole(@PathVariable int id, @RequestBody Role role){
//        roleDao.update(id, role);
//    }
//
//    @DeleteMapping("{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteRole(@PathVariable int id){
//        roleDao.delete(id);
//    }
//}
//
