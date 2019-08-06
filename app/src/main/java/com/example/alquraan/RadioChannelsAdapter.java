package com.example.alquraan;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alquraan.API.RadiosItem;

import java.util.List;

public class RadioChannelsAdapter extends RecyclerView.Adapter<RadioChannelsAdapter.ViewHolder> {


    List<RadiosItem>channels;

    public RadioChannelsAdapter(List<RadiosItem> channel) {
        this.channels = channel;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from ( viewGroup.getContext ())
                .inflate ( R.layout.item_channels ,viewGroup,false);
        return new ViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

       final RadiosItem channel = channels.get ( position );
       viewHolder.name.setText ( channel.getName () );
            if(onPlayClickListner!=null){
                viewHolder.play.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        onPlayClickListner.onItemClick ( position,channel );
                    }
                } );
            }
        if(onStopClickListner!=null){
            viewHolder.stop.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    onStopClickListner.onItemClick ( position,channel );
                }
            } );
        }
    }

    @Override
    public int getItemCount() {

        if (channels==null)return 0;
        return channels.size ();
    }



    public void changeData(List<RadiosItem>channels){

        this.channels=channels;
        notifyDataSetChanged ();

    }



    OnItemClickListener onPlayClickListner;
    OnItemClickListener onStopClickListner;

    public void setOnPlayClickListner(OnItemClickListener onPlayClickListner) {
        this.onPlayClickListner = onPlayClickListner;
    }

    public void setOnStopClickListner(OnItemClickListener onStopClickListner) {
        this.onStopClickListner = onStopClickListner;
    }

    public interface OnItemClickListener{
        void onItemClick(int position, RadiosItem radiosItem);
   }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView play,stop;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            name= itemView.findViewById ( R.id.name);
            play= itemView.findViewById ( R.id.play);
            stop= itemView.findViewById ( R.id.stop);

        }
    }
}

