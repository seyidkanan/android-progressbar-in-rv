package az.seyidkanan.progressinlistview.model;

/**
 * Created by Kanan on 3/25/2018.
 */

public class ContentModel {

    private String text;
    private boolean progress = false;

    public ContentModel() {
        progress = true;
    }

    public ContentModel(String text) {
        this.text = text;
        progress = false;
    }

    public boolean isProgress() {
        return progress;
    }

    public void setProgress(boolean progress) {
        this.progress = progress;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ContentModel{" +
                "text='" + text + '\'' +
                ", progress=" + progress +
                '}';
    }
}
