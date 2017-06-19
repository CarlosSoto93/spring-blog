package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Carlos on 6/19/17.
 */
@Controller
public class MathController {

    @GetMapping("/add/{valueOne}/and/{valueTwo}")
    @ResponseBody
    public int add(@PathVariable int valueOne, @PathVariable int valueTwo) {
        return valueOne + valueTwo;
    }

    @GetMapping("/subtract/{valueOne}/from/{valueTwo}")
    @ResponseBody
    public int subtract(@PathVariable int valueOne, @PathVariable int valueTwo) {
        return valueTwo - valueOne;
    }

    @GetMapping("/multiply/{valueOne}/and/{valueTwo}")
    @ResponseBody
    public int multiply(@PathVariable int valueOne, @PathVariable int valueTwo) {
        return valueOne * valueTwo;
    }

    @GetMapping("/divide/{valueOne}/by/{valueTwo}")
    @ResponseBody
    public double divide(@PathVariable int valueOne, @PathVariable int valueTwo) {
        return (double) valueOne / valueTwo;
    }


}
