package com.example.sendmessageBinding;

import android.app.Application;

import com.example.sendmessageBinding.data.User;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class SendMessageApplication extends Application {
    //Usuario que ha iniciado sesion. DATO GLOBAL porque siempre se va acceder a él
    //mediante el método getApplication().getUser()
    private User user;


    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d("Se ha inicializado el objeto Application");
        user=new User("Rafael GC","al.rafael.garrido.cantos@iesportada.org");
    }

    public User getUser() {
        return user;
    }
}
