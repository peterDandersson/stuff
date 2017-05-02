package com.my.pack;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.soap.SOAPBinding;
import java.io.Serializable;

@Named
@ViewScoped
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UserManager userManager;

    private User user;

    public User getUser(){
        return user;
    }

    public void onload(){
        user = userManager.isSignedIn() ? userManager.getCurrentUser() : new User();
    }

    public String submit(){
        return userManager.save(user);
    }
}
