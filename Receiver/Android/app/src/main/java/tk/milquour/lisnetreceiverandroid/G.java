package tk.milquour.lisnetreceiverandroid;

import android.app.Application;
import android.content.Context;


public class G extends Application {
    private static G instance;

    // reach app context from anywhere
    public static Context getContext(){return instance.getApplicationContext();}

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}
