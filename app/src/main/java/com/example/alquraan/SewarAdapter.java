package com.example.alquraan;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SewarAdapter extends RecyclerView.Adapter<SewarAdapter.ViewHolder> {


    String[] sewarnames;

    public SewarAdapter(String[] sewarnames) {
        this.sewarnames = sewarnames;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from ( viewGroup.getContext ()).inflate ( R.layout.item_sewar ,viewGroup,false);
        return new ViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        final String sewarname = sewarnames[position];
        viewHolder.name.setText ( sewarname );
            if(onItemClickListener!=null){
                viewHolder.itemView.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick (position,sewarname);
                    }
                } );
            }
    }

    @Override
    public int getItemCount() {
        return sewarnames.length;
    }
    OnItemClickListener onItemClickListener;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


   public interface OnItemClickListener{
        void onItemClick(int position, String name);
   }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            name= itemView.findViewById ( R.id.name);
        }
    }
}

