package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;

public class AdaptersActivity extends AppCompatActivity {
    ListView simpleListView;
    VideoView videoView,videoView1;
    String courseList[] = { "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly Bean", "KitKat"};

    AdapterViewFlipper adapterViewFlipper;

    int[] images = {R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d};

    String[] names = {"Nature", "Colorfull Pan", "Sun", "Land Cruiser"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapters);

        ScrollView scrollView = findViewById(R.id.view);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 0);
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