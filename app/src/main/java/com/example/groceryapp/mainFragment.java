package com.example.groceryapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceryapp.Models.GroceryItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.util.ArrayList;

public class mainFragment extends Fragment {
    private static final String TAG = "mainFragment";

    private Util util;

    private RecyclerView newRecVw,popRecVw,sugtRecVw;
    private BottomNavigationView bottomNavigationView;

    private GroceryItem_adapter newadapter,popadapter,sugtadapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.main_layout,container,false);

        initViews(view);

        util=new Util();
        util.initDatabase(getActivity());


//        SharedPreferences sharedPreferences=getActivity()
//                .getSharedPreferences("fake_database", Context.MODE_PRIVATE);
//        String returnedValue=sharedPreferences.getString("cheese","");
//        Gson gson=new Gson();
//        GroceryItem cheese=gson.fromJson(returnedValue,GroceryItem.class);


        initrecyVw();

        clickBottomNavigation();

        return view;

    }

    private void initrecyVw(){

        newadapter=new GroceryItem_adapter(getActivity());
        popadapter=new GroceryItem_adapter(getActivity());
        sugtadapter=new GroceryItem_adapter(getActivity());

        newRecVw.setAdapter(newadapter);
        popRecVw.setAdapter(popadapter);
        sugtRecVw.setAdapter(sugtadapter);

        newRecVw.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        popRecVw.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        sugtRecVw.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));

        ArrayList<GroceryItem> allItems=util.getAllitems(getActivity());
        if(allItems!=null){
            newadapter.setList(allItems);
        }

    }

    private void clickBottomNavigation(){
        Log.d(TAG, "clickBottomNavigation: started");
        bottomNavigationView.setSelectedItemId(R.id.homeActivity);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.cart:
                        break;
                    case R.id.search:
                        break;
                    case R.id.homeActivity:
                        Toast.makeText(getContext(), "Home selected", Toast.LENGTH_SHORT).show();
                        break;
                    default:break;
                }
                return true;
            }
        });
    }

    private void initViews(View view){

        bottomNavigationView=view.findViewById(R.id.bottom_navigationPanel);
        newRecVw=view.findViewById(R.id.recyclerNew);
        popRecVw=view.findViewById(R.id.recyclerPop);
        sugtRecVw=view.findViewById(R.id.recyclerSugt);

    }
}
