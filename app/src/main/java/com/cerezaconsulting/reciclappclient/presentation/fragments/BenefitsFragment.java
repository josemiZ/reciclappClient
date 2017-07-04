package com.cerezaconsulting.reciclappclient.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.core.BaseFragment;
import com.cerezaconsulting.reciclappclient.presentation.adapters.FragmentViewPagerAdapter;
import com.cerezaconsulting.reciclappclient.presentation.presenters.GetBenefitsPresenter;
import com.cerezaconsulting.reciclappclient.presentation.presenters.MyBenefitsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by miguel on 30/05/17.
 */

public class BenefitsFragment extends BaseFragment {

    @BindView(R.id.tl_benefits)
    TabLayout tlBenefits;
    @BindView(R.id.vp_benefits)
    ViewPager vpBenefits;
    Unbinder unbinder;

    public static BenefitsFragment newInstance() {
        return new BenefitsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_benefits, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViewPager(vpBenefits);
        tlBenefits.setupWithViewPager(vpBenefits);
    }

    private void setupViewPager(ViewPager viewPager) {
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(getActivity().getSupportFragmentManager());
        GetBenefitsFragment getBenefitsFragment = GetBenefitsFragment.newInstance();
        new GetBenefitsPresenter(getBenefitsFragment,getContext());
        adapter.addFragment(getBenefitsFragment, getString(R.string.get_benefits));
        MyBenefitsFragment myBenefitsFragment = MyBenefitsFragment.newInstance();
        new MyBenefitsPresenter(myBenefitsFragment,getContext());
        adapter.addFragment(myBenefitsFragment, getString(R.string.my_benefits));
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
