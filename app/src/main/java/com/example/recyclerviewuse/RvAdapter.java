package com.example.recyclerviewuse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.CardViewTasarimNesnelerinitutucu> {
    private Context mcontext;
    private List<String> ulkelerDisaridanGelenList;

    public RvAdapter(Context mcontext, List<String> ulkelerDisaridanGelenList) {
        this.mcontext = mcontext;
        this.ulkelerDisaridanGelenList = ulkelerDisaridanGelenList;
    }

    //Card tasarımını temsil eden bir sınıf oluşturduk.
    public static class CardViewTasarimNesnelerinitutucu extends RecyclerView.ViewHolder{
        public TextView satirYazi;
        public CardView satirCardView;
        public ImageView noktaResim;
        public CardViewTasarimNesnelerinitutucu(View view) {
            super(view);
            satirYazi=view.findViewById(R.id.textSatirYazi);
            satirCardView=view.findViewById(R.id.satirCardView);
            noktaResim=view.findViewById(R.id.noktaResim);
        }
    }

    @NonNull
    @Override
    public CardViewTasarimNesnelerinitutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_design,parent,false);
        return new CardViewTasarimNesnelerinitutucu(itemView);
    }

    //Kaç tane kart oluşacağını ve hangi karta hangi verinin yerleşeceğini yaptık.
    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimNesnelerinitutucu holder, int position) {
        String ulke=ulkelerDisaridanGelenList.get(position);
        holder.satirYazi.setText(ulke);
        holder.satirCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, "Seçtiğiniz ülke :"+ulke,Toast.LENGTH_SHORT).show();
            }
        });

        holder.noktaResim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(mcontext,holder.noktaResim);
                popupMenu.getMenuInflater().inflate(R.menu.card_menu,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                            if (item.getItemId()==R.id.action_sil){
                                Toast.makeText(mcontext, "Sil Tıklandı :"+ulke, Toast.LENGTH_SHORT).show();
                                return true;
                            } else if (item.getItemId()==R.id.action_duzenle) {
                                Toast.makeText(mcontext, "Düzenle Tıklandı :"+ulke, Toast.LENGTH_SHORT).show();
                                return true;
                            }
                        return false;
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return ulkelerDisaridanGelenList.size();
    }





}
