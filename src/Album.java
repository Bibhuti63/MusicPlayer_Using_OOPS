import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getArtist() {
        return artist;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    public List<Song> getSongs() {
        return songs;
    }

    void addSongtoAlbum(String name, double duration){
        Song s=new Song(name,duration);
        if(findSong(s.getTitle())==true){
            System.out.println("Song already present in album");
        }
        else{
            songs.add(s);
            System.out.println("New Song ["+name+"] has been added to album");
        }
    }

    public boolean findSong(String title){
        for (Song s: songs){
            if(s.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }


    //Polymorphism
    public void addToPlaylistFromAlbum(String title, LinkedList<Song> playlist){
        if(findSong(title)==true){
            for(Song song: songs){
                if(song.getTitle().equals(title)){
                    playlist.add(song);
                    System.out.println("Song ["+title+"] has been added to playlist");
                    break;
                }
            }
        }
        else{
            System.out.println("Song not present in album");
        }
    }

//    same function diffrent parameter
    public void addToPlaylistFromAlbum(int trackNo, LinkedList<Song> playlist){
        int index = trackNo-1;
        if(index>=0 && index<songs.size()){
            playlist.add(songs.get(index));
            System.out.println("Song has been added to your playlist");
        }
        else{
            System.out.println("Invalid track number");
        }
        return;
    }

}
