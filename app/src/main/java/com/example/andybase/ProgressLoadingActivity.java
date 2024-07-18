package com.example.andybase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;

public class ProgressLoadingActivity extends AppCompatActivity {

    ScrollView scrollView;
    Button button, button2, button3, button4;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_loading);

        scrollView = findViewById(R.id.view);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 0);
            }
        });
        VideoView videoView = findViewById(R.id.vv);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.floatingbtn);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                dialog = new Dialog(ProgressLoadingActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.progress_bar_1);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                new CountDownTimer(2000, 2000) {
                    @Override
                    public void onTick(long l)
                    {
                    }
                    @Override
                    public void onFinish()
                    {
                        dialog.dismiss();
                    }
                }.start();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                dialog = new Dialog(ProgressLoadingActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.progress_bar_2);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

                new CountDownTimer(2000, 2000) {
                    @Override
                    public void onTick(long l)
                    {
                    }
                    @Override
                    public void onFinish()
                    {
                        dialog.dismiss();
                    }
                }.start();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                dialog = new Dialog(ProgressLoadingActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.progress_bar_3);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                new CountDownTimer(2000, 2000) {
                    @Override
                    public void onTick(long l)
                    {
                    }
                    @Override
                    public void onFinish()
                    {
                        dialog.dismiss();
                    }
                }.start();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                dialog = new Dialog(ProgressLoadingActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.progress_bar_4);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                new CountDownTimer(2000, 2000) {
                    @Override
                    public void onTick(long l)
                    {
                    }
                    @Override
                    public void onFinish()
                    {
                        dialog.dismiss();
                    }
                }.start();
            }
        });
    }
    public void prgbtn(View view) {
        setProgressDialog();
    }
    private void setProgressDialog() {
        int llPadding = 30;
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setPadding(llPadding, llPadding, llPadding, llPadding);
        ll.setGravity(Gravity.START);
        LinearLayout.LayoutParams llParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        llParam.gravity = Gravity.CENTER;
        ll.setLayoutParams(llParam);

        // Creating a ProgressBar inside the layout
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setIndeterminate(true);
        progressBar.setPadding(0, 0, 0, 0);
        progressBar.setLayoutParams(llParam);
        llParam = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        llParam.gravity = Gravity.CENTER;

        // Creating a TextView inside the layout
        TextView tvText = new TextView(this);
        tvText.setText("     Loading ...");
        tvText.setTextColor(Color.parseColor("#000000"));
        tvText.setTextSize(20f);
        tvText.setLayoutParams(llParam);
        ll.addView(progressBar);
        ll.addView(tvText);

        // Setting the AlertDialog Builder view as the Linear layout created above
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setView(ll);

        // Displaying the dialog
        AlertDialog dialog = builder.create();
        dialog.show();

        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(dialog.getWindow().getAttributes());
            layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT;
            layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setAttributes(layoutParams);

            // Disabling screen touch to avoid exiting the Dialog
            window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
        new Handler().postDelayed(dialog::dismiss, 2000);
    }

    public void prgimage(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void probtn(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 0);
            }
        });
    }

    public void flobtn(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 8640);
            }
        });
    }
}