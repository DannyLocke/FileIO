package com.ironyard;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Song song = new Song();


    //MAIN METHOD TO RUN
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome, music lovers!");

        //TRY CATCH TO LOAD SONG
        try{
            song = Song.loadSong();
            System.out.println("Loaded saved song");
        }catch(Exception e){
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
        System.out.printf("Song:  %s", song);

        }//end main()


//    public static String nextLine(){
//        String line = scanner.nextLine();
//        while (nextLine().startsWith("/")){
//            switch(line){
//                case "/save":
//                    try{
//                        Song.saveSong(song);
//                        System.out.println("Saved song");
//                    }catch (IOException e){
//                        e.printStackTrace();
//                    }
//                    break;
//
//                case "/exit":
//                    System.exit(0);
//                    break;
//
//                default:
//                    System.out.println("Invalid entry");
//                    break;
//            }//end switch(line)
//            line = scanner.nextLine();
//        }//end while loop
//        return line;
//    }//end nextLine()


}//end class Main
