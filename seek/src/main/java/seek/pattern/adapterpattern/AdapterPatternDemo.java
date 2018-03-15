package seek.pattern.adapterpattern;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "see you again");
        audioPlayer.play("vlc", "just for you");
        audioPlayer.play("mp4", "one more time");
    }
}
