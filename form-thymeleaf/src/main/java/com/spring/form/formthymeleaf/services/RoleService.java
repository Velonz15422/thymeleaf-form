package com.spring.form.formthymeleaf.services;

import java.util.List;

import com.spring.form.formthymeleaf.models.domain.Role;

public interface RoleService {
    
    public List<Role> listar();
    public Role obtenerPorId(Integer id);

}
