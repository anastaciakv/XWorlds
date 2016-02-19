package com.ana.xworlds.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.ana.xworlds.R;
import com.ana.xworlds.adapter.WorldsListAdapter;
import com.ana.xworlds.entity.World;

import java.io.Serializable;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WorldsListActivity extends AppCompatActivity {
    private static final String TAG = WorldsListActivity.class.getSimpleName();
    private static final String KEY_WORLD_LIST = "KEY_WORLD_LIST";
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<World> worldList;

    // UI references.
    @Bind(R.id.listWorlds)
    RecyclerView mRecyclerView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    public static void start(Context context, List<World> worldList) {
        Intent intent = new Intent(context, WorldsListActivity.class);
        Bundle extra = new Bundle();
        extra.putSerializable(KEY_WORLD_LIST, (Serializable) worldList);
        intent.putExtras(extra);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worlds_list);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey(KEY_WORLD_LIST)) {
            worldList = (List<World>) extras.getSerializable(KEY_WORLD_LIST);
        } else {
            throw new ClassCastException(TAG + " must be provided with a list of worlds");
        }

        mRecyclerView.setHasFixedSize(true);
        //choose amount of columns depending on screen width (1 for phones, 3 for tablets)
        mLayoutManager = new GridLayoutManager(this, getResources().getInteger(R.integer.grid_columns));
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new WorldsListAdapter(worldList);
        mRecyclerView.setAdapter(mAdapter);
    }

}
