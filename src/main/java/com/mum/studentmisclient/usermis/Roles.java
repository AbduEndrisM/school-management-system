package com.mum.studentmisclient.usermis;




public class Roles {

    private Long id;


    private String roleName;

    private String description;

    public Roles(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }

    public Roles() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}