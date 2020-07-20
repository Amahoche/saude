package net.javaguides.springboot.springsecurity.web;

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
    
    @GetMapping("/form")
    public String consulta() {
        return "form";
    }
    @GetMapping("/lista")
    public String pacientes() {
        return "lista";
    }
    @GetMapping("/editarpaciente")
    public String editar() {
        return "editarpaciente";
    }
    @GetMapping("/consulta")
    public String consultar() {
        return "consulta";
    }

}
