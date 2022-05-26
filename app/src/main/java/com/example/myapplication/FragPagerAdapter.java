package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragPagerAdapter extends FragmentStateAdapter {
    private final int mSetItemCount = 3;
    public FragPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int iViewIdx = getRealPosition(position);
        switch( iViewIdx ) {
            case 0 : { return new ChildFragment1(); }
            case 1 : { return new ChildFragment2(); }
            case 2 : { return new ChildFragment3(); }
            default : { return new ChildFragment1(); } //기본으로 나와있는 프래그먼트
            }
}

    public int getRealPosition(int _iPosition) {
        return _iPosition % mSetItemCount;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

}
