package com.dsu.controller.ttt;

import com.dsu.model.*;
import com.dsu.util.Dice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ttt")

public class TicTacToeController {

    private TicTacToePlayer playerX;
    private TicTacToePlayer playerO;

    @Autowired
    private BoardService boardService;

    @CrossOrigin
    @PostMapping("/")
    public TicTacToeRound start(@RequestBody Player[] players) {
        Round round = null;
        TicTacToeRound ticTacToeRound = null;
        if (players.length == 2) {
            round = new Round();
            ticTacToeRound = new TicTacToeRound();
            players = assignRoles(players);
            playerX = new TicTacToePlayer(Player.selectPlayer(players[0].getIdPlayer()), Piece.selectPiece(1));
            playerO = new TicTacToePlayer(Player.selectPlayer(players[1].getIdPlayer()), Piece.selectPiece(2));
            round.setPlayer1(playerX.getPlayer());
            round.setPlayer2(playerO.getPlayer());
            round.setTurn(playerX.getPlayer());
            round.setGame(Game.selectGame(1));
            round = Round.insertRound(round);
            ticTacToeRound.setRound(round);
            TicTacToeRound.insertTicTacToeRound(ticTacToeRound);
            boardService.setTicTacToeRound(ticTacToeRound);
            ticTacToeRound.setBoard(boardService.initBoard(new Square[3][3]));
        }
        return ticTacToeRound;
    }

    @CrossOrigin
    @PostMapping("/{idRound}")
    public TicTacToeRound makeMove(@PathVariable int idRound, @RequestBody Movement movement) {
        TicTacToeRound ticTacToeRound = TicTacToeRound.selectTicTacToeRound(idRound);
        Round round = ticTacToeRound.getRound();
        Position position = movement.getPosition();
        Piece piece = movement.getTicTacToePlayer().getPiece();
        Player player = movement.getTicTacToePlayer().getPlayer();
        if (isValidMovement(movement, round) && isCorrectTurn(player, round) && !round.isFinished()) {
            Square[][] board = ticTacToeRound.getBoard();
            if (boardService.putPiece(position, piece, board)) {
                if (boardService.isFull() || boardService.getWinner(board) != Piece.selectPiece(3)) {
                    round.setFinished(true);
                    if (boardService.getWinner(board) != Piece.selectPiece(3))
                        round.setWinner(player);
                }
                player = player.equals(playerX.getPlayer()) ? playerO.getPlayer() : playerX.getPlayer();
                round.setTurn(player);
                ticTacToeRound.setBoard(board);
                ticTacToeRound.setRound(round);
            }
        }
        return ticTacToeRound;
    }

    public boolean isValidMovement(Movement movement, Round round) {
        TicTacToePlayer ticTacToePlayer = movement.getTicTacToePlayer();
        Player player = ticTacToePlayer.getPlayer();
        return (ticTacToePlayer.equals(playerX) || ticTacToePlayer.equals(playerO))
                && (player.equals(round.getPlayer1()) || player.equals(round.getPlayer2()));
    }

    public boolean isCorrectTurn(Player player, Round round) {
        Player turn = round.getTurn();
        return player.equals(turn);
    }

    private Player[] assignRoles(Player[] gamePlayers) {
        if (Dice.generateValue(100) > 50)
            return new Player[] {gamePlayers[1], gamePlayers[0]};
        return new Player[] {gamePlayers[0], gamePlayers[1]};
    }

}
