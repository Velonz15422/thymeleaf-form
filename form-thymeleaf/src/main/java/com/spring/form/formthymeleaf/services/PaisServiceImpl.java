package com.spring.form.formthymeleaf.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.form.formthymeleaf.models.domain.Pais;

@Service
public class PaisServiceImpl implements PaisService  {


    private List<Pais> lista;
    public PaisServiceImpl() {
        this.lista = Arrays.asList(
            new Pais(1, "ES", "Spain"),
                new Pais(2, "MX", "MEXICO"),
                new Pais(3, "CL", "CHILE"),
                new Pais(4, "COL", "COLOMBIA"));
    
    }

    @Override
    public List<Pais> listar() {
        return lista;
    }

    @Override
    public Pais obtenerPorId(Integer id) {
        Pais resultado  = null;
        for (Pais pais : lista) {
            if (id == pais.getId()) {
                resultado = pais;
                break;
            }
        }
        return resultado;
    }
    
}
