package cungxunu.cunghoangdao.cheng.cungxunu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import cungxunu.cunghoangdao.cheng.cungxunu.R;
import cungxunu.cunghoangdao.cheng.cungxunu.model.Cunghoangdao;


/**
 * Created by Welcome on 1/26/2016.
 */
public class RecyclerViewIconCungHoangDaoAdapter extends RecyclerView.Adapter<RecyclerViewIconCungHoangDaoAdapter.RecyclerViewIconCungHoangDaoHolder> {
    private final String TAG = getClass().getSimpleName();
    Context context;
    ArrayList<Cunghoangdao> arrayCunghoangdao;
    public OnItemClickIconCungHoangDao onItemClickIconCungHoangDao;

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    public RecyclerViewIconCungHoangDaoAdapter(Context context, ArrayList<Cunghoangdao> arrayCunghoangdao,
                                               OnItemClickIconCungHoangDao onItemClickIconCungHoangDao) {
        this.context = context;
        this.arrayCunghoangdao = arrayCunghoangdao;
        this.onItemClickIconCungHoangDao = onItemClickIconCungHoangDao;
    }

    @Override
    public RecyclerViewIconCungHoangDaoHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.item_fragment_home_tienich, viewGroup, false);
        RecyclerViewIconCungHoangDaoHolder viewHolder = new RecyclerViewIconCungHoangDaoHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewIconCungHoangDaoHolder recyclerViewHolder, final int position) {
        final Cunghoangdao model = arrayCunghoangdao.get(position);
        recyclerViewHolder.tvName.setText(model.getName());
        Log.d(TAG, model.getImage() + "");
        if (model.getImage() != 0) {
            recyclerViewHolder.imgCunghoangdao.setImageResource(model.getImage());
        }
        recyclerViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickIconCungHoangDao.onItemClickIconCungHoangDao(v, position, model.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != arrayCunghoangdao ? arrayCunghoangdao.size() : 0);
    }

    public interface OnItemClickIconCungHoangDao {
        void onItemClickIconCungHoangDao(View v, int position, String category);
    }
    public class RecyclerViewIconCungHoangDaoHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public ImageView imgCunghoangdao;
        public LinearLayout ll;

        public RecyclerViewIconCungHoangDaoHolder(View view) {
            super(view);
            this.tvName = (TextView) view
                    .findViewById(R.id.item_icon_tvName);
            this.imgCunghoangdao = (ImageView) view
                    .findViewById(R.id.item_icon_imgSlider);
            this.ll = (LinearLayout) view.findViewById(R.id.item_icon_ll);

        }
    }
}