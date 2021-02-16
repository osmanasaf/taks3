package com.example.codefirst.task3.Controller;




import com.example.codefirst.task3.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    private UserController userController;


    @GetMapping("/register")
    public String reqisterForm(Model model){

        model.addAttribute("user",new User());
        return "views/registerForm";
    }

    @PostMapping("/register")
    public String registerUser(User user, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            return "views/registerForm";
        }
        if(userController.isUserHere(user.getUsername())){
            model.addAttribute("exist",true);
            return "views/registerForm";
        }
        userController.createUser(user);
        return"views/success";
    }
}
