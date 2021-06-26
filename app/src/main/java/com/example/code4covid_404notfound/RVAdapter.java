package com.example.code4covid_404notfound;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    private Context context;
    ArrayList<User> list = new ArrayList<>();
    public RVAdapter(Context ctx){
        this.context = ctx;
    }
    public void setItems(ArrayList<User> user){
        list.addAll(user);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = list.get(position);
        holder.Name.setText(user.getmName());
        holder.Age.setText(user.getmAge());
        holder.Contact.setText("Contact: "+user.getmContact());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView Name;
        private TextView Age;
        private TextView Contact;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.text_name);
            Age = itemView.findViewById(R.id.text_age);
            Contact = itemView.findViewById(R.id.text_contact);
        }
    }
}
