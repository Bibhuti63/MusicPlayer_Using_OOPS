import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static LinkedList<Album> albums=new LinkedList<>();
    public static void main(String[] args) {



        Album album1=new Album("Romantic Song","Arijit Singh");
        album1.addSongtoAlbum("Gerua",4.50);
        album1.addSongtoAlbum("Bolna",4.30);
        album1.addSongtoAlbum("Quafirana",3.50);
        album1.addSongtoAlbum("Dua",5.30);
        album1.addSongtoAlbum("Deva Deva",3.10);

        albums.add(album1);

        Album album2=new Album("Emotional Song","Arif Aslam");
        album2.addSongtoAlbum("Jeena Jeena",6.30);
        album2.addSongtoAlbum("Pehli Dafa",4.40);
        album2.addSongtoAlbum("Be Inteha",2.50);
        album2.addSongtoAlbum("Tu Janena",4.10);

        albums.add(album2);

        boolean flag=album2.findSong("Jeena Jeena");
        System.out.println(flag);

        LinkedList<Song> playlist1=new LinkedList<>();
        album1.addToPlaylistFromAlbum("Dua",playlist1);
        album2.addToPlaylistFromAlbum("Jeena Jeena",playlist1);
        album1.addToPlaylistFromAlbum("Gerua",playlist1);
        album2.addToPlaylistFromAlbum("Tu Janena",playlist1);
        album1.addToPlaylistFromAlbum("Deva Deva",playlist1);

        play(playlist1);
    }
    public static void play(LinkedList<Song>playlist){
        Scanner sc=new Scanner(System.in);
        ListIterator<Song>itr= playlist.listIterator();

        boolean isForward=false;

        if(playlist.size()>0){
            System.out.println("Currently playing "+itr.next());
            isForward=true;
        }
        else{
            System.out.println("Playlist is Empty");
        }

        System.out.println("Enter your choice button");
        printMenu();

        boolean flag=false;
        while(!flag){
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    if(isForward==false){ //if false last operation was previous//if true do nothing
                        itr.next();
                        isForward=true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    else{
                        System.out.println("Reached end of playlist");
                        isForward=false;
                    }
                    break;
                case 2:
                    if(isForward==true){ //if true last operation was next // if false do nothing
                        itr.previous();
                        isForward=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    else{
                        System.out.println("Reached start of playlist");
                        isForward=true;
                    }
                    break;
                case 3:
                    if(isForward==true){
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                            isForward=false;
                        }
                        else{
                            //it will never come to else
                        }
                    }
                    else{ //isForward==false
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isForward=true;
                        }
                        else{
                            //it will come to else statement
                        }
                    }
                    break;
                case 4: printMenu();
                    break;
                case 5:
                    if(isForward==true){
                        itr.previous();
                        isForward=false;
                        if(itr.hasNext())itr.remove();
                    }
                    else{
                        itr.next();
                        isForward=true;
                        if(itr.hasPrevious())itr.remove();
                    }

                    break;
                case 6: printSong(playlist);
                    break;
                case 7:flag=true;
                    break;
            }
        }

    }
    public static void printSong(LinkedList<Song>list){
        for(Song song: list){
            System.out.println(song);
        }
    }
    public static void printMenu(){
        System.out.println("1 - Play next song");
        System.out.println("2 - Play previous song");
        System.out.println("3 - Repeat the current song");
        System.out.println("4 - Show menu again");
        System.out.println("5 - Delete the current song");
        System.out.println("6 - Print all the songs in playlist");
        System.out.println("7 - Exit");
    }

}