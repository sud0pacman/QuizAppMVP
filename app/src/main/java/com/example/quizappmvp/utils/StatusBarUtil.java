package com.example.quizappmvp.utils;


import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
public class StatusBarUtil {

    public static void makeStatusBarTransparent(FragmentActivity activity) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        // Эта строка делает статус-бар прозрачным на всех версиях Android начиная с 19,
        // но для версий >= 21, цвет статус-бара устанавливается прозрачным дважды.
        // Поэтому, её можно рассматривать как избыточную при наличии проверки версии выше.
        // Убрал повторное установление цвета статус-бара в прозрачный для устранения избыточности.
        // activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    private static void setWindowFlag(FragmentActivity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}