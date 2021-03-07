package com.example.project007.LoginSignup;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    //initialize variables
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    //create Constructor
    public SessionManager(Context context){
        sharedPreferences = context.getSharedPreferences("Appkey",0);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    //create set login method
    public void setLogin(boolean login){
        editor.putBoolean("KEY_LOGIN",login);
        editor.commit();
    }

    //create get login method
    public boolean getLogin(){
        return sharedPreferences.getBoolean("KEY_LOGIN",false);
    }

    //create set username method
    public void setLogin(String username){
        editor.putString("KEY_USERNAME",username);
        editor.commit();
    }

    //create get login method
    public String getUsername(){
        return sharedPreferences.getString("KEY_USERNAME","");
    }


}
