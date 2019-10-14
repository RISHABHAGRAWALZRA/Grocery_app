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

import com.example.groceryapp.Models.GroceryItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

public class mainFragment extends Fragment {
    private static final String TAG = "mainFragment";

    private BottomNavigationView bottomNavigationView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.main_layout,container,false);

        initViews(view);

//        Util util=new Util();
//        util.initDatabase(getContext());
//        SharedPreferences sharedPreferences=getActivity()
//                .getSharedPreferences("fake_database", Context.MODE_PRIVATE);
//        String returnedValue=sharedPreferences.getString("cheese","");
//        Gson gson=new Gson();
//        GroceryItem cheese=gson.fromJson(returnedValue,GroceryItem.class);


        clickBottomNavigation();

        return view;


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
                    case R.id.home:
                        Toast.makeText(getContext(), "Home selected", Toast.LENGTH_SHORT).show();
                        break;
                    default:break;
                }

                return true;
            }
        });
    }

    private void initViews(View view){

        bottomNavigationView= (BottomNavigationView) view.findViewById(R.id.bottom_navigationPanel);
    }
}
