package com.example.mywork_zzx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter_expand extends RecyclerView.Adapter<adapter_expand.expandviewholder> {

    private List<String>list;
    private Context context;
    private View inflater;

    private int expandedPosition = -1;
    private expandviewholder mViewHolder;

    public adapter_expand(Context context, List<String> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public adapter_expand.expandviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater= LayoutInflater.from(context).inflate(R.layout.item_expand,parent,false);
        expandviewholder expandviewholder=new expandviewholder(inflater);
        return expandviewholder;
    }

    @Override
    public void onBindViewHolder(final adapter_expand.expandviewholder holder, int position) {
        holder.tvTeam.setText(list.get(position));
        holder.tvTeamChild.setText(list.get(position) + "的联系方式");

        final boolean isExpanded = position == expandedPosition;
        holder.rlChild.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.rlParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mViewHolder != null) {
                    mViewHolder.rlChild.setVisibility(View.GONE);
                    notifyItemChanged(expandedPosition);
                }
                expandedPosition = isExpanded ? -1 : holder.getAdapterPosition();
                mViewHolder = isExpanded ? null : holder;
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() { return list.size();}

    class expandviewholder extends RecyclerView.ViewHolder{
        RelativeLayout rlParent, rlChild;
        TextView tvTeam, tvTeamChild;
        public expandviewholder(View itemView) {
            super(itemView);
            rlParent = itemView.findViewById(R.id.rl_parent);
            rlChild = itemView.findViewById(R.id.rl_child);
            tvTeam = itemView.findViewById(R.id.tv_team);
            tvTeamChild = itemView.findViewById(R.id.tv_team_child);
        }
    }
}
