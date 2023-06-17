package com.example.lastoneforall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class play_video extends AppCompatActivity {
    private ArrayList<String> callforduty;
    private PlayerView playerView;
    private SimpleExoPlayer simpleExoPlayer;
    private DataSource.Factory datasourcefactory;
    private String path;
    private HashMap<String,String> readyforvideo=new HashMap<>();
    private  ArrayList<String>paths=new ArrayList<String>();
    private ConcatenatingMediaSource concatenatedSource;
    private  String[] splitter;
    private String split;
    private  String pathforextra;
    private DatabaseReference myRef;
    private  String  videoenamefordownlaoding;
    private StorageReference mStorageRef;
    private String Destinationdirectory;

    private ProgressDialog loadprogress;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private Integer counting=0;
    private ArrayList<Long>downloadID=new ArrayList<>();
    private Integer downloadCounting=0;
    private ArrayList<Long>id=new ArrayList<>();
    private ArrayList<String>forSearch=new ArrayList<>();
    private int i;

private BroadcastReceiver onDownloadComplete=new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        id.add(intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1));

      //  show("kala");
       i++;
       if(i==counting)
       {
          // show("fuck you ");
           readymediasorce();
           //readymediasorce();
              exoplayer();

       }




    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        callforduty= (ArrayList<String>)getIntent().getSerializableExtra("videotoplay");
        split=callforduty.get(0);
        splitter=split.split(" ");
        registerReceiver(onDownloadComplete,new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        //show(""+splitter[0]);
        database = FirebaseDatabase.getInstance();

        myRef = database.getReference();

        //myRef.setValue("gag");
        //show("path"+myRef.getRef().toString());
        Destinationdirectory=getApplicationContext().getExternalFilesDir(null).getAbsolutePath()+"/"+"extravideo";
        path=getApplicationContext().getExternalFilesDir("/").getAbsolutePath()+"/"+"storage"+"/"+"emulated"+"/"+"0"+"/"+"Android"+"/"+"data"+"/"+"com.example.lastoneforall"+"/"+"files"+"/"+"extravideo";
        //path=getApplicationContext().getExternalFilesDir("/").getAbsolutePath()+"/"+"extravideo";
        File fileforcheck=new File(path);

        if(fileforcheck.exists())
        {
            File[]files=fileforcheck.listFiles();
           // show(""+files.length);
        }

      //  show("amar theke path"+path);







        mStorageRef = FirebaseStorage.getInstance().getReference();
        loadprogress=new ProgressDialog(this);
        loadprogress.setTitle("Ready Video");
        loadprogress.setMessage("Please wait patiently");

        loadprogress.setCanceledOnTouchOutside(false);

        playerView=findViewById(R.id.player_view);
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this);
        datasourcefactory=new DefaultDataSourceFactory(this, Util.getUserAgent(this, "completeproject"));







           readythepath();
        //readymediasorce();
     //   exoplayer();




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
                 forSearch.add(splitter[k]);
                  // countingthematch(splitter[k]);
                    searchanddownloadformdatabase(splitter[k]);
                   // show(""+splitter[k]);
                    paths.add(path + "/" + splitter[k]+".mp4");//we need to work on that







            }






        }


    }





    void exoplayer()
    {
        simpleExoPlayer.prepare(concatenatedSource);
        playerView.setPlayer(simpleExoPlayer);
        simpleExoPlayer.setPlayWhenReady(true);
    }



    void readymediasorce()
    {
        // String path=Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+"b.mp4.mp4"+"/";

        //  File pat=new File(path);


        MediaSource[] mediaSources;

        mediaSources = new MediaSource[paths.size()];


        for (int j = 0; j < paths.size(); j++) {

            MediaSource media = new ExtractorMediaSource.Factory(datasourcefactory).createMediaSource(Uri.parse(paths.get(j)));

            mediaSources[j] = media;
        }
        concatenatedSource = new ConcatenatingMediaSource(mediaSources);




    }
    private boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    void searchanddownloadformdatabase( String key)
    {
       // show(""+key);


//show("coming for search");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                if(dataSnapshot.child(key).exists())
                {   // show(""+keythat);

                  counting++;
                    String keyforadding=dataSnapshot.child(key).getValue().toString();
                    StorageReference reference=mStorageRef.child(keyforadding);

                    reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                                        @Override
                                                                        public void onSuccess(Uri uri) {
                                                                            String u=uri.toString();
                                                                            downloadFile(play_video.this,key,".mp4",u);

                                                                        }
                                                                    }


                    ).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                    {

                    }

                }
                Toast.makeText(play_video.this,"sorry it is not available right now in our server",Toast.LENGTH_LONG).show();
               // show("fucking outter side");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void downloadFile (Context context,String filename,String fileextension,String url)

    {


        String Destinationdirectory=getApplicationContext().getExternalFilesDir(null).getAbsolutePath()+"/"+"extravideo";
        File filefor =new File(Destinationdirectory);
        if(!filefor.exists())
        {
            filefor.mkdirs();
        }
        DownloadManager downloadManager= (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri=Uri.parse(url);
        //show(""+uri);
        DownloadManager.Request request=new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        //show(""+filename);
        request.setDestinationInExternalFilesDir(context,Destinationdirectory,filename+fileextension);
      downloadID.add (downloadManager.enqueue(request));

    }

    @Override
    public void onBackPressed() {

        Intent intent=new Intent(this,MainActivity.class) ;
        intent.putExtra("formerger",paths);
        startActivity(intent);
        super.onBackPressed();
    }

}