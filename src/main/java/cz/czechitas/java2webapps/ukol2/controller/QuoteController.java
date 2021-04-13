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
    public ArrayList<String> quotes = new ArrayList<>();
    public Path p = Paths.get("src/main/resources/citaty.txt");


    public QuoteController() {
        random = new Random();

    try {
        BufferedReader br = Files.newBufferedReader(p, Charset.defaultCharset());
        String line = null;
        while ((line = br.readLine()) != null) {
            quotes.add(line);
        }
        br.close();
    }
    catch (IOException e) {e.printStackTrace();}
    }

    @GetMapping("/")
    public ModelAndView viewQuote() {

        String quote;

        int nahodneCislo = random.nextInt(6);
        if (nahodneCislo == 0){
            nahodneCislo = nahodneCislo + 1;
            quote = quotes.get(nahodneCislo);
        }else{
            quote = quotes.get(nahodneCislo);
        }

        ModelAndView result = new ModelAndView("index");
        result.addObject("number", String.format("background-image: url(/images/%d.jpg)", nahodneCislo));
        result.addObject("citat", quote);

        return result;
    }
}


