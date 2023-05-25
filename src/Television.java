public class Television {
    private boolean poweredOn;
    private boolean muted;
    private int channel;
    private int volume;
    public Television() {
        poweredOn = false;
        muted = false;
        channel = 1;
        volume = 10;

    }

    public boolean isPoweredOn() {
        return poweredOn;
    }

    public boolean setPower(boolean set){
        poweredOn = set;
        return set;
    }

    public int setVolume(int set) {
        volume = set;
        return set;
    }
    public int getVolume() {
        return volume;
    }

    public int getChannel() {
        return channel;
    }

    public int setChannel(int set){
        channel = set;
        return set;
    }

    public boolean isMuted() {
        return muted;
    }
}
