package com.booleans.calendar;

import com.booleans.calendar.FRQ.Praveen.CarInheritance;
import com.booleans.calendar.FRQ.Praveen.RecursionPraveen;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.booleans.calendar.FRQ.Neil.RecursionNeil;
import com.booleans.calendar.FRQ.Vihan.FrogRiver;

@Controller
public class MainController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String Index() {
        return "Index";
    }

    @GetMapping("/labs")
    public String MiniLabs() { return "MiniLabsHome"; }

    @GetMapping("/BooleansCalendar")
    public String BooleansCalendar() {return "Calendar";}

    @GetMapping("/calculator")
    public String Calculator() {return "LabsHTMLPages/Aditya/AdityaRecursionCalculator";}

    /*@GetMapping("/labs/Vihan/river")
    public String river() {return "/LabsHTMLPages/Vihan/RiverRecursion";}*/

    @RequestMapping(value = "/FRQ/Vihan/river", method = {RequestMethod.GET, RequestMethod.POST})
    public String PostRiver(@RequestParam(value = "rocks", required = false, defaultValue = "3") String rocks, Model model) {

        int numrocks = Integer.parseInt(rocks);
        FrogRiver river = new FrogRiver(numrocks);

        model.addAttribute("paths", String.valueOf(river.getPaths()));
        model.addAttribute("riverTime", String.valueOf(river.getTimeElapsed()));

        return "labs/Vihan/RiverRecursion";
    }

    @RequestMapping(value = "/labs/Praveen/dafact", method = {RequestMethod.GET, RequestMethod.POST})
    public String Factorial(@RequestParam(value = "totfact", required = false, defaultValue = "3") String totfact, Model model) {

        RecursionPraveen factorial = new RecursionPraveen();
        int factnum = Integer.parseInt(totfact);

        model.addAttribute("paths", factorial.fact(factnum));


        return "labs/Praveen/praveenFactorial";
    }

    @RequestMapping(value = "/labs/Neil/dafact", method = {RequestMethod.GET, RequestMethod.POST})
    public String FactorialNeil(@RequestParam(value = "totfact", required = false, defaultValue = "1") String totfact, Model model) {

        RecursionNeil factorial = new RecursionNeil();
        int factnum = Integer.parseInt(totfact);

        model.addAttribute("paths", factorial.fact(factnum));
        model.addAttribute("paths", factorial.loop(factnum));


        return "labs/Neil/NeilFactorial";
    }

    @RequestMapping(value = "/labs/Praveen/Car", method = {RequestMethod.GET, RequestMethod.POST})
    public String Car(@RequestParam(value = "Gears", required = false, defaultValue = "3") String Gears, @RequestParam(value = "Speed", required = false, defaultValue = "3") String Speed, @RequestParam(value = "Height", required = false, defaultValue = "3") String Height, Model model) {

        CarInheritance car = new CarInheritance();
        int DaGear = Integer.parseInt(Gears);
        int DaSpeed = Integer.parseInt(Speed);
        int DaHeight = Integer.parseInt(Height);

        model.addAttribute("paths", car.);

        return "labs/Praveen/praveenFactorial";
    }

}