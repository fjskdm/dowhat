package com.example.lenovo.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageSwitcher is_1;
    private ImageView iv_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Glide.with(this).load("https://www.baidu.com/img/superlogo_c4d7df0a003d3db9b65e9ef0fe6da1ec.png?where=super").into(iv_1);

        is_1.setOutAnimation(AnimationUtils.loadAnimation(ImageViewActivity.this,android.R.anim.fade_out));
        is_1.setInAnimation(AnimationUtils.loadAnimation(ImageViewActivity.this,android.R.anim.fade_out));

        is_1.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(ImageViewActivity.this);
                imageView.setImageResource(R.drawable.cg1);
                return imageView;
            }
        });
        is_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is_1.setImageResource(R.drawable.main_icon);
            }
        });
    }
}
