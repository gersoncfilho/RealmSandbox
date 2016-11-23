package gersondeveloper.com.br.realmsandbox;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by gersoncardoso on 23/11/2016.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }


}
