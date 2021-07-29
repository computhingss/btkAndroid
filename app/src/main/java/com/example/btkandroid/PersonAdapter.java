package com.example.btkandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btkandroid.db.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private List<Person> personList=new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.personitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Person person=personList.get(position);
        holder.name.setText(person.getName()+" "+ person.getSurname());
        holder.identity.setText(person.getIdentityNumber());

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public void setList(List<Person> personList) {
        this.personList=personList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name,identity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            identity=itemView.findViewById(R.id.identity);
        }
    }
}
