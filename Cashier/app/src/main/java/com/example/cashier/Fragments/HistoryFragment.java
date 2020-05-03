package com.example.cashier.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cashier.Models.History;
import com.example.cashier.Models.Item;
import com.example.cashier.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView history_item_recyclerView;
    HistoryFragment.MyAdapter adapter;
    ArrayList<History> data = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SmsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
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
        View v = inflater.inflate(R.layout.fragment_history, container, false);
        history_item_recyclerView = v.findViewById(R.id.history_item_recyclerView);

        genMockData();
        adapter = new HistoryFragment.MyAdapter();

        history_item_recyclerView.setAdapter(adapter);
        history_item_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

    public void genMockData() {
        data.add(new History("03/05/2020 - 08:01",32000, "Black Coffee x 2"));
        data.add(new History("02/05/2020 - 20:05",80000, "Milk Coffee x 2, Espresso Con Panna x 1"));
        data.add(new History("02/05/2020 - 17:20",70000, "Caramel Machiato x 1, Ice Mocha x 1"));
        data.add(new History("02/05/2020 - 11:21",54000, "Milk Ice Coffee x 1, Caramel Machiato x 1"));
        data.add(new History("02/05/2020 - 09:32",57000, "Americano Ice x 1, Ristretto Bianco x 1"));
        data.add(new History("01/05/2020 - 08:52",38000, "Ice Mocha x 1"));
    }

    private class MyAdapter extends RecyclerView.Adapter<HistoryFragment.MyViewHolder> {
        @NonNull
        @Override
        public HistoryFragment.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View itemView = layoutInflater.inflate(
                    R.layout.history_recycler,
                    parent,
                    false
            );
            return new HistoryFragment.MyViewHolder(itemView);

        }

        @Override
        public void onBindViewHolder(@NonNull HistoryFragment.MyViewHolder holder, int position) {

            History historydata = data.get(position);
            holder.bill_date.setText(historydata.getBill_datetime());
            holder.bill_price.setText(String.valueOf(historydata.getBill_price()));
            holder.bill_item.setText(historydata.getBill_item());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }


    }
    private class MyViewHolder extends RecyclerView.ViewHolder{
        TextView bill_date;
        TextView bill_price;
        TextView bill_item;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            bill_date = itemView.findViewById(R.id.bill_date);
            bill_price = itemView.findViewById(R.id.bill_price);
            bill_item = itemView.findViewById(R.id.bill_item);

        }

    }
}
