package com.example.lastoneforall;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.coremedia.iso.boxes.Container;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.container.mp4.MovieCreator;
import com.googlecode.mp4parser.authoring.tracks.AppendTrack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ArrayList<String> Inputarray = new ArrayList<String>();
  private  String tosplit;
    //implements View.OnClickListener
   private String[] splitter;
    //Button save;
    private String path;




    PlayerView playerView;
    SimpleExoPlayer simpleExoPlayer;
    ImageView bgapp, clover,speak,save,list,play,write;
    Animation bganim, cloveranim,frombottom;
    LinearLayout textsplash,texthome,menus;

    //  HashMap<String, String> readyforvideo = new HashMap<>();
    int k = 0;
    //  String path;
    ArrayList<String> paths ;

    ConcatenatingMediaSource concatenatedSource;
    DataSource.Factory datasourcefactory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        persmission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        persmission(Manifest.permission.READ_EXTERNAL_STORAGE);
        speak=findViewById(R.id.speak);
        play=findViewById(R.id.play);
        // playerView=findViewById(R.id.player_view);
        save=findViewById(R.id.save);
        list=findViewById(R.id.list);
        write=findViewById(R.id.typing);
        write.setOnClickListener(this);
        //speak.setOnClickListener(this);

        bgapp = (ImageView) findViewById(R.id.bgapp);
        clover = (ImageView) findViewById(R.id.clover);
        textsplash = (LinearLayout) findViewById(R.id.textsplash);
        texthome = (LinearLayout) findViewById(R.id.texthome);
        menus = (LinearLayout) findViewById(R.id.menus);



        frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom);


        bganim = AnimationUtils.loadAnimation(this, R.anim.bganim);
        // cloveranim = AnimationUtils.loadAnimation(this, R.anim.cloveranim);

        bgapp.animate().translationY(-3750).setDuration(900).setStartDelay(350);
        clover.animate().alpha(0).setDuration(800).setStartDelay(600);
        textsplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);
        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);

        speak.setOnClickListener(this);
        play.setOnClickListener(this);
        save.setOnClickListener(this);
        list.setOnClickListener(this);
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this);
        datasourcefactory=new DefaultDataSourceFactory(this, Util.getUserAgent(this, "completeproject"));

        persmission(Manifest.permission.CALL_PHONE);
    }





    void persmission (String  permissi)
    {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,permissi
        )
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    permissi)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{permissi},
                        1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }
    }

    public void getspeechInput ()
    {
        Locale locale = new Locale("bn");

        Intent intent=new Intent (RecognizerIntent.ACTION_RECOGNIZE_SPEECH) ;
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,locale.getLanguage());
        if (intent.resolveActivity(getPackageManager())!=null)
        {
            startActivityForResult(intent,2);

        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case 2: {
                if (resultCode == RESULT_OK && data!=null)
                {

                    // a=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    Inputarray  =data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    tosplit=Inputarray.get(0);
                    splitter=tosplit.split(" ");
                    //show(""+splitter[1]);
                    k++;







                }



            }
        }
    }




    void merger ()  {
        int count=paths.size();
        Movie[] movie=new Movie[count];
        for(int i=0;i<count;i++)
        {
            File file =new File (paths.get(i));
            if(file.exists())
            {
                try {
                    movie[i]= MovieCreator.build(file.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        LinkedList<Track> videotrack=new LinkedList<>();
        for(Movie m:movie) {
            for (Track t : m.getTracks()) {
                if (t.getHandler().equals("vide")) {
                    videotrack.add(t);

                }
            }
        }
        Movie result=new Movie();
        if(videotrack.size()>0)
        {

            try {
                result.addTrack(new AppendTrack(videotrack.toArray(new Track[videotrack.size()])));
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        Container out=new DefaultMp4Builder().build(result);
        String pat= getApplicationContext().getExternalCacheDir().getPath()+"/"+"savedvideo"+"/";
        File fileforsavevideo=new File(pat);
        if(!fileforsavevideo.exists())
        {
            fileforsavevideo.mkdirs();

        }
        long timestamp=new Date().getTime();
        String b="muktobak"+timestamp+".mp4";

        File storage=new File(pat,b);
        FileChannel filechannel =null;

        try {
            filechannel =new RandomAccessFile(storage,"rw").getChannel();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            out.writeContainer(filechannel);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            filechannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.speak) {

            getspeechInput();


        }
        if (v.getId() == R.id.play) {
            if(k>=1) {
                Intent play = new Intent(MainActivity.this, play_video.class);
                play.putExtra("videotoplay", Inputarray);
                startActivity(play);
            }
            else{
                Toast.makeText(this,"please speak first..",Toast.LENGTH_SHORT).show();
            }
            //checkforami();


            //simpleExoPlayer= simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this);
            //  readymediasorce();
            //  exoplayer();


        }
        if (v.getId() == R.id.save) {

           try {
               // path=getApplicationContext().getExternalFilesDir("/").getAbsolutePath()+"/"+"storage"+"/"+"emulated"+"/"+"0"+"/"+"Android"+"/"+"data"+"/"+"com.example.lastoneforall"+"/"+"files"+"/"+"extravideo";

               paths = (ArrayList<String>) getIntent().getSerializableExtra("formerger");
               //show("paths" + paths.get(0));


               merger();
           }
               catch(Exception e)
               {
                   Toast.makeText(this,"please play first..",Toast.LENGTH_SHORT).show();
               }




        }
        if (v.getId() == R.id.list) {
            Intent intent = new Intent(this, showmyresult.class);
            startActivity(intent);

        }
        if(v.getId()==R.id.typing)
        {
            Intent intent=new Intent(this,Keyboardforbothir.class);
            startActivity(intent);
        }
    }


    void  show(String string)
   {
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setCancelable(true);
        alert.setMessage(string);
        alert.show();

    }
    void readythepath()

    {


        //   File il=new File(path+"/"+splitter[k]) ;
        for (int k=0;k<splitter.length;k++) {

            String s=path+"/"+splitter[k]+".mp4";
            //show("before"+splitter[k]);
            File il=new File(s) ;


            if(il.exists()) {
                //show("fil.exist");
                paths.add(path + "/" + splitter[k]+".mp4");
            }
            else if(!il.exists()) {
                //  show("!fil.exist");

                Toast.makeText(this,"we will add this video soon from our server",Toast.LENGTH_LONG).show();
              //  searchanddownloadformdatabase(splitter[k]);
                paths.add(path + "/" + splitter[k]+".mp4");







            }






        }


    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
