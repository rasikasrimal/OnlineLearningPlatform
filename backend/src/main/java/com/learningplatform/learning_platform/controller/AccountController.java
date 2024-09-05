package com.learningplatform.learning_platform.controller;


import com.learningplatform.learning_platform.dto.RegisterDTO;
import com.learningplatform.learning_platform.model.AppUser;
import com.learningplatform.learning_platform.repository.AppUserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDTO registerDTO = new RegisterDTO();
        model.addAttribute(registerDTO);
        model.addAttribute("success", false);
        return "register";
    }

    @PostMapping("/register")
    public String register(
            Model model,
            @Valid @ModelAttribute RegisterDTO registerDTO,
            BindingResult bindingResult
    ) {

        if(!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())){
            bindingResult.addError(
                    new FieldError("registerDTO", "confirmPassword", "Passwords do not match")
            );
        }

        AppUser appUser = appUserRepository.findByEmail(registerDTO.getEmail());
        if (appUser!=null){
            bindingResult.addError(new FieldError("registerDTO", "email", "Email already in use"));
        }

        if(bindingResult.hasErrors()){
            return "register";
        }

        try {
            var bCryptEncoder = new BCryptPasswordEncoder();

            AppUser newUser = new AppUser();
            newUser.setFirstname(registerDTO.getFirstName());
            newUser.setLastname(registerDTO.getLastName());
            newUser.setEmail(registerDTO.getEmail());
            newUser.setPhone(registerDTO.getPhone());
            newUser.setRole("student");
            newUser.setPassword(bCryptEncoder.encode(registerDTO.getPassword()));
            appUserRepository.save(newUser);

            model.addAttribute("registerDTO", new RegisterDTO());
            model.addAttribute("success", true);

        } catch (Exception ex) {
            bindingResult.addError(new FieldError("registerDTO", "firstname", ex.getMessage()));
        }

        return "register";
    }

}
