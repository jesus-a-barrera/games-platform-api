package com.dsu.controller.ttt;

import com.dsu.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ttt")

public class TicTacToeController {

    @PostMapping("/")
    public Round Start(@RequestBody Player[] players) {
        Round round = new Round();
        round.setPlayer1(players[0]);
        round.setPlayer2(players[1]);
        round.setGame(Game.selectGame(1));
        round = Round.insertRound(round);
        round.setBoard(Board.initBoard(round.getIdRound(), new Square[3][3]));
        return round;
    }

    @PostMapping("/{idRound}")
    public String MakeMove(@PathVariable int idRound, Movement movement) {
        Round round = Round.selectRound(idRound);
        if (Board.putPiece(movement.getPosition(), movement.getTicTacToePlayer().getPiece(), round.getBoard())) {
            return "Hello";
        }
        return "No funciono :(";
        //return ResponseEntity.ok().build();
    }

    @PostMapping("/movement")
    public Movement ViewMovement() {
        Movement movement = new Movement(
                new TicTacToePlayer(new Player("Juan", new TypePlayer("Bot")),
                        Piece.selectPiece(2)),
                new Position(1, 1));
        return movement;
    }
}
