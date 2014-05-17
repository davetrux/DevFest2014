package com.devfest.manualinjection.data;

import java.util.List;

/**
 * Created by truxall on 4/18/2014.
 * An Interface for a ToDoData provider
 */
public interface DataProvider {
    void addTask(ToDo item);
    long getNextId();
    void deleteAll();
    void deleteTask(final long id);
    List<ToDo> findAll();
}
