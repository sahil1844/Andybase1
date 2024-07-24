package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;

public class AdaptersActivity extends HomeActivity {
    ListView simpleListView;
    VideoView videoView,videoView1;
    String courseList[] = { "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly Bean", "KitKat"};

    AdapterViewFlipper adapterViewFlipper;

    int[] images = {R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d};
    ScrollView scrollView;

    String[] names = {"Nature", "Colorfull Pan", "Sun", "Land Cruiser"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapters);

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
        adapterViewFlipper = findViewById(R.id.viewflipper);
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), images,names);
        adapterViewFlipper.setAdapter(adapter);
        adapterViewFlipper.setFlipInterval(2600);
        adapterViewFlipper.setAutoStart(true);

        videoView = findViewById(R.id.vv);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.simpleadpt);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        videoView1 = findViewById(R.id.vv1);
        Uri uri1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.simpleexpadpt);
        videoView1.setVideoURI(uri1);
        MediaController mediaController1 = new MediaController(this);
        mediaController1.setAnchorView(videoView1);
        videoView1.setMediaController(mediaController1);
        videoView1.start();

        simpleListView = findViewById(R.id.list);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.item_view, R.id.itemTextView, courseList);
        simpleListView.setAdapter(arrayAdapter);
    }

    public void adptimage(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void arrayadpt(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 0);
            }
        });
    }
    public void simpleadpt(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 2720);
            }
        });
    }

    public void splexadpt(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 7150);
            }
        });
    }

    public void adptflip(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 16330);
            }
        });
    }
    public void baseexadpt(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 20910);
            }
        });
    }

    public void basic2(View view) {
        onNavigationItemSelected(view);
        basicCommon();


    }
    public void widget2(View view) {
        onNavigationItemSelected(view);
        widgetsCommon();
    }
    public void adapter2(View view) {
        onNavigationItemSelected(view);
        adaptersCommon();
    }
    public void chart2(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();

    }
    public void animation2(View view) {
        onNavigationItemSelected(view);
        animationsCommon();

    }


    public class CustomAdapter extends BaseAdapter {
        Context context;
        int[] images;
        String[] names;
        LayoutInflater inflater;
        public CustomAdapter(Context context, int[] images, String[] names) {
            this.context = context;
            this.images = images;
            this.names = names;
            inflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return names.length;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = inflater.inflate(R.layout.custom_adapter_layout, null);
            TextView name = view.findViewById(R.id.name);
            ImageView image = view.findViewById(R.id.image);
            name.setText(names[position]);
            image.setImageResource(images[position]);
            return view;
        }
    }
}