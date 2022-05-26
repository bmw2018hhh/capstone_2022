package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Youtube extends YouTubeBaseActivity {
    YouTubePlayerView youtubeView;
    Button button;
    YouTubePlayer.OnInitializedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        button = (Button) findViewById(R.id.youtubeButton);
        youtubeView = (YouTubePlayerView) findViewById(R.id.youtubeView);
        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                int sum = ((BetterKcal) BetterKcal.context_sumkcal).sumkcal;
                if(sum <=0 && sum <= 500){
                    youTubePlayer.loadVideo("ECu-P8IqgHU");
                }
                if(sum <= 1000){
                    youTubePlayer.loadVideo("4EKo44DUvjg");
                }
                else{
                    youTubePlayer.loadVideo("gMaB-fG4u4g");
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                youtubeView.initialize("AIzaSyAhdEWLz2hRScd9OsKI516Bcm3LVs69Lq4",listener);
            }
        });

    }
}