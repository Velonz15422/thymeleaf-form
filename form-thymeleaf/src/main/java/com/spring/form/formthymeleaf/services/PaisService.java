package com.spring.form.formthymeleaf.services;

import com.spring.form.formthymeleaf.models.domain.Pais;

import java.util.List;

public interface PaisService {
    public List<Pais> listar();
    public Pais obtenerPorId(Integer id);
}
