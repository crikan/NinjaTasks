package com.example.jigokushoujo.ninjatasks;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        Typeface fuenteNinja = Typeface.createFromAsset(getAssets(),"lastninja.ttf");
        //Typeface fuenteJapon = Typeface.createFromAsset(getAssets(),"Japanese Tourist.ttf");
        TextView titulo = (TextView) findViewById(R.id.titulo);
        TextView mas = (TextView) findViewById(R.id.mas);

        titulo.setTypeface(fuenteNinja);
        mas.setTypeface(fuenteNinja);

        Animation anim = AnimationUtils.loadAnimation(this,R.anim.animacion);
        Animation anim2 = AnimationUtils.loadAnimation(this,R.anim.animacion2);

        titulo.startAnimation(anim);
        mas.startAnimation(anim2);

        anim2.setAnimationListener(this);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
