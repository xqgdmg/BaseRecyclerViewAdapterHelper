package com.chad.baserecyclerviewadapterhelper.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.adapter.ItemClickAdapter;
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity;
import com.chad.baserecyclerviewadapterhelper.entity.ClickEntity;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class ItemClickActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private ItemClickAdapter adapter;
    private static final int PAGE_SIZE = 10;
    private static String TAG = "ItemClickActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackBtn();
        setTitle("ItemClickActivity Activity");
        setContentView(R.layout.activity_item_click);
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initAdapter();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemClick: ");
                Toast.makeText(ItemClickActivity.this, "onItemClick" + position, Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemLongClick: ");
                Toast.makeText(ItemClickActivity.this, "onItemLongClick" + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Log.e("chris","view.getId()==" + view.getId());
                if (view.getId() == R.id.iv_num_reduce){
                    Toast.makeText(ItemClickActivity.this, "iv_num_reduce" + position, Toast.LENGTH_SHORT).show();
                }else if (view.getId() == R.id.iv_num_add){
                    Toast.makeText(ItemClickActivity.this, "iv_num_add" + position, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ItemClickActivity.this, "onItemChildClick" + position, Toast.LENGTH_SHORT).show();
                }
                Log.d(TAG, "onItemChildClick: ");

            }
        });
        adapter.setOnItemChildLongClickListener(new BaseQuickAdapter.OnItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemChildLongClick: ");
                Toast.makeText(ItemClickActivity.this, "onItemChildLongClick" + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    private void initAdapter() {
        List<ClickEntity> data = new ArrayList<>();
        data.add(new ClickEntity(ClickEntity.CLICK_ITEM_VIEW));
        data.add(new ClickEntity(ClickEntity.CLICK_ITEM_CHILD_VIEW));
        data.add(new ClickEntity(ClickEntity.LONG_CLICK_ITEM_VIEW));
        data.add(new ClickEntity(ClickEntity.LONG_CLICK_ITEM_CHILD_VIEW));
        data.add(new ClickEntity(ClickEntity.NEST_CLICK_ITEM_CHILD_VIEW));
        adapter = new ItemClickAdapter(data);
        adapter.openLoadAnimation();
        mRecyclerView.setAdapter(adapter);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

}
