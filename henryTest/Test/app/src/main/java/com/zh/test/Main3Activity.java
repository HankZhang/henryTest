package com.zh.test;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import pl.droidsonroids.gif.MultiCallback;

public class Main3Activity extends AppCompatActivity {
    GifImageView gifIv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        gifIv = (GifImageView)findViewById(R.id.gif_iv);
        loadGif();
    }

    private void loadGif(){
        AsyncTask task = new AsyncTask<Object, Object, InputStream>() {
            @Override
            protected InputStream doInBackground(Object[] params) {
                String gif_url = "http://ww2.sinaimg.cn/large/85cccab3tw1esjq9r0pcpg20d3086qtr.jpg";
                URL url= null;
                try {
                    url = new URL(gif_url);
                    HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                    //取得inputStream，并进行读取
                    InputStream input=conn.getInputStream();
                    Log.e("mm","length = "+input.available());
                    return input;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(InputStream o) {
                super.onPostExecute(o);
                BufferedInputStream bis = null;
                try {
                    bis = new BufferedInputStream(o,o.available());
                    GifDrawable gifFromStream = new GifDrawable(bis);
                    MultiCallback multiCallback = new MultiCallback();

                    gifIv.setImageDrawable(gifFromStream);
                    multiCallback.addView(gifIv);
                    gifFromStream.setCallback(multiCallback);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        task.execute();
    }
}
