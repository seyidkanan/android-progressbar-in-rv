package az.seyidkanan.progressinlistview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import az.seyidkanan.progressinlistview.model.ContentModel;
import az.seyidkanan.progressinlistview.R;
import az.seyidkanan.progressinlistview.viewholder.ContentViewHolder;
import az.seyidkanan.progressinlistview.viewholder.ProgressViewHolder;

/**
 * Created by Kanan on 3/25/2018.
 */

public class RVAdapter extends RecyclerView.Adapter {

    private List<ContentModel> contentList = new ArrayList<>();

    private final int TYPE_PROGRESS = 1;
    private final int TYPE_TEXT = 2;

    public void setDataList(List<ContentModel> contentListModel) {
        if (getContentList().size() > 0)
            removeElement(getContentList().size() - 1);
        contentList.addAll(contentListModel);
        notifyDataSetChanged();
    }

    private void removeElement(int position) {
        contentList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, contentList.size());
    }

    public void setData(ContentModel content) {
        contentList.add(content);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case TYPE_TEXT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_element, parent, false);
                viewHolder = new ContentViewHolder(view);
                break;
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_element, parent, false);
                viewHolder = new ProgressViewHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_TEXT:
                ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
                contentViewHolder.bind(contentList.get(position).getText());
                break;
            default:

                break;
        }
    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (contentList.get(position).isProgress()) {
            return TYPE_PROGRESS;
        } else {
            return TYPE_TEXT;
        }
    }

    public List<ContentModel> getContentList() {
        return contentList;
    }
}
