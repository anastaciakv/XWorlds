package com.ana.xworlds.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ana.xworlds.R;
import com.ana.xworlds.entity.World;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Adapter for displaying list of worlds. Uses different layouts for phones and tablets
 */
public class WorldsListAdapter extends RecyclerView.Adapter<WorldsListAdapter.ViewHolder> {
    private List<World> worldList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tvWorldName)
        TextView tvWorldName;
        @Bind(R.id.tvLanguage)
        TextView tvLanguage;
        @Bind(R.id.tvStatus)
        TextView tvStatus;
        @Bind(R.id.tvCountry)
        TextView tvCountry;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public WorldsListAdapter(List<World> worldList) {
        this.worldList = worldList;
    }

    @Override
    public WorldsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //choose child view depending on the amount of columns in the grid
        int columns = parent.getContext().getResources().getInteger(R.integer.grid_columns);
        View v = LayoutInflater.from(parent.getContext())
                .inflate(columns == 1 ? R.layout.item_world : R.layout.item_world_card, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        World world = worldList.get(position);
        holder.tvWorldName.setText(world.name);
        holder.tvStatus.setText(world.worldStatus.description);
        holder.tvCountry.setText(world.country);
        holder.tvLanguage.setText(world.language);
    }

    @Override
    public int getItemCount() {
        return worldList.size();
    }
}
