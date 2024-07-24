package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class AllViewTypes extends AppCompatActivity {
    ScrollView scrollView;
    ListView l;
    String tutorials[] = { "1", "2", "3", "4", "5"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_view_types);
        TextView tv1 = findViewById(R.id.textview);
        TextView tv2 = findViewById(R.id.textview1);

        scrollView = findViewById(R.id.view);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 0);
            }
        });

        ImageView scrollIcon = findViewById(R.id.scrollIcon);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                int scrollMax = scrollView.getChildAt(0).getHeight() - scrollView.getHeight();

                // Listen for scroll changes to update the scrollIcon position
                scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                    @Override
                    public void onScrollChanged() {
                        // Get the current scroll position
                        int scrollY = scrollView.getScrollY();

                        // Calculate the maximum translation Y for the icon (within bounds)
                        float maxTranslationY = scrollView.getHeight() - scrollIcon.getHeight();

                        // Calculate the translation proportionally
                        float iconTranslationY = (scrollY / (float) scrollMax) * maxTranslationY;

                        // Update the icon position
                        scrollIcon.setTranslationY(iconTranslationY);
                    }
                });

                // Allow the icon to be draggable as well
                scrollIcon.setOnTouchListener(new View.OnTouchListener() {
                    float initialY;
                    float initialIconY;
                    float scrollStartY;

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                // Record the initial touch position and current scroll position
                                initialY = event.getRawY();
                                initialIconY = scrollIcon.getTranslationY();
                                scrollStartY = scrollView.getScrollY();
                                return true;

                            case MotionEvent.ACTION_MOVE:
                                // Calculate the difference in Y positions
                                float deltaY = event.getRawY() - initialY;

                                // Calculate the new scroll position
                                float newScrollPosition = scrollStartY + deltaY * (scrollMax / (float)(scrollView.getHeight() - scrollIcon.getHeight()));

                                // Ensure the new scroll position is within bounds
                                if (newScrollPosition < 0) {
                                    newScrollPosition = 0;
                                } else if (newScrollPosition > scrollMax) {
                                    newScrollPosition = scrollMax;
                                }

                                // Programmatically scroll the ScrollView
                                scrollView.scrollTo(0, (int) newScrollPosition);

                                // Update the icon position proportionally
                                float maxTranslationY = scrollView.getHeight() - scrollIcon.getHeight();
                                float iconTranslationY = (newScrollPosition / scrollMax) * maxTranslationY;
                                scrollIcon.setTranslationY(iconTranslationY);

                                return true;
                        }
                        return false;
                    }
                });
            }
        });

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText("Wellcom to AndyBase");
            }
        });
        l = findViewById(R.id.list);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                tutorials);
        l.setAdapter(arr);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void viewtypeimage(View view) {
        onBackPressed();
    }

    public void textview(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 0);
            }
        });
    }
    public void editview(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 2500);
            }
        });
    }
    public void imageview(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 3350);
            }
        });
    }
    public void listview(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 4500);
            }
        });
    }
    public void scrollview(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 5850);
            }
        });
    }
    public void cardview(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 8020);
            }
        });
    }
}