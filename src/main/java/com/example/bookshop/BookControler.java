package com.example.bookshop;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookControler {

    List<String> stringList = new ArrayList<>();

    @GetMapping("/string")
    public List<String> returnString ()    {
        return stringList;
    }

    @PostMapping("/{sample}")
    public void putString (@PathVariable String sample){
        stringList.add(sample);
        System.out.println(stringList);
    }
    @DeleteMapping("/{toDelete}")
    public void deleteString(@PathVariable String toDelete){
        System.out.println(stringList);
        stringList.remove(toDelete);
        System.out.println(stringList);
    }
}
