package com.example.gestiononglets.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gestiononglets.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    public static int getImage(String s){
        if(s.equals("Hiver"))     return R.drawable.winter;
        if(s.equals("Printemps")) return R.drawable.spring;
        if(s.equals("Eté"))       return R.drawable.summer;
        if(s.equals("Automne"))   return R.drawable.autumn;
        return 0;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position) {
            case 0:
                return SeasonsFragment.newInstance(0, mContext.getString(R.string.titre_section4));
            case 1:
                return SeasonsFragment.newInstance(1, mContext.getString(R.string.titre_section5));
            case 2:
                return SeasonsFragment.newInstance(2, mContext.getString(R.string.titre_section5));
            case 3:
                return SeasonsFragment.newInstance(2, mContext.getString(R.string.titre_section6));
            case 4:
                return SeasonsFragment.newInstance(2, mContext.getString(R.string.titre_section7));
        }
        return null;
    }




    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}