package cz.czechitas.java2webapps.ukol2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

@Controller
public class QuoteController {

    private final Random random;
    private ArrayList<String> quotes = new ArrayList<>();
    private Path p = Paths.get("src/main/resources/citaty.txt");


    public QuoteController() {
        random = new Random();

    try {
        BufferedReader br = Files.newBufferedReader(p, Charset.defaultCharset());
        String line = null;
        while ((line = br.readLine()) != null) {
            quotes.add(line);
            br.close();
        }
    }
    catch (IOException e) {e.printStackTrace();}
    }

    @GetMapping("/")
    public ModelAndView viewQuote() {

        int nahodneCislo = random.nextInt(6);
        String citat = quotes.get(nahodneCislo);

        ModelAndView result = new ModelAndView("index");
        result.addObject("number", citat);

        return result;
    }
}


