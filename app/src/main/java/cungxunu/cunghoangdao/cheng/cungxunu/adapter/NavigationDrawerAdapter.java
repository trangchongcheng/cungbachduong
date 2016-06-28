package cungxunu.cunghoangdao.cheng.cungxunu.adapter;

/**
 * Created by tqk666 on 16/04/16.
 */

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.Collections;
import java.util.List;

import cungxunu.cunghoangdao.cheng.cungxunu.R;
import cungxunu.cunghoangdao.cheng.cungxunu.model.NavDrawerItem;


public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {
    List<NavDrawerItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public NavigationDrawerAdapter(Context context, List<NavDrawerItem> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_navigation, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NavDrawerItem current = data.get(position);
        holder.title.setText(current.getTitle());
        if (position != 0){
            holder.imgTitle.setImageResource(current.getImgDrawer());
        }
        else {
            holder.imgTitle.setVisibility(View.GONE);
        }
        if (position == 1){
            holder.title.setTextColor(ContextCompat.getColor(context,R.color.colorAccent));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imgTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.row_navigation_tvItem);
            imgTitle = (ImageView)itemView.findViewById(R.id.row_navigation_imgIcon);
        }
    }
}
