package com.example.root.videoview;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.VideoView;

public class Main2Activity extends AppCompatActivity {

    VideoView videoView;
    Dialog videoDialog;

    static String name[]={"video_one","video_two","video_three"};
    static int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        videoDialog = new Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        videoDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        videoDialog.setContentView(R.layout.video_fragment);
        // videoDialog.setOnKeyListener();
        videoView = (VideoView) videoDialog.findViewById(R.id.videoView2);
        videoDialog.show();
        videoView.requestFocus();

        videoView.setVideoPath(getPath(index));
        index++;

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.start();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (index == name.length)
                    index = 0;

                videoView.setVideoPath(getPath(index));
                index++;
            }
        });

    
        }
    private String getPath(int id) {
        return "android.resource://com.example.root.videoview/raw/" + name[id];
    }
        
    }


