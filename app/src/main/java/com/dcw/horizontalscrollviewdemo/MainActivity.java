package com.dcw.horizontalscrollviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CustomHorizontalScrollView mHorizontalScrollView;
    private HorizontalScrollViewAdapter mAdapter;
    private List<Integer> mDatas = new ArrayList<>(Arrays.asList(
            R.mipmap.partner01, R.mipmap.partner02, R.mipmap.partner03, R.mipmap.partner01, R.mipmap.partner02,
            R.mipmap.partner03));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        mHorizontalScrollView = (CustomHorizontalScrollView) findViewById(R.id.id_horizontalScrollView);
        mAdapter = new HorizontalScrollViewAdapter(this, mDatas);
        //添加滚动回调
        mHorizontalScrollView
                .setCurrentImageChangeListener(new CustomHorizontalScrollView.CurrentImageChangeListener() {
                    @Override
                    public void onCurrentImgChanged(int position,
                                                    View viewIndicator) {
                        viewIndicator.setBackgroundColor(Color.GRAY);
                    }
                });
        //添加点击回调
        mHorizontalScrollView.setOnItemClickListener(new CustomHorizontalScrollView.OnItemClickListener() {

            @Override
            public void onClick(View view, int position) {
                view.setBackgroundColor(Color.GRAY);
            }
        });
        //设置适配器
        mHorizontalScrollView.initDatas(mAdapter);
    }
}
