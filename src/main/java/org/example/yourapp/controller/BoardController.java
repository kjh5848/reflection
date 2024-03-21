package org.example.yourapp.controller;


import org.example.yourapp.RequestMapping;


public class BoardController {

    @RequestMapping("/save")
    public String save() {
        return "<h1>board write</h1>";
    }

    @RequestMapping("/findAll")
    public String findAll() {
        return "<h1>board list</h1>";
    }

    @RequestMapping("/findById")
    public String findById(){
        return "<h1>board one</h1>";
    }
}
