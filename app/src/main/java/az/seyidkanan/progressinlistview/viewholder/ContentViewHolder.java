package az.seyidkanan.progressinlistview.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import az.seyidkanan.progressinlistview.R;

/**
 * Created by Kanan on 3/25/2018.
 */

public class ContentViewHolder extends RecyclerView.ViewHolder {

    private TextView contentTextView;

    public ContentViewHolder(View itemView) {
        super(itemView);
        contentTextView = (TextView) itemView.findViewById(R.id.contentTextView);
    }

    public void bind(String text) {
        contentTextView.setText(text);
    }

}
