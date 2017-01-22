package tk.milquour.lisnetreceiverandroid;

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
}
