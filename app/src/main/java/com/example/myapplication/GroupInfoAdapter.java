package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

/**
 * groups
 * Created by kee on 2017/8/18.
 */

public class GroupInfoAdapter extends BaseRecyclerViewAdapter<GroupInfoAdapter.ViewHolder> {

    private Context mContext;
    private List<LoanBean> mGroups;
    private boolean enable;

    public GroupInfoAdapter(Context context, List<LoanBean> groups) {
        this.mContext = context;
        this.mGroups = groups;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_device_group, parent, false);
        ViewHolder holder = new ViewHolder(itemView);
        holder.tv_id = (TextView) itemView.findViewById(R.id.tv_id);
        holder.tv_all = (TextView) itemView.findViewById(R.id.tv_all);
        holder.tv_year_factor = (TextView) itemView.findViewById(R.id.tv_year_factor);
        holder.tv_month_factor = (TextView) itemView.findViewById(R.id.tv_month_factor);
        holder.tv_year_int = (TextView) itemView.findViewById(R.id.tv_year_int);
        holder.tv_month_int = (TextView) itemView.findViewById(R.id.tv_month_int);
        holder.tv_li_month = (TextView) itemView.findViewById(R.id.tv_li_month);
        holder.tv_ben_month = (TextView) itemView.findViewById(R.id.tv_ben_month);
        holder.tv_all_month = (TextView) itemView.findViewById(R.id.tv_all_month);
        holder.tv_java_money = (TextView) itemView.findViewById(R.id.tv_java_money);
        holder.tv_remain_money = (TextView) itemView.findViewById(R.id.tv_remain_money);
        holder.tv_time = (TextView) itemView.findViewById(R.id.tv_time);
        holder.tv_all_money = (TextView) itemView.findViewById(R.id.tv_all_money);

        return holder;
    }

    @Override
    public int getItemCount() {
        return mGroups == null ? 0 : mGroups.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        LoanBean group = mGroups.get(position);
        holder.tv_id.setText(String.valueOf(group.getId()));
        holder.tv_all.setText(String.format("%.2f", group.getAll()));
        holder.tv_year_factor.setText(String.format("%.3f", group.getYearFactor()));
        holder.tv_month_factor.setText(String.format("%.3f", group.getMonthFactor()));
        holder.tv_year_int.setText(String.format("%.2f", group.getYearInt()));
        holder.tv_month_int.setText(String.format("%.2f", group.getMonthInt()));
        holder.tv_li_month.setText(String.format("%.2f", group.getLiMonth()));
        holder.tv_ben_month.setText(String.format("%.2f", group.getBenMonth()));
        holder.tv_all_month.setText(String.format("%.2f", group.getAllMonth()));
        holder.tv_remain_money.setText(String.format("%.2f", group.getRemainMoney()));
        holder.tv_java_money.setText(String.format("%.2f", group.getJavaMoney()));
        holder.tv_time.setText(group.getTime(group.getYear(),group.getMonth(),group.getDay()));
        holder.tv_all_money.setText(String.format("%.2f", group.getAllMoney()));

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id, tv_all, tv_year_factor,
                tv_month_factor, tv_year_int, tv_month_int,
                tv_li_month, tv_ben_month, tv_all_month,
                tv_remain_money, tv_java_money,tv_time,tv_all_money;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
