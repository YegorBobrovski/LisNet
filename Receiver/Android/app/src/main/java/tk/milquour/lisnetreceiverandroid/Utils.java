package tk.milquour.lisnetreceiverandroid;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

final class Utils {
    // fill content in custom button with centered text and drawable
    static void fillCustomButtonContent(View view, int drawableId, int textId) {
        if (view == null) return;

        Button button = (Button) view.findViewById(R.id.buttonCenteredDrawable);
        if (button == null) return;

        button.setCompoundDrawablesWithIntrinsicBounds(drawableId, 0, 0, 0);
        button.setText(textId);
    }

    // show alert dialog to confirm app closing
    static void confirmAppClosing(Context context) {
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
                        System.exit(0);
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
}
