package com.example.androidrecyclerviewgoogleplay.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androidrecyclerviewgoogleplay.DrinkDrink1Activity;
import com.example.androidrecyclerviewgoogleplay.DrinkDrink2Activity;
import com.example.androidrecyclerviewgoogleplay.FruitsAppleActivity;
import com.example.androidrecyclerviewgoogleplay.FruitsBananaActivity;
import com.example.androidrecyclerviewgoogleplay.FruitsCherryActivity;
import com.example.androidrecyclerviewgoogleplay.FruitsOrangeActivity;
import com.example.androidrecyclerviewgoogleplay.FruitsWatermellonActivity;
import com.example.androidrecyclerviewgoogleplay.Interface.IItemClickListener;
import com.example.androidrecyclerviewgoogleplay.Model.ItemData;
import com.example.androidrecyclerviewgoogleplay.PizzaPizaa2Activity;
import com.example.androidrecyclerviewgoogleplay.PizzaPizza1Activity;
import com.example.androidrecyclerviewgoogleplay.R;
import com.example.androidrecyclerviewgoogleplay.WineWine1Activity;
import com.example.androidrecyclerviewgoogleplay.WineWine2Activity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyItemAdapter extends RecyclerView.Adapter<MyItemAdapter.MyViewHolder> {

    private Context context;
    private List<ItemData> itemDataList;

    public MyItemAdapter(Context context, List<ItemData> itemDataList) {
        this.context = context;
        this.itemDataList = itemDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
            holder.txt_item_title.setText(itemDataList.get(position).getName());
        Picasso.get().load(itemDataList.get(position).getImage()).into(holder.img_item);

        // do not forget implement item click
        holder.setiItemClickListener(new IItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
               // final int finalI=position;
                //Toast.makeText(context, ""+itemDataList.get(position).getName(), Toast.LENGTH_SHORT).show();
                Toast.makeText(view.getContext(),"position = " + holder.getLayoutPosition(), Toast.LENGTH_SHORT).show();
                if(holder.getAdapterPosition()==0){
                    Intent intent = new Intent(view.getContext(),FruitsOrangeActivity.class);
                    context.startActivity(intent);
                }
                else if (holder.getAdapterPosition()== 1){
                    Intent intent = new Intent(view.getContext(), FruitsAppleActivity.class);
                    context.startActivity(intent);
                }else if (holder.getAdapterPosition() == 2){
                    Intent intent = new Intent(view.getContext(), FruitsWatermellonActivity.class);
                    context.startActivity(intent);
                }
                else if (holder.getAdapterPosition()== 3){
                    Intent intent = new Intent(view.getContext(), FruitsBananaActivity.class);
                    context.startActivity(intent);
                }
                else if (holder.getAdapterPosition()== 4){
                    Intent intent = new Intent(view.getContext(), FruitsCherryActivity.class);
                    context.startActivity(intent);
                }
                else if (holder.getAdapterPosition()== 5){
                    Intent intent = new Intent(context, PizzaPizza1Activity.class);
                    context.startActivity(intent);
                }
                else if (holder.getAdapterPosition() == 6){
                    Intent intent = new Intent(view.getContext(), PizzaPizaa2Activity.class);
                    context.startActivity(intent);
                    //  .
                    //Continue
                    //  .
                }
                else if (holder.getAdapterPosition()== 10){
                    Intent intent = new Intent(view.getContext(), DrinkDrink1Activity.class);
                    context.startActivity(intent);
                }
                else if (holder.getAdapterPosition() == 11){
                    Intent intent = new Intent(view.getContext(), DrinkDrink2Activity.class);
                    context.startActivity(intent);
                    //  .
                    //Continue
                    //  .
                }
                else if (holder.getAdapterPosition()== 16){
                    Intent intent = new Intent(view.getContext(), WineWine1Activity.class);
                    context.startActivity(intent);
                }
                else if (holder.getAdapterPosition()== 17){
                    Intent intent = new Intent(view.getContext(), WineWine2Activity.class);
                    context.startActivity(intent);
                    //  .
                    //Continue
                    //  .
                }
                else {
                    Toast.makeText(view.getContext(), "No Match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (itemDataList != null ? itemDataList.size() :0);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txt_item_title;
        ImageView img_item;

        IItemClickListener iItemClickListener;

        public void setiItemClickListener(IItemClickListener iItemClickListener) {
            this.iItemClickListener = iItemClickListener;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_item_title = itemView.findViewById(R.id.tvTitle);
            img_item = itemView.findViewById(R.id.itemImage);

            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view){
           iItemClickListener.onItemClickListener(view,getAdapterPosition());
        }
    }
}
