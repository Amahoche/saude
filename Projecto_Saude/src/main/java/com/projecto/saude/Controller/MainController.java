package com.projecto.saude.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

   /** @GetMapping("/")
    public String root() {
        return "index";
    }**/
    @GetMapping("/")
    public String root() {
        return "dashboard";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
   @GetMapping("/teste")
    public String testar() {
        return "teste";
    }

    @GetMapping("/worker")
    public String work() {
        return "worker";
    }
    
    @GetMapping("/list")
    public String consulta() {
        return "list";
    }
    
    @GetMapping("/lista")
    public String pacientes() {
        return "lista";
    }
    
    @GetMapping("/editarPaciente")
    public String editar() {
        return "editarPaciente";
    }
    @GetMapping("/updateFuncionario")
    public String edita() {
        return "updateFuncionarrio";
    }
    @GetMapping("/form")
    public String consultar() {
        return "form";
    }

}
