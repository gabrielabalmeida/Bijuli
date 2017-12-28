package com.compart.android.cardview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.compart.android.cardview.R;
import com.compart.android.cardview.domain.Carro;
import com.compart.android.cardview.interfaces.RecyclerViewOnClickListenerHack;

import java.util.List;

/**
 * Created by gabriela.almeida on 16/11/2017.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder> {
    private Context context;
    private List<Carro> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;


    public CarAdapter(Context c, List<Carro> l) {
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = c;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Log.i("LOG", "onCreateViewHolder()");
        View v = mLayoutInflater.inflate(R.layout.item_car, viewGroup, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        Log.i("LOG", "onBindViewHolder()");
        Carro carro = mList.get(position);
        //myViewHolder.ivCarro.setImageResource( mList.get(position).getFoto() );
        Glide.with(getContext()).load(carro.getFoto()).into(myViewHolder.ivCarro);
        myViewHolder.tvModelo.setText(carro.getModelo());
        myViewHolder.tvMarca.setText(carro.getMarca());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r) {
        mRecyclerViewOnClickListenerHack = r;
    }

    private Context getContext() {
        return context;
    }


    public void addListItem(Carro c, int position) {
        mList.add(c);
        notifyItemInserted(position);
    }


    public void removeListItem(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView ivCarro;
        public TextView tvModelo;
        public TextView tvMarca;

        public MyViewHolder(View itemView) {
            super(itemView);

            ivCarro = itemView.findViewById(R.id.iv_carro);
            tvModelo = itemView.findViewById(R.id.tv_modelo);
            tvMarca = itemView.findViewById(R.id.tv_marca);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mRecyclerViewOnClickListenerHack != null) {
                mRecyclerViewOnClickListenerHack.onClickListener(v, getAdapterPosition());
            }
        }
    }
}
