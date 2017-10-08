package com.example.tetris2.datalist;

import android.content.Context;
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
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder = new Holder(view);
        String pos = (position+1) + "";
        holder.tvNo.setText(pos);
        holder.tvScore.setText(list.get(position).score);
        String date_str = list.get(position).date + "";
        holder.tvTime.setText(date_str);
        view = View.inflate(context, R.layout.item_list, null);

        return view;
    }

    public class Holder{
        TextView tvNo, tvScore, tvTime;
        Holder(View view){
            tvNo = view.findViewById(R.id.tvNo);
            tvScore = view.findViewById(R.id.tvScore);
            tvTime = view.findViewById(R.id.tvTime);
        }
    }
}
