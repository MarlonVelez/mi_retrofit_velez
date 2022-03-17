package com.example.mi_retrofit_velez.modelo;

public class Usuario {
    /*"id": 1,
		"name": "Leanne Graham",
		"username": "Bret",*/

    private int id;
    private String name;
    private String username;

    //GETTERS

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    //SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
