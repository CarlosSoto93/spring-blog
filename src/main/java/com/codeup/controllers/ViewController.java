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


    boolean show;
    @GetMapping("/roll-dice")
    public String rollDice() {
        show = false;
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{number}")
    public String valuePicked(@PathVariable int number, Model model) {
        show = true;
        model.addAttribute("show", show);
        model.addAttribute("number", number);
        int random1 = (int) (Math.random() * 6 + 1);
        int random2 = (int) (Math.random() * 6 + 1);
        int random3 = (int) (Math.random() * 6 + 1);
        int random4 = (int) (Math.random() * 6 + 1);
        int correctCount = 0;
        model.addAttribute("dice1", random1 + ",");
        model.addAttribute("dice2", random2 + ",");
        model.addAttribute("dice3", random3 + ",");
        model.addAttribute("dice4", random4 + ",");


        if (random1 == number) {
            correctCount++;
        }
        if (random2 == number) {
            correctCount++;
        }
        if (random3 == number) {
            correctCount++;
        }
        if (random4 == number) {
            correctCount++;
        }

        if (correctCount >= 1) {
            model.addAttribute("message", "Good guess, you got " + correctCount + " matching number(s)");
        } else {
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
