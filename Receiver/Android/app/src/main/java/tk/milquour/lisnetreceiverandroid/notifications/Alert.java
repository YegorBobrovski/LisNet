package tk.milquour.lisnetreceiverandroid.notifications;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import tk.milquour.lisnetreceiverandroid.G;
import tk.milquour.lisnetreceiverandroid.R;

public final class Alert {
    // show alert dialog to confirm app closing
    public static void confirmAppClosing(Context context) {
        DialogInterface.OnCancelListener cancelListener = new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                dialog.cancel();
            }
        };
        DialogInterface.OnClickListener clickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        G.getInstance().close();
                    case DialogInterface.BUTTON_NEGATIVE:
                        dialog.cancel();
                        break;
                }
            }
        };
        new AlertDialog.Builder(context)
                .setTitle(R.string.app_name)
                .setMessage(R.string.alert_exit_confirm_message)
                .setIcon(R.drawable.ic_exit_black)
                .setCancelable(true)
                .setOnCancelListener(cancelListener)
                .setPositiveButton(R.string.ok, clickListener)
                .setNegativeButton(R.string.cancel, clickListener)
                .create()
                .show();
    }

    // more alerts here
}
