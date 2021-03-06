package com.example.ky.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class One extends AppCompatActivity {

    private String []names=new String []{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[]imgIds=new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);
        final List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        for(int i=0;i<names.length;i++){
            Map<String,Object>showItem=new HashMap<String, Object>();
            showItem.put("img",imgIds[i]);
            showItem.put("name",names[i]);
            list.add(showItem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.one_1,new String[]{"img","name"},new int[]{R.id.image,R.id.name});
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView parent, View view,int position,long id){
                Toast.makeText(One.this,names[position],Toast.LENGTH_LONG).show();
            }
        });
    }

}
