package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TodoJPAResourceController {


    @Autowired
    private TodoJPARepository todoJPARepository;

    @GetMapping("/jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable  String username) {
        return todoJPARepository.findByUsername(username);
    }

    @GetMapping("/jpa/users/{username}/todos/{id}")
    public Todo getTodoById(@PathVariable  String username, @PathVariable long id) {
        return todoJPARepository.findById(id).get();
    }

    @DeleteMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
        //Todo todo = todoHardcodedService.deleteById(id);
        todoJPARepository.deleteById(id);
        return ResponseEntity.notFound().build();
    }

//    UPDATE
//    PUT /users/{user-name}/todos/{id}
    // For an update we have a request body with the details of the todo this is mappped by @RequestBody
    @PutMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
        todo.setUsername(username);
        Todo todoUpdated = todoJPARepository.save(todo);
        return new ResponseEntity<>(todoUpdated, HttpStatus.OK);
    }

//    CREATE
//    POST /users/{user-name}/todos/
    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        todo.setUsername(username);
        Todo createdTodo = todoJPARepository.save(todo);
        // What is the url of the created resource??
        // Get current resource url  and then append the id of the newly created resource
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
