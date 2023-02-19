package controllers;

import models.Restapi;
import views.MainConsole;

/*
* File: MainController.java
* Author: Gubis Zsombor Dániel
* Copyright: 2023, Gubis Zsombor Dániel
* Group: Szoft II N
* Date: 2023-02-19
* Github: https://github.com/zsomi4/
* Licenc: GNU GPL
*/

public class MainController {
    MainConsole maincon;
    Restapi restapi;
    public MainController() {
        this.restapi = new Restapi();
        this.maincon = new MainConsole(this.restapi);
        
    }
    
}