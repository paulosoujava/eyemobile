package com.paulo.payment;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paulo.payment.entity.Payment;
import com.paulo.payment.mvp.Contract;

import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Payment> payments;
    private Context context;
    Contract.Ctrl presenter;

    public MyAdapter(List<Payment> payments, Context context, Contract.Ctrl view) {
        this.payments = payments;
        this.context = context;
        this.presenter = view;

    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final Payment payment = payments.get(position);
        holder.type.setText(payment.getType());
        setImage(payment.getType(), holder);

        holder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.click(payment.getType());
            }
        });


    }

    @Override
    public int getItemCount() {
        return payments == null ? 0 : payments.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        final ImageView image;
        final TextView type;
        final LinearLayout click;
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/din_condensed_bold.ttf");


        public MyViewHolder(View view) {
            super(view);
            type = view.findViewById(R.id.type);
            type.setTypeface(font);
            image = view.findViewById(R.id.logo);
            click = view.findViewById(R.id.click);

        }
    }

    private void setImage(String type, MyViewHolder holder) {
        switch (type) {
            case "Crédito":
                holder.image.setImageResource(R.drawable.ic_credit);
                break;
            case "Débito":
                holder.image.setImageResource(R.drawable.ic_debit);
                break;
            case "Dinheiro":
                holder.image.setImageResource(R.drawable.ic_money);
                break;
            case "V.R.":
                holder.image.setImageResource(R.drawable.ic_vr);
                break;
            case "Cupom":
                holder.image.setImageResource(R.drawable.ic_cupom);
                break;
        }
    }


}