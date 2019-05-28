package com.example.vrushabh.floating_animation_action_button;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Boolean isFabOpen = false;

    FloatingActionButton floatingActionButtonMaster,floatingActionButtonOne,
                         floatingActionButtonTwo,floatingActionButtonThree;

    Animation floating_open,floating_close,
                      rotation_start,rotation_end;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButtonMaster = findViewById(R.id.fabMaster);
        floatingActionButtonOne = findViewById(R.id.fabOne);
        floatingActionButtonTwo = findViewById(R.id.fabTwo);
        floatingActionButtonThree = findViewById(R.id.fabThree);

        floatingActionButtonMaster.setOnClickListener(this);
        floatingActionButtonOne.setOnClickListener(this);
        floatingActionButtonTwo.setOnClickListener(this);
        floatingActionButtonThree.setOnClickListener(this);

        floating_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.floating_open);
        floating_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.floating_close);

        rotation_start = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotation_start);
        rotation_end = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotation_end);

    }


    @Override
    public void onClick(View view){
        int id = view.getId();
                switch (id){
                    case R.id.fabMaster:
                        animateFAB();
                        break;
                    case R.id.fabOne:
                        Toast.makeText(this, "Clicked SNOW", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.fabTwo:
                        Toast.makeText(this, "Clicked MONEY", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.fabThree:
                        Toast.makeText(this, "Clicked LOCATION", Toast.LENGTH_SHORT).show();
                        break;
                }
    }


    public void animateFAB(){
        if (isFabOpen){
            floatingActionButtonMaster.startAnimation(rotation_end);
            floatingActionButtonOne.startAnimation(floating_close);
            floatingActionButtonTwo.startAnimation(floating_close);
            floatingActionButtonThree.startAnimation(floating_close);

            floatingActionButtonOne.setClickable(false);
            floatingActionButtonTwo.setClickable(false);
            floatingActionButtonThree.setClickable(false);
            isFabOpen = false;
        } else {

            floatingActionButtonMaster.startAnimation(rotation_start);
            floatingActionButtonOne.startAnimation(floating_open);
            floatingActionButtonTwo.startAnimation(floating_open);
            floatingActionButtonThree.startAnimation(floating_open);

            floatingActionButtonOne.setClickable(true);
            floatingActionButtonTwo.setClickable(true);
            floatingActionButtonThree.setClickable(true);
            isFabOpen = true;

        }
    }

}
