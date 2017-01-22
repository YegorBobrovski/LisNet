package tk.milquour.lisnetreceiverandroid;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import tk.milquour.lisnetreceiverandroid.notifications.Alert;
import tk.milquour.lisnetreceiverandroid.notifications.Soast;

public class MainActivity extends AppCompatActivity {
    private boolean backToExitPressedOnce = false;
    private boolean appClosing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.main_activity_title);
        setContentView(R.layout.activity_main);

        // attach the layout to the toolbar object
        // so it behaves as actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Utils.fillCustomButtonContent(findViewById(R.id.btn_edit_transmitters_list), R.drawable.ic_edit, R.string.edit);
        Utils.fillCustomButtonContent(findViewById(R.id.btn_refresh_transmitters_list), R.drawable.ic_refresh, R.string.refresh);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_exit:
                Alert.confirmAppClosing(this);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // the're any activities left in stack or it's double BACK pressing
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            super.onBackPressed();
            return;
        }
        if (backToExitPressedOnce) {
            G.getInstance().close();
            return;
        }

        this.backToExitPressedOnce = true;
        Soast.INST.show(R.string.message_tap_back_again_to_exit);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (G.getInstance().isClosing()) return;
                backToExitPressedOnce = false;
            }
        }, 2000);
    }
}
