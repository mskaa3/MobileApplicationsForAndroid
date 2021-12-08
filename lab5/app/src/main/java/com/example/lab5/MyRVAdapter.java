package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab5.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.lab5.databinding.ListItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRVAdapter extends RecyclerView.Adapter<MyRVAdapter.MyViewHolder> {
    private List<ItemData> mList;
    private ListFragmentInteractionListener mListener;


    public MyRVAdapter(ListFragmentInteractionListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.mItem = mList.get(position);
        holder.mTxtMain.setText(holder.mItem.txtMain);
        holder.mTxt2.setText(holder.mItem.txtSecond);
        boolean sex = holder.mItem.gender;
        if (sex)
            holder.mImage.setImageResource(R.drawable.ic_baseline_face_24);
        else
            holder.mImage.setImageResource(R.drawable.ic_baseline_support_agent_24);
        int rating = holder.mItem.rating;
        if (rating>3)
            holder.mImage2.setImageResource(R.drawable.ic_baseline_emoji_emotions_24);
        else if (rating<3){
            holder.mImage2.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onDeleteItem(holder.mItem);
                }
            }
        });
    }
    void setItemList(List<ItemData> list){
        mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mList != null) // to avoid no initialization problems
            return mList.size();
        else return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTxtMain;
        public final TextView mTxt2;
        public final ImageView mImage;
        public final ImageView mImage2;
        public ItemData mItem; // to keep reference to given item data in the list
        public MyViewHolder(View view) {
            super(view);
            mView = view;
            mTxtMain = (TextView) view.findViewById(R.id.item_txt_main);
            mTxt2 = (TextView) view.findViewById(R.id.item_txt_2);
            mImage = (ImageView) view.findViewById(R.id.item_image);;
            mImage2 = (ImageView) view.findViewById(R.id.item_rating_image);;
        }
    }


    }
