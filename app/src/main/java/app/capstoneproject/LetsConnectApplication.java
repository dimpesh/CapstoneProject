package app.capstoneproject;

import com.firebase.client.Firebase;
import com.firebase.client.Logger;

/**
 * Includes one-time initialization of Firebase related code
 */
public class LetsConnectApplication extends android.app.Application {

    @Override
    public void onCreate()
    {
        super.onCreate();
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setLogLevel(Logger.Level.DEBUG);
    }

}