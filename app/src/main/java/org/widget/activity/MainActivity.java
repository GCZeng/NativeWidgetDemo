package org.widget.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import org.widget.R;
import org.widget.activity.base.BaseActivity;
import org.widget.adapter.HomeLVAdapter;
import org.widget.adapter.base.OnItemClickListener;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {
    private RecyclerView rv_list;

    private List<String> mData;
    private HomeLVAdapter mAdapter;

    @Override
    protected int providerLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("控件Demo");

        initView();

        initList();
    }

    @Override
    protected void initView() {
        rv_list = (RecyclerView) findViewById(R.id.rv_list);
    }

    @Override
    protected void initData() {

    }

    /**
     * init ListView
     */
    private void initList() {

        String[] titles = getResources().getStringArray(R.array.title);
        mData = Arrays.asList(titles);

        mAdapter = new HomeLVAdapter(mData);

        //设置布局管理器
//        rv_list.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rv_list.setLayoutManager(new LinearLayoutManager(this));

        //设置adapter
        rv_list.setHasFixedSize(true);

        rv_list.setAdapter(mAdapter);

        mAdapter.setmOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        Bundle bundle = new Bundle();
                        bundle.putString("title",mData.get(position));
                        goActivity(TextInputLayoutActivity.class,bundle);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "点击:" + mData.get(position), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        //间隔
//        rv_list.addItemDecoration(new HomeItemDecoration(this));
    }
}
