package com.example.lastoneforall;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.io.File;


public class videoplayer extends AppCompatActivity {
    PlayerView playerView;
    SimpleExoPlayer simpleExoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplayer);
        String s = getIntent().getStringExtra("hello");

        String pat = getApplicationContext().getExternalCacheDir().getPath() + "/" + "savedvideo" + "/" + s + "/";
        File file = new File(pat);

        if (file.exists()) {

            playerView = findViewById(R.id.player_v);

            simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this);

            DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "how"));


            MediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(pat));

            simpleExoPlayer.prepare(mediaSource);

            playerView.setPlayer(simpleExoPlayer);
            simpleExoPlayer.setPlayWhenReady(true);


        }


    }



}