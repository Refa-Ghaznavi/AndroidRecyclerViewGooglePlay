package com.example.androidrecyclerviewgoogleplay.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class FragmentTwo extends Fragment implements IFirebaseLoadListener {

    View v;

    AlertDialog dialog;
    IFirebaseLoadListener iFirebaseLoadListener;

    RecyclerView my_recycler_view_two;


    DatabaseReference myData;

    public FragmentTwo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_two, container, false);

        // init
        myData = FirebaseDatabase.getInstance().getReference("MyData");
        dialog = new SpotsDialog.Builder().setContext(getActivity()).build();
        iFirebaseLoadListener = this;

        // view
        my_recycler_view_two = (RecyclerView)v. findViewById(R.id.my_recycler_view_two);
        my_recycler_view_two.setHasFixedSize(true);
        my_recycler_view_two.setLayoutManager(new LinearLayoutManager(getActivity()));

        getFirebaseData();

        return v;
    }

    private void getFirebaseData() {

        dialog.show();
        myData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<ItemGroup> itemGroups = new ArrayList<>();
                for (DataSnapshot groupSnapShot : dataSnapshot.getChildren()) {
                    ItemGroup itemGroup = new ItemGroup();
                    itemGroup.setHeaderTitle(groupSnapShot.child("headerTitle").getValue(true).toString());
                    GenericTypeIndicator<ArrayList<ItemData>> genericTypeIndicator = new GenericTypeIndicator<ArrayList<ItemData>>() {};
                    itemGroup.setListItem(groupSnapShot.child("listItem").getValue(genericTypeIndicator));
                    itemGroups.add(itemGroup);
                }
                iFirebaseLoadListener.onFirebaseLoadSuccess(itemGroups);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                iFirebaseLoadListener.onFirebaseLoadFailed(databaseError.getMessage());
            }
        });
    }

    @Override
    public void onFirebaseLoadSuccess(List<ItemGroup> itemGroupList) {

    }

    @Override
    public void onFirebaseLoadFailed(String message) {

    }
}