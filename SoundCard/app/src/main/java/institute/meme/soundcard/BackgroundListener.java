package institute.meme.soundcard;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;

public class BackgroundListener {
    public int sample_rate = 44100;
    byte[] fftBytes = null;

    public BackgroundListener() {

        short[] buf = new short[AudioRecord.getMinBufferSize(sample_rate,
                                                             AudioFormat.CHANNEL_IN_MONO,
                                                             AudioFormat.ENCODING_PCM_16BIT)];
        AudioRecord ar = new AudioRecord(MediaRecorder.AudioSource.MIC,
                                         sample_rate,
                                         AudioFormat.CHANNEL_IN_MONO,
                                         AudioFormat.ENCODING_PCM_16BIT,
                                         buf.length);
        System.out.println(ar.getState() == AudioRecord.STATE_INITIALIZED);
        System.out.println(ar.getRecordingState() == AudioRecord.STATE_INITIALIZED);
        sample_rate = ar.getSampleRate();
        ar.startRecording();
        ar.read(buf, 0, buf.length);

        ar.stop();
        ar.release();
    }
}
