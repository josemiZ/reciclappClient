package com.cerezaconsulting.reciclappclient.presentation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.data.entities.DeliveryEntity;
import com.cerezaconsulting.reciclappclient.presentation.adapters.listeners.OnClickListListener;
import com.cerezaconsulting.reciclappclient.presentation.presenters.communicators.CommunicatorEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by miguel on 29/06/17.
 */

public class MyDeliveriesAdapter extends RecyclerView.Adapter<MyDeliveriesAdapter.ViewHolder> implements OnClickListListener {

    private ArrayList<DeliveryEntity> list;
    private CommunicatorEntity<DeliveryEntity> communicatorEntity;

    public MyDeliveriesAdapter(ArrayList<DeliveryEntity> list, CommunicatorEntity<DeliveryEntity> communicatorEntity) {
        this.list = list;
        this.communicatorEntity = communicatorEntity;
    }

    public void setList(ArrayList<DeliveryEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_delivery, parent, false);
        return new ViewHolder(root, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DeliveryEntity deliveryEntity = list.get(position);
        String dateAndWeight=deliveryEntity.getDate()+"  -  "+deliveryEntity.getTotal_quantity();
        holder.tvDateAndWeight.setText(dateAndWeight);
        holder.tvPoints.setText(deliveryEntity.getTotal_points()+" puntos");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(int position) {
        communicatorEntity.onClick(list.get(position));
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.tv_date_and_weight)
        TextView tvDateAndWeight;
        @BindView(R.id.tv_points)
        TextView tvPoints;
        private OnClickListListener onClickListListener;

        ViewHolder(View itemView, OnClickListListener onClickListListener) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.onClickListListener = onClickListListener;
            this.itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClickListListener.onClick(getAdapterPosition());
        }
    }
}
