package controllers;

import models.Restapi;
import views.MainConsole;

public class MainController {
    MainConsole maincon;
    Restapi restapi;
    public MainController() {
        this.restapi = new Restapi();
        this.maincon = new MainConsole(this.restapi);
        
    }
    
}