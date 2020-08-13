/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Dao.UserDao;

/**
 *
 * @author User
 */
public class tb_user{
    private static String username;
    private String password;
    private String role;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        tb_user.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
