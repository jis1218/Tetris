package com.example.tetris2.datalist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tetris2.R;

import java.util.ArrayList;

/**
 * Created by 정인섭 on 2017-10-08.
 */

public class ListAdapter extends BaseAdapter {

    ArrayList<Score> list = null;
    Context context;

    public ListAdapter(ArrayList<Score> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, null);
        Holder holder = new Holder(view);
        String pos = (position + 1) + "";
        holder.tvNo.setText(pos);
        String scores = list.get(position).score + "";
        holder.tvScore.setText(scores);
        String date_str = list.get(position).date + "";
        holder.tvTime.setText(date_str);

        return view;
    }

    public class Holder {
        TextView tvNo, tvScore, tvTime;

        Holder(View view) {
            tvNo = view.findViewById(R.id.tvNo);
            tvScore = view.findViewById(R.id.tvScore);
            tvTime = view.findViewById(R.id.tvTime);
        }
    }
}
