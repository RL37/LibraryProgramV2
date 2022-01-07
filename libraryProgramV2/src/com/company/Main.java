package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.company.Menu.loginMenu;
import static com.company.Menu.runAdminMenu;
import static com.company.Menu.runMainMenu;

public class Main {

    public static void main(String[] args) {
        String userType = loginMenu();
        if (userType.equals("user")){
            runMainMenu();
        }
        if (userType.equals("admin")){
            runAdminMenu();
        }
    }

}
