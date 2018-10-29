package com.example.pingyandong.tablayoutdemo;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pingyandong.tablayoutdemo.fragement.ChatFragment;
import com.example.pingyandong.tablayoutdemo.fragement.WechatFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //TabLayout
    private TabLayout mTabLayout;
    //ViewPager
    private ViewPager mViewPager;
    //Title
    private List<String> mTitle;
    //Fragment
    private List<Fragment> mFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    //初始化数据
    private  void initData(){
        mTitle = new ArrayList<>();
        mTitle.add(getString(R.string.tab_manager));
        mTitle.add(getString(R.string.tops));
        mTitle.add(getString(R.string.girls));
        mTitle.add(getString(R.string.mine));


        mFragment = new ArrayList<>();
        mFragment.add(new ChatFragment());
        mFragment.add(new ChatFragment());
        mFragment.add(new ChatFragment());
        mFragment.add(new ChatFragment());

    }

    //初始化View
    private  void initView(){
        mTabLayout =  (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.mViewPage);

        //预加载
        mViewPager.setOffscreenPageLimit(mFragment.size());

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //选中的item
            @Override
            public Fragment getItem(int i) {
                return mFragment.get(i);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }

            //标题
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });

        //绑定
        mTabLayout.setupWithViewPager(mViewPager);

    }


}
