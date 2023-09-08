package com.spring.form.formthymeleaf.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.form.formthymeleaf.models.domain.Usuario;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @GetMapping("/form")
    public String form(Model model) {
        Usuario usuario = new Usuario();
        usuario.setIdentificador("12345.678-k");
        usuario.setNombre("Alex");
        usuario.setApellido("velez");
        model.addAttribute("titulo", "Form");
        model.addAttribute("usuario", usuario);
        return "/form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario , BindingResult result, Model model, SessionStatus status) {
        if(result.hasErrors()){
            //Map<String, String> errores = new HashMap<>();
           // result.getFieldErrors().forEach(err ->{
           //     errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
           // });
            //model.addAttribute("error", errores);
            return "form";
        }

        model.addAttribute("titulo", "Resultado Form");
        model.addAttribute("usuario", usuario);

        status.setComplete();

        return "resultado";
    }
}
