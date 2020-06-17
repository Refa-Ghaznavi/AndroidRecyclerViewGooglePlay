package com.example.androidrecyclerviewgoogleplay.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidrecyclerviewgoogleplay.DrinkDrink1Activity;
import com.example.androidrecyclerviewgoogleplay.DrinkDrink2Activity;
import com.example.androidrecyclerviewgoogleplay.DrinkDrink3Activity;
import com.example.androidrecyclerviewgoogleplay.DrinkDrink4Activity;
import com.example.androidrecyclerviewgoogleplay.DrinkDrink5Activity;
import com.example.androidrecyclerviewgoogleplay.DrinkMoreActivity;
import com.example.androidrecyclerviewgoogleplay.FruitsAppleActivity;
import com.example.androidrecyclerviewgoogleplay.FruitsBananaActivity;
import com.example.androidrecyclerviewgoogleplay.FruitsCherryActivity;
import com.example.androidrecyclerviewgoogleplay.FruitsMoreActivity;
import com.example.androidrecyclerviewgoogleplay.FruitsOrangeActivity;
import com.example.androidrecyclerviewgoogleplay.FruitsWatermellonActivity;
import com.example.androidrecyclerviewgoogleplay.Model.ItemData;
import com.example.androidrecyclerviewgoogleplay.Model.ItemGroup;
import com.example.androidrecyclerviewgoogleplay.PizzaMoreActivity;
import com.example.androidrecyclerviewgoogleplay.PizzaPizaa2Activity;
import com.example.androidrecyclerviewgoogleplay.PizzaPizza1Activity;
import com.example.androidrecyclerviewgoogleplay.PizzaPizza3;
import com.example.androidrecyclerviewgoogleplay.PizzaPizza4Activity;
import com.example.androidrecyclerviewgoogleplay.PizzaPizza5Activity;
import com.example.androidrecyclerviewgoogleplay.R;
import com.example.androidrecyclerviewgoogleplay.WineMoreActivity;
import com.example.androidrecyclerviewgoogleplay.WineWine1Activity;
import com.example.androidrecyclerviewgoogleplay.WineWine2Activity;
import com.example.androidrecyclerviewgoogleplay.WineWine3Activity;
import com.example.androidrecyclerviewgoogleplay.WineWine4Activity;
import com.example.androidrecyclerviewgoogleplay.WineWine5Activity;

import java.util.List;

public class MyItemGroupAdapter extends RecyclerView.Adapter<MyItemGroupAdapter.MyViewHolder> {

    private Context context;
    private List<ItemGroup> dataList;

    public MyItemGroupAdapter(Context context, List<ItemGroup> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_group,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {


        holder.item_title.setText(dataList.get(position).getHeaderTitle());
        List<ItemData> itemData = dataList.get(position).getListItem();
        if (position == 0){
            MyItemAdapter itemListAdapter = new MyItemAdapter(context,itemData);
            holder.recyclerView_item_list.setHasFixedSize(true);
            holder.recyclerView_item_list.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            holder.recyclerView_item_list.setAdapter(itemListAdapter);
            holder.recyclerView_item_list.setNestedScrollingEnabled(false); // important

            // button more
            holder.btn_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toast.makeText(context, "Button More"+holder.item_title.getText(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(v.getContext(),"position = " + holder.getLayoutPosition(), Toast.LENGTH_SHORT).show();
                    //go through each item if you have few items within recycler view
                        //Do whatever you want
                        Intent intent = new Intent(context, FruitsMoreActivity.class);
                        context.startActivity(intent);
                }
            });
        }
        else if (position==1){

            MyItemAdapterTwo itemListAdapter = new MyItemAdapterTwo(context,itemData);
            holder.recyclerView_item_list.setHasFixedSize(true);
            holder.recyclerView_item_list.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            holder.recyclerView_item_list.setAdapter(itemListAdapter);
            holder.recyclerView_item_list.setNestedScrollingEnabled(false); // important

            // button more
            holder.btn_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(view.getContext(),"position = " + holder.getLayoutPosition(), Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(context, PizzaMoreActivity.class);
                        context.startActivity(intent);

                }
            });
        }
        else if (position==2){

            MyItemAdapterThree itemListAdapter = new MyItemAdapterThree(context,itemData);
            holder.recyclerView_item_list.setHasFixedSize(true);
            holder.recyclerView_item_list.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            holder.recyclerView_item_list.setAdapter(itemListAdapter);
            holder.recyclerView_item_list.setNestedScrollingEnabled(false); // important

            // button more
            holder.btn_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(view.getContext(),"position = " + holder.getLayoutPosition(), Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(view.getContext(), DrinkMoreActivity.class);
                        context.startActivity(intent);
                }
            });
        }
        else if (position==3){

            MyItemAdapterFour itemListAdapter = new MyItemAdapterFour(context,itemData);
            holder.recyclerView_item_list.setHasFixedSize(true);
            holder.recyclerView_item_list.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            holder.recyclerView_item_list.setAdapter(itemListAdapter);

            holder.recyclerView_item_list.setNestedScrollingEnabled(false); // important

            // button more
            holder.btn_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(view.getContext(),"position = " + holder.getLayoutPosition(), Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(view.getContext(), WineMoreActivity.class);
                        context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return (dataList != null ? dataList.size() :0);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView item_title;
        RecyclerView recyclerView_item_list;
        Button btn_more;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_title = itemView.findViewById(R.id.itemTitle);
            btn_more = itemView.findViewById(R.id.btnMore);
            recyclerView_item_list = itemView.findViewById(R.id.recycler_view_list);
        }
    }
}
