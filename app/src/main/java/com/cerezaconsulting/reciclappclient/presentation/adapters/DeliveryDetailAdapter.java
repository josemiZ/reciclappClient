package com.cerezaconsulting.reciclappclient.presentation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.data.entities.DeliveryDetailEntity;
import com.cerezaconsulting.reciclappclient.data.entities.GarbageEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by miguel on 4/07/17.
 */

public class DeliveryDetailAdapter extends RecyclerView.Adapter<DeliveryDetailAdapter.ViewHolder>{
    private ArrayList<DeliveryDetailEntity> list;

    public DeliveryDetailAdapter(ArrayList<DeliveryDetailEntity> list) {
        this.list = list;
    }

    public void setList(ArrayList<DeliveryDetailEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_delivery, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DeliveryDetailEntity deliveryEntity = list.get(position);
        String dateAndWeight=deliveryEntity.getGarbageEntity().getDescription()+":"+deliveryEntity.getQuantity()+deliveryEntity.getGarbageEntity().getUnit();
        holder.tvDateAndWeight.setText(dateAndWeight);
        holder.tvPoints.setText(deliveryEntity.getPoints()+" puntos");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_date_and_weight)
        TextView tvDateAndWeight;
        @BindView(R.id.tv_points)
        TextView tvPoints;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
