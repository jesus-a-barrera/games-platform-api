package com.dsu.controller.hm;

import com.dsu.model.HangManRound;
import com.dsu.model.Letter;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class HangedManService {

    private HangManRound hangManRound;

    public void tryLetter(Letter letter) {
        boolean result = false;
        for (Letter secretLetter : hangManRound.getSecretWord()) {
            if (secretLetter.getCharacter() == letter.getCharacter()) {
                secretLetter.setIsShown(true);
                result = true;
            }
        }
        hangManRound.setAttempts(hangManRound.getAttempts() + 1);
        if (!result) hangManRound.setFailedAttempts(hangManRound.getFailedAttempts() + 1);
    }

    public boolean isSaved() {
        return Arrays.stream(hangManRound.getSecretWord()).allMatch(Letter::getIsShown);
    }

    public boolean isDead() {
        return hangManRound.getFailedAttempts() >= hangManRound.getMAX_NUMBER_OF_ATTEMPTS();
    }

    public HangManRound getHangManRound() {
        return hangManRound;
    }

    public void setHangManRound(HangManRound hangManRound) {
        this.hangManRound = hangManRound;
    }
}
