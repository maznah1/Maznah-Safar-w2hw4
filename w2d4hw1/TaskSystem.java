package com.example.w2d4hw1;

import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TaskSystem {

    ArrayList<Tasktracker>System=new ArrayList<>();



    @GetMapping("/task")
    public ArrayList<Tasktracker>grtTask(){

        return System;
    }
    @PostMapping("/System")
    public AipResponse postTask(@RequestBody Tasktracker tasktracker){
        System.add(tasktracker);
        return  new AipResponse("add");

    }


    @PutMapping("/System/{index}")
    public AipResponse PutTask (@PathVariable int index,@RequestBody Tasktracker tasktracker) {
        System.set(index, tasktracker);
        return new AipResponse("updata");


    }

        @DeleteMapping("/System/{index}")

                public AipResponse deletTask(@PathVariable int index){
                System.remove(index);
                return  new AipResponse("delet");


    }
    @PostMapping("/System/Search")
    public AipResponse Search (@RequestParam String title ) {
        for (int i = 0; i < System.size(); i++) {
           if (System.get(i).getTitle() == title) {

             return new AipResponse(""+System);
          }
       }
       return new AipResponse("Wrong ");
  }

    @PostMapping("/task/{title}")
    public ArrayList<Tasktracker>grtilt(@PathVariable String title){
        Tasktracker tasktracker= System.get(title);
        return new  AipResponse("Title");
    }


}
