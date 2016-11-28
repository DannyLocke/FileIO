package com.ironyard;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by dlocke on 11/23/16.
 */

public class Song {
    String name;
    String artist;
    String album;
    String genre;
    boolean onSpotify;

    public Scanner scanner = new Scanner(System.in);

    public Song(String name, String artist, String album, String genre, boolean onSpotify) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.onSpotify = onSpotify;
    }

    public Song(){

    }

    @Override
    public String toString(){
        return this.getName();
    }

    //new song? or update existing song?
    public void chooseName(){
        if(name != null){
        System.out.println("Please update the song, beginning with the name.");
        name = scanner.nextLine();
        } else{
            System.out.println("Please enter the song name.");
            name = scanner.nextLine();
        }
    }

    public void chooseArtist(){
        System.out.println("Please enter the song's artist.");
        artist = scanner.nextLine();
    }

    public void chooseAlbum(){
        System.out.println("Please enter the song's album.");
        album = scanner.nextLine();
    }

    public void chooseGenre(){
        System.out.println("Please enter the song's genre.");
        genre = scanner.nextLine();
    }

    public void chooseOnSpotify(){
        System.out.println("Is the song available on Spotify? [Y/N]");
        String spotify = scanner.nextLine();
        if(spotify.equalsIgnoreCase("Y")){
            onSpotify = true;
        }else{
            onSpotify = false;
        }
    }

    //METHOD TO SAVE SONG
    public static void saveSong(Song song) throws IOException { //the song we want to save
        JsonSerializer s = new JsonSerializer(); //create serialize object
        String json = s.include("*").serialize(song); //serialize everything

        File f = new File("game.json");//create new file
        FileWriter fw = new FileWriter(f); //create writer
        fw.write(json); //write new file
        fw.close(); //close that file
    }//end saveGame()

    //METHOD TO LOAD SONG(S) (scan, parse and return a Song object)
    public static Song loadSong() throws FileNotFoundException {
        File f = new File("game.json");
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();

        JsonParser p = new JsonParser();
        return p.parse(contents, Song.class);
    }//end loadSong()


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isOnSpotify() {
        return onSpotify;
    }

    public void setOnSpotify(boolean onSpotify) {
        this.onSpotify = onSpotify;
    }

}//end class Song
