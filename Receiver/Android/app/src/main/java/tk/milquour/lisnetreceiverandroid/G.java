package tk.milquour.lisnetreceiverandroid;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import tk.milquour.lisnetreceiverandroid.notifications.Soast;


public class G extends Application {
    private static G instance;

    private boolean closing;

    public static G getInstance() {return instance;}

    // reach app context from anywhere
    public static Context getContext() {return instance.getApplicationContext();}

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }

    public void close() {
        if (closing) return;

        closing = true;
        Soast.INST.show(R.string.message_exiting);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                System.exit(0);
            }
        }, 2000);
    }

    public boolean isClosing() {return closing;}
}
