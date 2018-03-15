package com.king.jerem.imagegallery.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.king.jerem.imagegallery.R;

public class Main2Activity extends AppCompatActivity {
    ProgressBar progressBar;
    ImageView imageView;
    String pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addcontroll();

        Intent intent=getIntent();
        pos=intent.getStringExtra("poUrl");
        Toast.makeText(this,pos+"",Toast.LENGTH_LONG).show();

        Loadimage();

    }

    private void Loadimage() {
        Glide.with(Main2Activity.this)
                .load(pos)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .fitCenter()
                .placeholder(R.drawable.banan)
                .into(imageView);
    }

    private void addcontroll() {
        imageView=findViewById(R.id.imghinh);
        progressBar=findViewById(R.id.progessbar);
    }
}
