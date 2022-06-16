package com.example.bookshop;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController  //mowi springowi ze klasa bedzie ogarniala naszego resta
@RequestMapping("/books")
public class BookController {

    List<String> stringList = new ArrayList<>();  //póki co to jest nasza baza danych

    @GetMapping ("/string")//aby spring wiedział że coś ma wyświetlać
    public List<String> returnString(){
        return stringList;
    }

    @PostMapping("/{sample}")
    public void postString(@PathVariable String sample){
        stringList.add(sample);
        System.out.println(stringList);
    }

    @DeleteMapping("/{toDelete}")
    public void deleteString(@PathVariable String toDelete){
        System.out.println("lista przed usunięciem: " + stringList);
        stringList.remove(toDelete);
        System.out.println("lista po usunięciu: " + stringList);
    }

}
