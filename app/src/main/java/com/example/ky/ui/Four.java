package com.example.ky.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.view.ActionMode;

import java.util.ArrayList;
import java.util.List;

public class Four extends AppCompatActivity {
    private ListView listView;
    private List<Item> list;
    private BaseAdapter adapter;
    private String [] name = {"One","Two","Three","Four","Five","Six"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four );

        listView = findViewById(R.id.list_view);
        list = new ArrayList<Item>();
        //赋值
        for(int i = 0; i < 6; i++){
            list.add(new Item(name[i], false));
        }
        //适配
        adapter = new AdapterCur(list, Four.this);
        listView.setAdapter(adapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new MultiChoiceModeListener() {
            //选中数量
            int num = 0;
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

                // 调整选定条目
                if (checked == true) {
                    list.get(position).setBo(true);
                    //实时刷新
                    adapter.notifyDataSetChanged();
                    num++;
                } else {
                    list.get(position).setBo(false);
                    //实时刷新
                    adapter.notifyDataSetChanged();
                    num--;
                }
                // 用TextView显示

                mode.setTitle("  " + num + " Selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {

                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.four, menu);
                num = 0;
                adapter.notifyDataSetChanged();
                return true;

            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

                adapter.notifyDataSetChanged();
                return false;
            }
            public void refresh(){
                for(int i = 0; i < 6; i++){
                    list.get(i).setBo(false);
                }
            }
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    //全选
                    case R.id.menu_all:
                        num = 0;
                        refresh();
                        adapter.notifyDataSetChanged();
                        mode.finish(); // Action picked, so close the CAB
                        return true;
                    //删除
                    case R.id.no:
                        adapter.notifyDataSetChanged();
                        num = 0;
                        refresh();
                        mode.finish();
                        return true;
                    default:
                        refresh();
                        adapter.notifyDataSetChanged();
                        num = 0;
                        return false;
                }

            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                refresh();
                adapter.notifyDataSetChanged();

            }


        });



    }
}

