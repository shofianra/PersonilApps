package com.app.shofianra.personilapps;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.app.shofianra.personilapps.R;
import com.app.shofianra.personilapps.DetailPersonilActivity;
import com.app.shofianra.personilapps.Personil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonilAdapter extends RecyclerView.Adapter<PersonilAdapter.ViewHolder> {

    private Context context;
    private List<Personil> listPersonil;

    public PersonilAdapter(Context context, List<Personil> listPersonil) {
        this.context = context;
        this.listPersonil = listPersonil;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_personil, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Personil personil = listPersonil.get(position);
        Glide.with(context).load(personil.getImage()).into(holder.imagePersonil);
        holder.txtNamaPersonil.setText(personil.getNama());
        holder.txtJenisKelamin.setText(personil.getJenisKelamin());
        holder.cvPersonil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailPersonilActivity.class);
                i.putExtra("personil", personil);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPersonil.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_personil)
        ImageView imagePersonil;
        @BindView(R.id.txt_nama_personil)
        TextView txtNamaPersonil;
        @BindView(R.id.txt_jenis_kelamin)
        TextView txtJenisKelamin;
        @BindView(R.id.cv_personil)
        CardView cvPersonil;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

