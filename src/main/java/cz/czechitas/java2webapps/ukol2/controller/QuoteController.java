package cz.czechitas.java2webapps.ukol2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class QuoteController {

    private final Random random;

    public QuoteController() {
        random = new Random();
    }

    @GetMapping("/")
    public ModelAndView viewQuote() {

        int nahodneCislo = random.nextInt(6) + 1;

        String citat1 = new String("Každé ráno zase vyjde slunce...");
        String citat2 = new String("Tančím mezi kapkami deště...");
        String citat3 = new String("Jsi moje všechno...");
        String citat4 = new String("Mezi šuměním vln se má duše rozplývá...");
        String citat5 = new String("I cesta může být cíl...");
        String citat6 = new String("Každý den je důvod k radosti...");

        ModelAndView result = new ModelAndView("index");
        result.addObject("number", String.format("background-image: url(/images/%d.jpg)", nahodneCislo));

        switch (nahodneCislo) {
            case 1:
                result.addObject("citat", citat1);
                break;
            case 2:
                result.addObject("citat", citat2);
                break;
            case 3:
                result.addObject("citat", citat3);
                break;
            case 4:
                result.addObject("citat", citat4);
                break;
            case 5:
                result.addObject("citat", citat5);
                break;
            case 6:
                result.addObject("citat", citat6);
                break;
        }

        return result;
    }
}


