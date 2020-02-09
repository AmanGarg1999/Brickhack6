package com.example.brickhack6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapterForSerach extends RecyclerView.Adapter<RecyclerViewAdapterForSerach.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapterForSearch";

    private ArrayList<String> mnames = new ArrayList<>();
    private ArrayList<String> mimagesUrls = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapterForSerach(Context context, ArrayList<String> names, ArrayList<String> imgUrls){
        mnames = names;
        mimagesUrls = imgUrls;
        mContext = context;

    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alc_object_list, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("LongLogTag")
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onCreateViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mimagesUrls.get(position))
                .into(holder.image);
        holder.name.setText(mnames.get(position));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on img" + mnames.get(position));
                Toast.makeText(mContext, mnames.get(position),Toast.LENGTH_SHORT).show();
            }
        });

    }

    public int getItemCount() {
        return mimagesUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_search);
            name = itemView.findViewById(R.id.name_search);
        }
    }
}
