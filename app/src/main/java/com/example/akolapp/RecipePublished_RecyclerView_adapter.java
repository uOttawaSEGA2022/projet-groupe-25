
package com.example.akolapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipePublished_RecyclerView_adapter extends RecyclerView.Adapter<RecipePublished_RecyclerView_adapter.MyViewHolder1> {
    Context context;
    ArrayList<Recipe> Recipes;
    private final RecyclerInterfaceRecipes recyclerInterface;
    public RecipePublished_RecyclerView_adapter(Context context, ArrayList<Recipe> Recipes, RecyclerInterfaceRecipes recyclerInterface,boolean isPublished){
        this.Recipes=Recipes;
        this.context = context;
        this.recyclerInterface = recyclerInterface;

    }
    @NonNull
    @Override
    public RecipePublished_RecyclerView_adapter.MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_row2,parent,false);
        return new RecipePublished_RecyclerView_adapter.MyViewHolder1(view,recyclerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder1 holder, int position) {
        holder.ChefName.setText(Recipes.get(position).getRecipeName());
    }



    @Override
    public int  getItemCount() {
        return Recipes.size();
    }
    public static class MyViewHolder1 extends RecyclerView.ViewHolder{
        TextView ChefName;
        TextView NumOfComplaints;
        public MyViewHolder1(@NonNull View itemView, RecyclerInterfaceRecipes recyclerInterface) {
            super(itemView);
            ChefName = itemView.findViewById(R.id.ComplaintTitle);
            NumOfComplaints = itemView.findViewById(R.id.complaintsNumber);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerInterface!=null){
                        int pos = getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerInterface.clicked(pos,true);
                        }

                    }
                }
            });
        }
    }
}
