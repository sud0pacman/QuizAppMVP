package com.example.quizappmvp.presentation.finish;

import static android.content.Intent.getIntent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.quizappmvp.R;
import com.example.quizappmvp.presentation.main.MainActivity;
import com.example.quizappmvp.utils.StatusBarUtil;

import org.w3c.dom.Text;

import kotlinx.coroutines.CoroutineDispatcher;

public class FinishActivity extends AppCompatActivity {

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finsh);

        StatusBarUtil.makeStatusBarTransparent(this);

        int trueAns = getIntent().getIntExtra("CORRECTS", 0);
        int wrongAns = getIntent().getIntExtra("WRONGS", 0);
        long time = getIntent().getLongExtra("TIME", 0);
        long seconds = (time / 1000) % 60;
        long minutes = (time / (1000 * 60)) % 60;


        Log.d("TTT", "" + time);

        LottieAnimationView lottieAnimationView = findViewById(R.id.animationView);
        lottieAnimationView.setAnimation("win.json");
        lottieAnimationView.setRepeatCount(0);
        lottieAnimationView.playAnimation();

        TextView bandTv = findViewById(R.id.tv_band);
        bandTv.setText(""+trueAns);

        TextView timeTv = findViewById(R.id.tv_time);

        if (seconds > 9) timeTv.setText(minutes + ":"+seconds);
        else timeTv.setText(minutes + ":"+"0"+seconds);


        TextView accuracyTv = findViewById(R.id.tv_accuracy);
        float accuracy = ((trueAns + wrongAns) * 0.01f) * trueAns;
        accuracyTv.setText("%" + ((int) accuracy));

        TextView degree = findViewById(R.id.tv_degree);

        if (accuracy <= 50) {
            degree.setText("Aniqlik");
        }
        else if (accuracy <= 70) degree.setText("Yaxshi");
        else degree.setText("Mukammal");

        LinearLayout backButton = findViewById(R.id.btn_home);

        backButton.setOnClickListener(v -> {
            finish();
        });
    }
}