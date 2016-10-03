package institute.meme.soundcard;

import android.app.Activity;

class CardAdder extends Thread {
    Activity activity;
    InfoCard card;
    long sleep;

    public CardAdder(InfoCard card, long sleep, Activity curActivity) {
        this.card = card;
        this.sleep = sleep;
        this.activity = curActivity;
    }

    @Override
    public void run() {
        if (this.sleep > 0) {
            try {
                Thread.sleep(this.sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Runnable addCard = new AddCard(this.card, this.activity);
        this.activity.runOnUiThread(addCard);
    }
}