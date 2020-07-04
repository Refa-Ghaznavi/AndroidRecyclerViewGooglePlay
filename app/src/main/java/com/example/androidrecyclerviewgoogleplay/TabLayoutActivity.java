package com.example.androidrecyclerviewgoogleplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.androidrecyclerviewgoogleplay.Adapter.ViewPagerAdapter;
import com.example.androidrecyclerviewgoogleplay.Fragment.FragmentOne;
import com.example.androidrecyclerviewgoogleplay.Fragment.FragmentTwo;
import com.example.androidrecyclerviewgoogleplay.Interface.IFirebaseLoadListener;
import com.google.android.material.tabs.TabLayout;

public class TabLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        final TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.AddFragment(new FragmentOne(),"Websites");
        viewPagerAdapter.AddFragment(new FragmentTwo(),"Apps");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}