package az.seyidkanan.progressinlistview.util;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Kanan on 3/25/2018.
 */

public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener {

    private final int VISIBLE_THRESHOLD = 10;

    private int mPreviousTotal = 0;
    private boolean mLoading = true;
    private int mCurrentPage = 0;
    private LinearLayoutManager mLinearLayoutManager;

    public EndlessScrollListener(LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = recyclerView.getChildCount();
        int totalItemCount = mLinearLayoutManager.getItemCount();
        int firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();

        if (mLoading) {
            if (totalItemCount > mPreviousTotal) {
                mLoading = false;
                mPreviousTotal = totalItemCount;
            }
        }
        if (!mLoading && (totalItemCount - firstVisibleItem - visibleItemCount)
                <= VISIBLE_THRESHOLD) {

            mCurrentPage = mCurrentPage + 10;
            onLoadMore(mCurrentPage);

            mLoading = true;
        }
    }

    public void reset() {
        mCurrentPage = 0;
        mPreviousTotal = 0;
        mLoading = true;
    }

    public abstract void onLoadMore(int currentPage);

}
