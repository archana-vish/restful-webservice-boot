package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList<>();
    private static long counter = 1;

    static {
        todos.add(new Todo(counter++, "in28minutes", "Learn Angular 7", new Date(), false ));
        todos.add(new Todo(counter++, "in28minutes", "Learn Spring Boot", new Date(), false ));
        todos.add(new Todo(counter++, "in28minutes", "Learn JMeter", new Date(), false ));
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo deleteById(long id) {
        Todo toRemoveThisTodo = findById(id);
        if (toRemoveThisTodo == null ) {
            return null;
        } else {
            todos.remove(toRemoveThisTodo);
        }
        return toRemoveThisTodo;
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public Todo save(Todo todo) {
        if (todo.getId() <= 0 ) {
            // create a new id before save
            todo.setId(++counter);
        } else {
            // delete an old todo and save as new
            deleteById(todo.getId());
        }
        todos.add(todo);
        return todo;
    }

}
