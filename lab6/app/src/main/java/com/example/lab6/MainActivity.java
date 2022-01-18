package com.example.lab6;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {
    int counter=0;
    AtomicBoolean isRecording = new AtomicBoolean(false);
    AtomicBoolean isRecording2 = new AtomicBoolean(false);
    Thread read = null;
    Thread write = null;
    MediaRecorder mediaRecord=new MediaRecorder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button button= (Button) findViewById(R.id.button2);
//        button.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.O)
//            @Override
//            public void onClick(View v) {
//               toggleMedia(v);
//
//
//            }
//        });

//        if ((ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_DENIED)) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 0);
//        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void toggleRecord(View view) {
        isRecording.set(!isRecording.get());
        if (!isRecording.get()) {
            stopRecord();
        } else {
            startRecord();
        }
    }

    public void stopRecord() {
        ((TextView) findViewById(R.id.current)).setText("Recording stopped");
        ((Button) findViewById(R.id.button)).setText("New record");
        try {
            read.join();
            write.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void toggleMedia(View view) {
        isRecording2.set(!isRecording2.get());
        if (!isRecording2.get()) {
            stopMedia();
        } else {
            recordMediaPlayer();
        }
    }
    public void stopMedia() {
        ((TextView) findViewById(R.id.current)).setText("Recording stopped");
        ((Button) findViewById(R.id.button2)).setText("New record");
        if(isRecording2.get()) {
            mediaRecord.reset();
            mediaRecord.release();
            mediaRecord.stop();


            mediaRecord = null;
        }
    }

public void recordMediaPlayer(){
    ((TextView) findViewById(R.id.current)).setText("Recording on");
    ((Button) findViewById(R.id.button2)).setText("Stop record");
    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 0);
    }else {

     mediaRecord.setAudioSource(MediaRecorder.AudioSource.MIC);
     mediaRecord.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
     mediaRecord.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
     String dirPath=getApplicationContext().getFilesDir().toString();
     mediaRecord.setOutputFile(dirPath+"/newRecord.mp4");
        try {
            mediaRecord.prepare();
            mediaRecord.start();
            System.out.println("here we record");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void startRecord() {
        ((TextView) findViewById(R.id.current)).setText("Recording on");
        ((Button) findViewById(R.id.button)).setText("Stop record");
        LinkedBlockingQueue<byte[]> queque = new LinkedBlockingQueue<>();


        read = new Thread(() -> {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 0);
            }else {
                AudioRecord recording = new AudioRecord(
                        MediaRecorder.AudioSource.MIC,
                        44100, AudioFormat.CHANNEL_IN_MONO,
                        AudioFormat.ENCODING_PCM_8BIT,
                        16 * 1924);
                recording.startRecording();


                while (isRecording.get()) {
                    byte[] buffer = new byte[16 * 1924];

                    int bytesNum = recording.read(buffer, 0, buffer.length);
                    if (bytesNum < 0) {

                    } else {
                        try {
                            queque.put(buffer);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                try {
                    queque.put(new byte[0]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    });


    write= new Thread(()->{
        ArrayList<byte[]> content=new ArrayList<>();

        try {
            while(isRecording.get()){
                content.add(queque.take());
            }
            queque.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File dir =this.getFilesDir();
        Path p=null;
        try {
            p = Files.createFile(dir.toPath().resolve("recording" + counter + ".wav"));
            counter++;

            OutputStream output=new FileOutputStream(p.toFile());
            writeHeader(output,content);
            for(byte[] b: content) {
                output.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




    });
    read.start();
    write.start();




    }

    private void writeHeader(OutputStream output, ArrayList<byte[]> content) throws IOException{
        int dataLen=0;
        for(byte[] b: content){
            dataLen +=b.length;
        }
        int totalLen=dataLen+36;
        int byteRate=44100;
        byte[] header =new byte[44];
        header[0]='R';
        header[1]='I';
        header[2]='F';
        header[3]='F';
        header[4]=(byte)(totalLen&0xff);
        header[5]=(byte)((totalLen>>8)&0xff);
        header[6]=(byte)((totalLen>>16)&0xff);
        header[7]=(byte)((totalLen>>24)&0xff);
        header[8]='W';
        header[9]='A';
        header[10]='V';
        header[11]='E';
        header[12]='f';
        header[13]='m';
        header[14]='t';
        header[15]=' ';
        header[16]=16;
        header[17]=0;
        header[18]=0;
        header[19]=0;
        header[20]=1;
        header[21]=0;
        header[22]=1;
        header[23]=0;
        header[24]=(byte)(44100&0xff);
        header[25]=(byte)((44100>>8)&0xff);
        header[26]=(byte)((44100>>16)&0xff);
        header[27]=(byte)((44100>>24)&0xff);
        header[28]=(byte)(byteRate&0xff);
        header[29]=(byte)((byteRate>>8)&0xff);
        header[30]=(byte)((byteRate>>16)&0xff);
        header[31]=(byte)((byteRate>>24)&0xff);
        header[32]=1;
        header[33]=0;
        header[34]=0;
        header[35]=0;
        header[36]='d';
        header[37]='a';
        header[38]='t';
        header[39]='a';
        header[40]=(byte)(dataLen&0xff);
        header[41]=(byte)((dataLen>>8)&0xff);
        header[42]=(byte)((dataLen>>8)&0xff);
        header[43]=(byte)((dataLen>>8)&0xff);






    }
}