package com.example.mywork_zzx;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter_swipe extends RecyclerView.Adapter<adapter_swipe.swipeviewholder> implements ItemTouchHelperListener{

    private List<String>list;
    private Context context;
    private View inflater;

    public adapter_swipe(Context context, List<String> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public adapter_swipe.swipeviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater= LayoutInflater.from(context).inflate(R.layout.item_swipe,parent,false);
        swipeviewholder swipeviewholder=new swipeviewholder(inflater);
        return swipeviewholder;
    }

    @Override
    public void onBindViewHolder(adapter_swipe.swipeviewholder holder, int position) {
        holder.tvContent.setText(list.get(position));
    }

    @Override
    public int getItemCount() {return list.size();}

    @Override
    public void onItemDismiss(int position) {
        if (position < 0 || position > getItemCount()) {
            return;
        }

        list.remove(position);
        notifyItemRemoved(position);

        // 解决 RecyclerView 删除 Item 导致位置错乱的问题
        if (position != list.size()) {
            notifyItemRangeChanged(position, list.size() - position);
        }
    }

    public class swipeviewholder extends RecyclerView.ViewHolder{
        TextView tvContent;

        public swipeviewholder(View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tv_content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    switch (position){
                        case 0:
                            Intent intent=new Intent(itemView.getContext(),MainActivity3.class);
                            context.startActivity(intent);
                            break;
                        case 1:
                            Intent intent1=new Intent(itemView.getContext(),MainActivity3.class);
                            context.startActivity(intent1);
                            break;
                        case 2:
                            Intent intent2=new Intent(itemView.getContext(),MainActivity3.class);
                            context.startActivity(intent2);
                            break;
                        case 3:
                            Intent intent3=new Intent(itemView.getContext(),MainActivity3.class);
                            context.startActivity(intent3);
                            break;
                    }
                }
            });
        }
    }
}
