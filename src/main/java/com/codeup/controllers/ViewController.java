package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Carlos on 6/19/17.
 */
@Controller
public class ViewController {


    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{number}")
    public String valuePicked(@PathVariable int number , Model model) {
        model.addAttribute("number", number);
        int random = (int) (Math.random()*6+1);
        model.addAttribute("dice", random);
        if(random == number) {
            model.addAttribute("message", "Good guess, you win");
        } else{
            model.addAttribute("message", "Sorry, try again");
        }
        return "roll-dice";
    }




    @GetMapping("/portfolio")
    public String portfolio() {
        return "portfolio";
    }

    @GetMapping("/resume")
    public String resume() {
        return "resume";
    }

}
