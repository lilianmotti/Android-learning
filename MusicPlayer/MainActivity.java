package com.wordpress.liliangmader.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.MediaController;
import android.view.View;
import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initiates media player
        mediaPlayer = MediaPlayer.create(this, R.raw.berimbau);

        Button playButton = (Button) findViewById(R.id.button_play);
        playButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        Button pauseButton = (Button) findViewById(R.id.button_pause);
        pauseButton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                mediaPlayer.pause();
            }
        });

        Button restartButton = (Button) findViewById(R.id.button_restart);
        restartButton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                mediaPlayer.seekTo(00);
            }
        });
    }


}
