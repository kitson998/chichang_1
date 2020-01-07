package com.example.chichang_1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter_2 extends FragmentPagerAdapter {


    private int numOfTabs;

    PageAdapter_2(FragmentManager fm, int numOfTabs){
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                return new ExpenseFragment_2();
            case 1:
                return new IncomeFragment_2();
            default:
                return null;
        }
    }

    @Override
    public int getCount(){return numOfTabs;}
}