package com.mycompany.quatro.entities;

public class User {

    private Integer idUser;
    private Integer fkClient;
    private String name;
    private String login;
    private String password;
    private String permission;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getFkClient() {
        return fkClient;
    }

    public void setFkClient(Integer fkClient) {
        this.fkClient = fkClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

}
