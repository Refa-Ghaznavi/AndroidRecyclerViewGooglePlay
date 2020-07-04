package com.example.androidrecyclerviewgoogleplay.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.androidrecyclerviewgoogleplay.Adapter.MyItemGroupAdapter;
import com.example.androidrecyclerviewgoogleplay.Interface.IFirebaseLoadListener;
import com.example.androidrecyclerviewgoogleplay.Model.ItemData;
import com.example.androidrecyclerviewgoogleplay.Model.ItemGroup;
import com.example.androidrecyclerviewgoogleplay.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;


public class FragmentOne extends Fragment implements IFirebaseLoadListener{


    RecyclerView re;
    View v;
    IFirebaseLoadListener iFirebaseLoadListener;
    AlertDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        dialog =  new SpotsDialog.Builder().setContext(getContext()).build();
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.v=view;
        init();
        loaddata();
        iFirebaseLoadListener = this;

    }

    private void loaddata() {
        DatabaseReference db = FirebaseDatabase.getInstance().getReference("MyData");
        dialog.show();
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<ItemGroup> itemGroups = new ArrayList<>();
                for (DataSnapshot groupSnapShot : snapshot.getChildren()) {
                    ItemGroup itemGroup = new ItemGroup();
                    itemGroup.setHeaderTitle(groupSnapShot.child("headerTitle").getValue(true).toString());
                    GenericTypeIndicator<ArrayList<ItemData>> genericTypeIndicator = new GenericTypeIndicator<ArrayList<ItemData>>() {};
                    itemGroup.setListItem(groupSnapShot.child("listItem").getValue(genericTypeIndicator));
                    itemGroups.add(itemGroup);
                }
                iFirebaseLoadListener.onFirebaseLoadSuccess(itemGroups);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                iFirebaseLoadListener.onFirebaseLoadFailed(error.getMessage());
            }
        });
    }

    private void init() {
        re = (RecyclerView)v.findViewById(R.id.my_recycler_view_one);
        re.setHasFixedSize(true);
        re.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onFirebaseLoadSuccess(List<ItemGroup> itemGroupList) {

        MyItemGroupAdapter adapter = new MyItemGroupAdapter(getContext(),itemGroupList);
        re.setAdapter(adapter);

        dialog.dismiss();
    }

    @Override
    public void onFirebaseLoadFailed(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }
}