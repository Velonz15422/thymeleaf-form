package com.spring.form.formthymeleaf.models.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.spring.form.formthymeleaf.validation.IdentificadorRegex;
import com.spring.form.formthymeleaf.validation.Requerido;
import com.spring.form.formthymeleaf.validation.RequeridoNumeroValidador;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Usuario {

    // @Pattern(regexp = "[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}")
    @IdentificadorRegex
    private String identificador;

    // @NotEmpty
    private String nombre;

    @Requerido
    private String apellido;

    @NotBlank
    @Size(min = 3, max = 12)
    private String username;

    @Requerido
    private String password;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Min(5)
    @Max(5000)
    private Integer numero;

    @NotNull
    // @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future
    private Date fechaNacimiento;

    @NotNull
    private Pais pais;

    @NotEmpty
    private List<String> roles;

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    

}
