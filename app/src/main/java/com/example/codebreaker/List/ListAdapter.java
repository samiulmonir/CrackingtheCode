package com.example.codebreaker.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codebreaker.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ItemAdapter> mList;
    private Context mContext;

    public ListAdapter(List<ItemAdapter> list, Context context){
        super();
        mList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ItemAdapter itemAdapter = mList.get(position);
        ((ViewHolder) viewHolder).mImgLeft.setImageResource(itemAdapter.getImageLeft());
        ((ViewHolder) viewHolder).mImgCenter.setImageResource(itemAdapter.getImageCenter());
        ((ViewHolder) viewHolder).mImgRight.setImageResource(itemAdapter.getImageRight());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImgLeft;
        public ImageView mImgCenter;
        public ImageView mImgRight;

        public ViewHolder(View itemView) {
            super(itemView);
            mImgLeft = (ImageView) itemView.findViewById(R.id.img_left);
            mImgCenter = (ImageView) itemView.findViewById(R.id.img_center);
            mImgRight = (ImageView) itemView.findViewById(R.id.img_right);
        }
    }
}
