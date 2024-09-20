package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@Controller
public class lab2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //1
    @RequestMapping("/currentTime")
    @ResponseBody
    public String currentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm:ss");
        return "Current Time: " + LocalDateTime.now().format(formatter);
    }

    //2
    @RequestMapping("/api")
    @ResponseBody
    public List<Integer> getNumbers(@RequestParam("q") int n) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    //3
    @RequestMapping("/random_number")
    @ResponseBody
    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(500) + 1;
    }

    //4
    @RequestMapping("/fib")
    @ResponseBody
    public long fibonacci(@RequestParam("number") int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long next = a + b;
            a = b;
            b = next;
        }
        return b;
    }

    //5
    @RequestMapping("/{string}")
    @ResponseBody
    public String reverseString(@PathVariable("string") String input) {
        return new StringBuilder(input).reverse().toString();
    }
}