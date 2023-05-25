import java.util.Scanner;
public class Remote {
    Scanner input = new Scanner(System.in);
    private boolean muted = false;
    private int lastChannel;
    private int lastVolume;
    private int channel = 1;
    private int volume = 10;
    Television tv;
    public Remote() {

    }
        public void printOptions() {
            int choice;
            int inputChannel;

            System.out.println("[1] for Power On/Off\n" +
                    "[2] for Channel Up\n" +
                    "[3] for Channel Down\n" +
                    "[4] for Volume Up\n" +
                    "[5] for Volume Down\n" +
                    "[6] for Mute\n" +
                    "[7] for Flashback Channel\n" +
                    "[8] for Channel Numeric Keypad Entry\n" +
                    "[9] to EXIT\n");
            System.out.print("Please input your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    tvOn();
                    break;
                case 2:
                    channelUp();
                    break;
                case 3:
                    channelDown();
                    break;
                case 4:
                    volumeUp();
                    break;
                case 5:
                    volumeDown();
                    break;
                case 6:
                    mute();
                    break;
                case 7:
                    flashbackChannel();
                    break;
                case 8:
                    inputChannel = input.nextInt();
                    numericKeypad(inputChannel);
                    break;
                case 9:
                    System.out.println("Goodbye! :D");
                    System.exit(0);
            }
        }
        public static Remote connectToTv(Television tv1) {
            Remote remote1 = new Remote();
            remote1.tv = tv1;
            return remote1;
        }
        public void tvOn() {
            if (!tv.isPoweredOn()) {
                tv.setPower(true);
                System.out.println("Television is on");
            } else {
                tv.setPower(false);
                System.out.println("Television is off");
            }
        }

        public void volumeUp() {
            if (tv.isPoweredOn()) {
                if(tv.getVolume() < 40) {
                    lastVolume = tv.getVolume();
                    tv.setVolume(tv.getVolume() + 1);
                    lastVolume = tv.getVolume();
                    System.out.println("Channel : " + tv.getVolume());
                } else if (tv.getVolume() == 1) {
                    tv.setVolume(1);
                    lastVolume = tv.getVolume();
                    System.out.println("Channel : " + tv.getVolume());
                }
            } else {
                System.out.println("TV is at maximum volume of 40");
            }
        }

        public void volumeDown () {
            if (tv.isPoweredOn()) {
                if(tv.getVolume() < 40) {
                    lastVolume = tv.getVolume();
                    tv.setVolume(tv.getVolume() - 1);
                    lastVolume = tv.getVolume();
                    System.out.println("Channel : " + tv.getVolume());
                } else {
                    System.out.println("Television is at the minimum volume of 1");
                }
            } else {
                System.out.println("Television must be turned on to complete actions.");
            }
        }

        public void channelUp() {
            if (tv.isPoweredOn()) {
                if(tv.getChannel() < 9999) {
                    lastChannel = tv.getChannel();
                    tv.setChannel(tv.getChannel() + 1);
                    lastChannel = tv.getChannel();
                    System.out.println("Channel : " + tv.getChannel());
                } else if (tv.getChannel() == 9999) {
                    tv.setChannel(1);
                    lastChannel = tv.getChannel();
                    System.out.println("Channel : " + tv.getChannel());
                }
            } else {
                System.out.println("Television must be turned on to complete actions.");
            }
        }

        public void channelDown() {
            if (tv.isPoweredOn()) {
                if(tv.getChannel() > 1) {
                    lastChannel = tv.getChannel();
                    tv.setChannel(tv.getChannel() - 1);
                    lastChannel = tv.getChannel();
                    System.out.println("Channel : " + tv.getChannel());
                } else if (tv.getChannel() == 1) {
                    lastChannel = tv.getChannel();
                    System.out.println("Channel : " + tv.getChannel());
                }
            } else {
                System.out.println("Television must be turned on to complete actions.");
            }
        }

        public void mute() {
            if(tv.isPoweredOn()) {
                if (!tv.isMuted()) {
                    System.out.println("Television has been muted");
                } else if (tv.isMuted()){
                    muted = true;
                    System.out.println("Television has been unmuted");
                    tv.setVolume(0);
                }
            } else {
                System.out.println("Television must be turned on to complete actions.");
            }
        }

        public void flashbackChannel() {
            lastChannel = tv.getChannel();
            int targetChannel = lastChannel;
            lastChannel = channel;
            tv.setChannel(targetChannel);
            System.out.println("Channel : " + tv.getChannel());
        }

        public void numericKeypad(int inputChannel) {
            if(tv.isPoweredOn()) {
                if(1 <= inputChannel && inputChannel <= 9999) {
                    lastChannel = tv.getChannel();
                    tv.setChannel(inputChannel);
                    System.out.println("Channel : " + tv.getChannel());
                }
            }
        }

}


