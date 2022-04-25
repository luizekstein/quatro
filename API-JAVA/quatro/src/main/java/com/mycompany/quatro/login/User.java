package com.mycompany.quatro.login;

public class User {
    private Integer id;
    private String name;
    private String login;
    private String password;
    private String permission;
    private Integer fkClient;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getFkClient() {
        return fkClient;
    }

    public void setFkClient(Integer fkClient) {
        this.fkClient = fkClient;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", permission='").append(permission).append('\'');
        sb.append(", fkClient=").append(fkClient);
        sb.append('}');
        return sb.toString();
    }
}
