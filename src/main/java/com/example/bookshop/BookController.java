package com.example.bookshop;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<String> stringList = new ArrayList<>();


    @GetMapping("/string")
    public List<String> returnString() {
        return stringList;
    }

    @PostMapping("/{put}")
    public void putString(@PathVariable String put) {
        stringList.add(put);
        System.out.println(stringList);
    }

    @DeleteMapping("/{toDelete}")
    public void deleteString(@PathVariable String toDelete) {
        System.out.println("Przed usunieciem: " + stringList);
        stringList.remove(toDelete);
        System.out.println("Po usunieciu: " + stringList);
    }
}
