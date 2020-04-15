package com.example.cashierapp.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cashierapp.ITEM;
import com.example.cashierapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView home_item_recyclerView;
    MyAdapter adapter;
    ArrayList <ITEM> data = new ArrayList<>();





    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        home_item_recyclerView = v.findViewById(R.id.home_item_recyclerView);

        genMockData();
        adapter = new MyAdapter();

        home_item_recyclerView.setAdapter(adapter);
        home_item_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //home_item_recyclerView.addItemDecoration(getContext(), DividerItemDecoration.VERTICAL);

        return v;
    }

    private void genMockData() {
        data.add(new ITEM("Coffee",30000, "Black ice coffee no sugar", R.drawable.example));

    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View itemView = layoutInflater.inflate(
                    R.layout.home_recycler,
                    parent,
                    false
            );
            return new MyViewHolder(itemView);

        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            ITEM itemdata = data.get(position);
            holder.item_name.setText(itemdata.getItem_name());
            holder.item_price.setText(String.valueOf(itemdata.getItem_price()));

            holder.item_description.setText(itemdata.getItem_description());

            holder.item_img.setImageResource(itemdata.getItem_img());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }


    }
    private class MyViewHolder extends RecyclerView.ViewHolder{
        TextView item_name;
        TextView item_price;
        TextView item_description;
        ImageView item_img;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            item_name = itemView.findViewById(R.id.item_name);
            item_price = itemView.findViewById(R.id.item_price);
            item_description = itemView.findViewById(R.id.item_description);
            item_img = itemView.findViewById(R.id.item_img);

        }

    }
}
