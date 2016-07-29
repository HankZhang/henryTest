package com.zh.test;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;


import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ListView listview;
    private List<String> urls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main2);
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
            SimpleDraweeView iv;
            if(convertView == null){
                convertView = LayoutInflater.from(Main2Activity.this).inflate(R.layout.item_img,null);
                iv = (SimpleDraweeView)convertView.findViewById(R.id.my_image_view);
                convertView.setTag(iv);
            }else{
                iv = (SimpleDraweeView)convertView.getTag();
            }

            Uri uri = Uri.parse(getItem(position));
            Log.e("mm","uri = "+uri.toString());
            DraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setUri(uri)
                    .setAutoPlayAnimations(true)
                    .build();
            iv.setController(controller);
            return convertView;
        }
    };
}
