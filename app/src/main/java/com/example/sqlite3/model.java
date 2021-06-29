package com.example.sqlite3;

public class model {
    String name,contact,email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public model(String name, String contact, String email) {
        this.name = name;
        this.contact = contact;
        this.email = email;
    }
}
