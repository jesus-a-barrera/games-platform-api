package com.dsu.controller;

import com.dsu.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadData {

    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase() {

        return args -> {
            TypePlayer Human = TypePlayer.insertTypePlayer(new TypePlayer("Human"));
            TypePlayer Bot = TypePlayer.insertTypePlayer(new TypePlayer("Bot"));

            Player.insertPlayer(new Player("Mario", Human));
            Player.insertPlayer(new Player("Antonio", Human));
            Player.insertPlayer(new Player("Manuel", Bot));
            Player.insertPlayer(new Player("Gabi", Bot));


            Game.insertGame(new Game("TicTacToe"));
            Game.insertGame(new Game("HangMan"));

            Piece.insertPiece(new Piece("X"));
            Piece.insertPiece(new Piece("O"));
            Piece.insertPiece(new Piece("-"));
        };

    }


}
