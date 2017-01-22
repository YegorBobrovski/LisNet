package tk.milquour.lisnetreceiverandroid.notifications;

import android.widget.Toast;

import tk.milquour.lisnetreceiverandroid.G;

public enum Soast {
    INST;

    private Toast currentToast;

    public void show(int messageId) {
        if (messageId <= 0) return;
        cancel();
        currentToast = Toast.makeText(G.getContext(), messageId, Toast.LENGTH_SHORT);
        currentToast.show();
    }

    public void cancel() {
        if (currentToast == null) return;
        currentToast.cancel();
    }
}
