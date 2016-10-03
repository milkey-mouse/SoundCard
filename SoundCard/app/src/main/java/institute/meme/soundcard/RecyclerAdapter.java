package institute.meme.soundcard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.List;

import android.content.Intent;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public List<InfoCard> dataSource;
    public RecyclerAdapter(List<InfoCard> dataArgs){
        this.dataSource = dataArgs;
    }

    public void add(InfoCard card) {
        this.dataSource.add(card);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.info_card, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

     @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        InfoCard source = this.dataSource.get(position);
        holder.title.setText(source.title);
        holder.text.setText(source.text);
        holder.icon.setImageResource(source.icon);
        holder.url = source.url;
    }

    @Override
    public int getItemCount() {
        return this.dataSource.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        protected TextView title;
        protected TextView text;
        protected ImageView icon;
        public String url;
        public ViewHolder(final View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            text = (TextView) itemView.findViewById(R.id.text);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    if (url != null) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, android.net.Uri.parse(url));
                        v.getContext().startActivity(browserIntent);
                    }
                }
            });
        }
    }
}