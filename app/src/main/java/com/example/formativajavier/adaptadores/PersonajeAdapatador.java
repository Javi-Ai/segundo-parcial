package com.example.formativajavier.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formativajavier.R;
import com.example.formativajavier.clases.Personaje;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PersonajeAdapatador extends RecyclerView.Adapter<PersonajeAdapatador.viewHolder> {

    private List<Personaje> datos;
    private OnUsuarioClickListener listener;

    public PersonajeAdapatador(List<Personaje> datos, OnUsuarioClickListener listener) {
        this.datos = datos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PersonajeAdapatador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personaje, parent, false);
        return new viewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeAdapatador.viewHolder holder, int position) {
        Personaje dato = datos.get(position);
        holder.bind(dato);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView txt_nombre_personaje, txt_descripcion_personaje;
        ImageView img_personaje;

        public viewHolder(@NonNull View itemView, OnUsuarioClickListener listener) {
            super(itemView);
            txt_nombre_personaje = itemView.findViewById(R.id.txt_nombre_personaje);
            txt_descripcion_personaje = itemView.findViewById(R.id.txt_descripcion_personaje);
            img_personaje = itemView.findViewById(R.id.img_personaje);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onUsuarioClick((Personaje) v.getTag());
                    }
                }
            });
        }

        public void bind(Personaje dato) {
            txt_nombre_personaje.setText(dato.getNombre());
            Picasso.get().load(dato.getImagen()).into(img_personaje);
            itemView.setTag(dato);
        }
    }
}