package com.vaibhav.Agora.DTOEntities;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
    private String name;
    private String penName;

    public AuthorDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPenName() {
        return penName;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }
}
