package institute.meme.soundcard;

import android.app.Activity;

class AddCard implements Runnable {
    InfoCard card;
    RecyclerAdapter adapter;

    AddCard(InfoCard card, Activity curActivity) {
        this.card = card;
        this.adapter = ((RecyclerAdapter)((MainActivity)curActivity).adapter);
    }

    public void run() {
        this.adapter.add(this.card);
        this.adapter.notifyDataSetChanged();
    }
}