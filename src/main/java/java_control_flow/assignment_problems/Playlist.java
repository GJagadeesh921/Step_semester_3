public class Playlist {

    private final String[] songs;
    private int songCount;

    public Playlist(int maximumSongs) {
        songs = new String[maximumSongs];
        songCount = 0;
    }

    public void addSong(String song) {

        if (songCount >= songs.length) {
            System.out.println("Song rejected: playlist is full");
            return;
        }

        songs[songCount] = song;
        songCount++;

        System.out.println("Song added: " + song);
    }

    public String[] getSongs() {

        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("Songs in playlist:");

        for (String song : copy) {
            System.out.println(song);
        }

        // Modify the returned copy
        copy[0] = "Hacked";

        System.out.println("Modified copy: " + copy[0]);

        // Check the actual playlist
        String[] actualSongs = p.getSongs();

        System.out.println("Actual first song: " + actualSongs[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}
