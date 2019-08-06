package com.example.alquraan;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class QuraanFragment extends Fragment {



    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SewarAdapter adapter;



    public QuraanFragment() {
        // Required empty public constructor
    }
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate ( R.layout.fragment_quraan, container, false );
        recyclerView = view.findViewById ( R.id.recycle_view );
        adapter = new SewarAdapter ( Constant.ArSuras );
        adapter.setOnItemClickListener ( new SewarAdapter.OnItemClickListener () {
            @Override
            public void onItemClick(int position, String sewarname) {
                Intent intent =new Intent (getContext (),SewarDetail.class );
                SewarDetail.postion=position;
                SewarDetail.sewarname = sewarname;
                intent.putExtra ( "position",position );
                intent.putExtra ( "sewarname",sewarname );

                startActivity ( intent );
            }
        } );
        layoutManager = new GridLayoutManager (getContext (),3, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager ( layoutManager );
        recyclerView.setAdapter ( adapter );

        return  view;
    }

}
