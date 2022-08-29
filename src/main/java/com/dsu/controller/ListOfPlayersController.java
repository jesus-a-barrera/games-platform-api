package com.dsu.controller;

import com.dsu.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class ListOfPlayersController {
    
    @PostMapping("/")
    public Player createPlayer(Player player) {
        Player.insertPlayer(player);
        return player;
    }

    @GetMapping("/{idPlayer}")
    public Player getPlayer(@PathVariable int idPlayer) {
        return Player.selectPlayer(idPlayer);
    }

    @GetMapping("/")
    public List<Player> getList() {
        return Player.selectPlayers();
    }

    @DeleteMapping("/{idPlayer}")
    public void deletePlayer(@PathVariable int idPlayer) {
        Player.deletePlayer(idPlayer);
    }
}
