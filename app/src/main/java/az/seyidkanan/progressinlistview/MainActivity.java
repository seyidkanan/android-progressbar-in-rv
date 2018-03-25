package az.seyidkanan.progressinlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import az.seyidkanan.progressinlistview.adapter.RVAdapter;
import az.seyidkanan.progressinlistview.model.ContentModel;
import az.seyidkanan.progressinlistview.util.EndlessScrollListener;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        final List<ContentModel> contentModelList = new ArrayList<>();
        contentModelList.add(new ContentModel("1"));
        contentModelList.add(new ContentModel("2"));
        contentModelList.add(new ContentModel("3"));
        contentModelList.add(new ContentModel("4"));
        contentModelList.add(new ContentModel("5"));
        contentModelList.add(new ContentModel("6"));
        contentModelList.add(new ContentModel("7"));
        contentModelList.add(new ContentModel("8"));
        contentModelList.add(new ContentModel("9"));
        contentModelList.add(new ContentModel("10"));


        final RVAdapter rvAdapter = new RVAdapter();

        recyclerView.setAdapter(rvAdapter);

        rvAdapter.setDataList(contentModelList);
        EndlessScrollListener endlessScrollListener = new EndlessScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                if (!isLoading) {
                    rvAdapter.setData(new ContentModel());
//                    isLoading = true;
                }

                rvAdapter.setDataList(contentModelList);

            }
        };

        recyclerView.setOnScrollListener(endlessScrollListener);

    }


}
