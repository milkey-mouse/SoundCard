package institute.meme.soundcard;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.os.PowerManager;
import java.util.LinkedList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    PowerManager pm = null;
    android.os.PowerManager.WakeLock wl = null;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<InfoCard> dataArray = new LinkedList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.card_list);
        recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(dataArray);
        recyclerView.setAdapter(adapter);


        new CardAdder(new InfoCard(CardType.TEXT, "Never Gonna Give You Up by Rick Astley"), 10000, this).start();
        new CardAdder(new InfoCard(CardType.LINK, "https://amazon.com/dp/B00137QS28"), 13000, this).start();

        new CardAdder(new InfoCard(CardType.LINK, "https://meme.institute"), 25000, this).start();
        new CardAdder(new InfoCard(CardType.EMAIL, "milkey-mouse@meme.institute"), 25100, this).start();
        new CardAdder(new InfoCard(CardType.TUMBLR, "scanwiches"), 25200, this).start();
        new CardAdder(new InfoCard(CardType.REDDIT, "Milkey_Mouse"), 25300, this).start();
        new CardAdder(new InfoCard(CardType.TWITTER, "nihilist_arbys"), 25400, this).start();
        new CardAdder(new InfoCard(CardType.SNAPCHAT, "snapmemes"), 25500, this).start();
        new CardAdder(new InfoCard(CardType.FACEBOOK, "memes"), 25600, this).start();
        new CardAdder(new InfoCard(CardType.INSTAGRAM, "memes"), 25700, this).start();

        pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
        wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "FFTs for SoundCard");
        wl.setReferenceCounted(false);

        //BackgroundListener bl = new BackgroundListener(44100, 8192);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (wl != null && wl.isHeld()) {
            wl.release();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wl == null) {
            wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "FFTs for SoundCard");
            wl.setReferenceCounted(false);
        } else if (!wl.isHeld()) {
            wl.acquire();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in androidManifest.xml.

        return super.onOptionsItemSelected(item);
    }
}