package com.dsu.controller.ttt;

import com.dsu.model.*;
import com.dsu.util.Dice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ttt")

public class TicTacToeController {
    private TicTacToePlayer playerX;
    private TicTacToePlayer playerO;

    @CrossOrigin
    @PostMapping("/")
    public Round start(@RequestBody Player[] players) {
        Round round = null;
        if (players.length == 2) {
            round = new Round();
            players[0] = Player.selectPlayer(players[0].getIdPlayer());
            players[1] = Player.selectPlayer(players[1].getIdPlayer());
            players = assignRoles(players);
            playerX = new TicTacToePlayer(players[0], Piece.selectPiece(1));
            playerO = new TicTacToePlayer(players[1], Piece.selectPiece(2));
            round.setPlayer1(playerX.getPlayer());
            round.setPlayer2(playerO.getPlayer());
            round.setTurn(playerX.getPlayer());
            round.setGame(Game.selectGame(1));
            round = Round.insertRound(round);
            round.setBoard(Board.initBoard(round.getIdRound(), new Square[3][3]));
        }
        return round;
    }

    @CrossOrigin
    @PostMapping("/{idRound}")
    public Round makeMove(@PathVariable int idRound, @RequestBody Movement movement) {
        Round round = Round.selectRound(idRound);
        if (isValidMovement(movement, round) && isCorrectTurn(movement, round) && !round.isFinished()) {
            Position position = movement.getPosition();
            Piece piece = movement.getTicTacToePlayer().getPiece();
            Player player = movement.getTicTacToePlayer().getPlayer();
            Square[][] board = round.getBoard();
            if (Board.putPiece(position, piece, board)) {
                if (Board.isFull() || Board.getWinner(board) != Piece.selectPiece(3)) {
                    round.setFinished(true);
                    if (Board.getWinner(board) != Piece.selectPiece(3))
                        round.setWinner(player);
                }
                player = player.equals(playerX.getPlayer()) ? playerO.getPlayer() : playerX.getPlayer();
                round.setTurn(player);
                round.setBoard(board);
            }
        }
        return round;
    }

    public boolean isValidMovement(Movement movement, Round round) {
        TicTacToePlayer ticTacToePlayer = movement.getTicTacToePlayer();
        Player player = ticTacToePlayer.getPlayer();
        if ((ticTacToePlayer.equals(playerX) || ticTacToePlayer.equals(playerO))
       && (player.equals(round.getPlayer1()) || player.equals(round.getPlayer2())))
            return true;
        return false;
    }

    public boolean isCorrectTurn(Movement movement, Round round) {
        Player player = movement.getTicTacToePlayer().getPlayer();
        Player turn = round.getTurn();
        if (player.equals(turn))
            return true;
        return false;
    }

    private Player[] assignRoles(Player[] gamePlayers) {
        if (Dice.generateValue(100) > 50)
            return new Player[] {gamePlayers[1], gamePlayers[0]};
        return new Player[] {gamePlayers[0], gamePlayers[1]};
    }

}
