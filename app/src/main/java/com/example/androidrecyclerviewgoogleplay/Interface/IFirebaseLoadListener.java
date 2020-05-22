package com.example.androidrecyclerviewgoogleplay.Interface;

import com.example.androidrecyclerviewgoogleplay.Model.ItemGroup;

import java.util.List;

public interface IFirebaseLoadListener {

    void onFirebaseLoadSuccess(List<ItemGroup> itemGroupList);
    void onFirebaseLoadFailed(String message);

}
