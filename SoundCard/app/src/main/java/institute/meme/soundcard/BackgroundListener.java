package institute.meme.soundcard;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.badlogic.gdx.audio.analysis.FFT.*;

public class BackgroundListener {
    public int sample_rate = 44100;
    public BackgroundListener(int _sample_rate, int binsize) {
        sample_rate = _sample_rate;
        short[] buf = new short[sample_rate * 2];
        float[] fftdata = new float[binsize / 2];

        AudioRecord ar = new AudioRecord(MediaRecorder.AudioSource.MIC,
                                         sample_rate,
                                         AudioFormat.CHANNEL_IN_MONO,
                                         AudioFormat.ENCODING_PCM_16BIT,
                                         sample_rate * 2);
        ar.startRecording();
        ar.read(buf, 0, sample_rate * 2);
        double spacing = (double)sample_rate / (double)binsize;
        KissFFT fft = new KissFFT(sample_rate * 2);
        fft.spectrum(buf, fftdata);
        ar.stop();
    }
}
