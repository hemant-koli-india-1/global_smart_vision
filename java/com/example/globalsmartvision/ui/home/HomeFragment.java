package com.example.globalsmartvision.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.globalsmartvision.R;
import com.example.globalsmartvision.adapters.HomeHorAdapter;
import com.example.globalsmartvision.adapters.HomeVerAdapter;
import com.example.globalsmartvision.adapters.UpdateVerticalRec;
import com.example.globalsmartvision.databinding.FragmentHomeBinding;
import com.example.globalsmartvision.models.HomeHorModel;
import com.example.globalsmartvision.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateVerticalRec {
    RecyclerView homeHorizontalRec,homeVerticalRec;
    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;


    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root =inflater .inflate(R.layout.fragment_home, container, false);
        homeHorizontalRec=root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);

        ///////////horizintal Recycler View
        homeHorModelList = new ArrayList<>();

        homeHorModelList.add(new HomeHorModel(R.drawable.pizza,"Pizza"));
        homeHorModelList.add(new HomeHorModel(R.drawable.hamburger,"Hamburger"));
        homeHorModelList.add(new HomeHorModel(R.drawable.fried_potatoes,"Fries"));
        homeHorModelList.add(new HomeHorModel(R.drawable.ice_cream,"Ice Cream"));
        homeHorModelList.add(new HomeHorModel(R.drawable.sandwich,"Sandwich"));
        //homeHorModelList.add(new HomeHorModel(R.drawable.hemant_photo,"background"));

        homeHorAdapter = new HomeHorAdapter(this,getActivity(),homeHorModelList);

        homeHorizontalRec.setAdapter(homeHorAdapter);

        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);

        /////////////   Vertical Recycler View
        homeVerModelList = new ArrayList<>();


        homeVerAdapter = new HomeVerAdapter(getActivity(),homeVerModelList);

        homeVerticalRec.setAdapter(homeVerAdapter);

        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));



        return root;
    }

    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
        homeVerAdapter= new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);

    }
}