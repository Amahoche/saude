package com.projecto.saude.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.projecto.saude.Models.User;
import com.projecto.saude.service.UserService;
import com.projecto.saude.web.UserRegistrationDto;

@Controller

public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "register";
    }
    /** @PostMapping(value="usuarios/adicionar")
	public RedirectView addNew(UserRegistrationDto userDto, RedirectAttributes redir) {
    	userService.save(userDto);	
		RedirectView  redirectView= new RedirectView("/login",true);
	       redir.addFlashAttribute("message",
	    		"Registado com sucesso! Agora pode fazer login");
	    return redirectView;				
	}**/
   @PostMapping(value="/usuarios/adicionar")
    public String registerUserAccount(@ModelAttribute("user") @Validated UserRegistrationDto userDto,
                                      BindingResult result){

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "Ja existe uma conta registada com este email.");
        }
      
        if (result.hasErrors()){
            return "register";
        }

        userService.save(userDto);
        return "redirect:/register?success";
    }

}
