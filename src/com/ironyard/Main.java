package com.ironyard;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Song song = new Song();


    //MAIN METHOD TO RUN
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome, music lovers!");

        while(true) {
            //TRY CATCH TO LOAD SONG
            try {
                song = Song.loadSong();
                System.out.println("Loaded saved song");
            } catch (Exception e) {
                System.out.println("Enter a new song");
            }
            //METHODS TO GATHER USER INPUT
            song.chooseName();
            song.chooseArtist();
            song.chooseAlbum();
            song.chooseGenre();
            song.chooseOnSpotify();

            //CALL saveSong(song)
            Song.saveSong(song);

            //VERIFY SAVED SONG
            System.out.printf("Song:  %s\n Artist: %s\n Album: %s\n Genre: %s\n On Spotify: %b", song.getName(), song.getArtist(), song.getAlbum(), song.getGenre(), song.isOnSpotify());
        }
        }//end main()

}//end class Main
