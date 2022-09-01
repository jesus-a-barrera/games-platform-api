package com.dsu.controller.hm;

import com.dsu.model.*;
import com.dsu.util.Dice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hm")
public class HangManController {

    private Player giver;
    private Player guesser;

    @Autowired
    private HangedManService hangedManService;

    @PostMapping("/")
    public HangManRound start(@RequestBody Player[] players) {
        Round round = null;
        HangManRound hangManRound = null;
        if (players.length == 2) {
            round = new Round();
            hangManRound = new HangManRound();
            players = assignRoles(players);
            giver = Player.selectPlayer(players[0].getIdPlayer());
            guesser = Player.selectPlayer(players[1].getIdPlayer());
            round.setPlayer1(giver);
            round.setPlayer2(guesser);
            round.setTurn(giver);
            round.setGame(Game.selectGame(2));
            round = Round.insertRound(round);
            hangManRound.setRound(round);
            hangManRound = HangManRound.insertHangManRound(hangManRound);
        }
        return hangManRound;
    }

    @PostMapping("/{idRound}/secretWord/")
    public HangManRound giveWord(@PathVariable int idRound, @RequestBody Chose chose) {
        HangManRound hangManRound = HangManRound.selectHangManRound(idRound);
        if (isCorrectTurn(chose.getPlayer(), hangManRound.getRound())) {
            hangManRound.setSecretWord(chose.getLetters());
            hangManRound.getRound().setTurn(guesser);
        }
        return hangManRound;
    }

    @PostMapping("/{idRound}/letter/")
    public HangManRound giveLetter(@PathVariable int idRound, @RequestBody Chose chose) {
        HangManRound hangManRound = HangManRound.selectHangManRound(idRound);
        Round round = hangManRound.getRound();
        if(isCorrectTurn(chose.getPlayer(), round) && !round.isFinished()) {
            Letter letter = chose.getLetters()[0];
            Letter[] secretWord = hangManRound.getSecretWord();
            hangedManService.setHangManRound(hangManRound);
            hangedManService.tryLetter(letter);
            if (hangedManService.isSaved() || hangedManService.isDead()) {
                round.setFinished(true);
                if (hangedManService.isSaved()) round.setWinner(guesser);
                else if (hangedManService.isDead()) round.setWinner(giver);
            }
            hangManRound.setSecretWord(secretWord);
        }
        return hangManRound;
    }

    private boolean isCorrectTurn(Player player, Round round) {
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
