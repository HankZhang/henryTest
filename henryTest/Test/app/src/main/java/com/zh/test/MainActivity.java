package com.zh.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private List<String> urls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listview);

        urls.add("http://img.huofar.com/data/jiankangrenwu/shizi.gif");
        urls.add("http://pic.shijue.me/picurl/2fb9c3733ee14fb29ed2c7c491ab9f8d_d---gif?code=b71abc23485765da");
        urls.add("http://ww2.sinaimg.cn/large/85cccab3tw1esjq9r0pcpg20d3086qtr.jpg");
        urls.add("http://ww2.sinaimg.cn/large/85cccab3tw1esjq046gyzg206h0b4hc9.jpg");
        urls.add("http://ww3.sinaimg.cn/large/85cccab3tw1esjpzs7j64g20in07t7uk.jpg");
        urls.add("http://ww1.sinaimg.cn/large/85cccab3tw1esjpx9nljeg208y05nh16.jpg");
        urls.add("http://ww4.sinaimg.cn/large/85cccab3tw1esjptqqhgzg20fu0cvkjl.jpg");
        urls.add("http://ww1.sinaimg.cn/large/85cccab3tw1esjqa3oq24g20dw07tk67.jpg");
        urls.add("http://ww2.sinaimg.cn/large/85cccab3tw1esjq6zo3q1g20d106znpd.jpg");

        urls.add("http://ww2.sinaimg.cn/large/85cccab3tw1esjq9r0pcpg20d3086qtr.jpg");
        urls.add("http://ww2.sinaimg.cn/large/85cccab3tw1esjq046gyzg206h0b4hc9.jpg");
        urls.add("http://ww3.sinaimg.cn/large/85cccab3tw1esjpzs7j64g20in07t7uk.jpg");
        urls.add("http://ww1.sinaimg.cn/large/85cccab3tw1esjpx9nljeg208y05nh16.jpg");
        urls.add("http://ww4.sinaimg.cn/large/85cccab3tw1esjptqqhgzg20fu0cvkjl.jpg");
        urls.add("http://ww1.sinaimg.cn/large/85cccab3tw1esjqa3oq24g20dw07tk67.jpg");
        urls.add("http://ww2.sinaimg.cn/large/85cccab3tw1esjq6zo3q1g20d106znpd.jpg");

        urls.add("http://ww2.sinaimg.cn/large/85cccab3tw1esjq9r0pcpg20d3086qtr.jpg");
        urls.add("http://ww2.sinaimg.cn/large/85cccab3tw1esjq046gyzg206h0b4hc9.jpg");
        urls.add("http://ww3.sinaimg.cn/large/85cccab3tw1esjpzs7j64g20in07t7uk.jpg");
        urls.add("http://ww1.sinaimg.cn/large/85cccab3tw1esjpx9nljeg208y05nh16.jpg");
        urls.add("http://ww4.sinaimg.cn/large/85cccab3tw1esjptqqhgzg20fu0cvkjl.jpg");
        urls.add("http://ww1.sinaimg.cn/large/85cccab3tw1esjqa3oq24g20dw07tk67.jpg");
        urls.add("http://ww2.sinaimg.cn/large/85cccab3tw1esjq6zo3q1g20d106znpd.jpg");

        listview.setAdapter(adapter);

    }


    public void onNext(View view){
        startActivity(new Intent(this,Main2Activity.class));
    }

    private BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return urls.size();
        }

        @Override
        public String getItem(int position) {
            return urls.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView iv = new ImageView(getApplicationContext());
            AbsListView.LayoutParams params = new AbsListView.LayoutParams(600,600);
            iv.setLayoutParams(params);
            Glide.with(MainActivity.this).load(getItem(position)).fitCenter().into(iv);
            return iv;
        }
    };
}
