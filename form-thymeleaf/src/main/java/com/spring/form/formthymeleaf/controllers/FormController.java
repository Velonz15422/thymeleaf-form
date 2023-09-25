package com.spring.form.formthymeleaf.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.form.formthymeleaf.editors.NombreMayusculaEditor;
import com.spring.form.formthymeleaf.editors.PaisPropertyEditor;
import com.spring.form.formthymeleaf.models.domain.Pais;
import com.spring.form.formthymeleaf.models.domain.Usuario;
import com.spring.form.formthymeleaf.services.PaisService;
import com.spring.form.formthymeleaf.validation.UsuarioValidador;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private UsuarioValidador validador;

    @Autowired
    private PaisService paisService;

    @Autowired
    private PaisPropertyEditor paisEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validador);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, true));

        binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());

        binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditor());
                        
        binder.registerCustomEditor(Pais.class, "pais", paisEditor);

    }

    @ModelAttribute("listaRolesString")
    public List<String> listaRolesString(){
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERATOR");
        return roles;
    }

    @GetMapping("/form")
    public String form(Model model) {
        Usuario usuario = new Usuario();
        usuario.setIdentificador("12.345.678-K");
        usuario.setNombre("Alex");
        usuario.setApellido("velez");
        model.addAttribute("titulo", "Form");
        model.addAttribute("usuario", usuario);
        return "/form";
    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises() {
        return paisService.listar();
    }

    @ModelAttribute("paises")
    public List<String> paises() {
        return Arrays.asList("Spain", "MX", "CL", "COL", "VZLA");
    }

    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMap() {
        Map<String, String> paises = new HashMap<String, String>();
        paises.put("ES", "SPAIN");
        paises.put("COL", "COLOMBIA");
        paises.put("MX", "MEXICO");
        paises.put("VZLA", "VENEZUELA");

        return paises;
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            return "form";
        }

        model.addAttribute("titulo", "Resultado Form");
        model.addAttribute("usuario", usuario);

        status.setComplete();

        return "resultado";
    }
}
