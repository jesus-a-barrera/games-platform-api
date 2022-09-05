package com.dsu.controller.ttt;

import com.dsu.model.*;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    public int availableSquares = 9;
    private TicTacToeRound ticTacToeRound;

    public Square[][] initBoard(Square[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Square(ticTacToeRound.getIdTicTacToeRound(), (i + 1), (j + 1), Piece.selectPiece(3));
            }
        }
        availableSquares =9;
        return board;
    }

    public boolean putPiece(Position position, Piece piece, Square[][] board) {
        if (position.getX() > 3 || position.getY() > 3) return false;
        if (position.getX() <= 0 || position.getY() <= 0) return false;
        if (board[position.getX() - 1][position.getY() - 1].getPiece().equals(Piece.selectPiece(3))) {
            board[position.getX() - 1][position.getY() - 1].setPiece(piece);
            availableSquares--;
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return availableSquares <= 0;
    }

    public Piece getWinner(Square[][] squares) {
        if (!checkRows(squares).equals(Piece.selectPiece(3)))
            return checkRows(squares);
        if (!checkColumns(squares).equals(Piece.selectPiece(3)))
            return checkColumns(squares);
        if (!checkDiagonals(squares).equals(Piece.selectPiece(3)))
            return checkDiagonals(squares);
        return Piece.selectPiece(3);
    }

    private Piece checkRows(Square[][] squares) {
        Piece piece = Piece.selectPiece(3);
        for (Square[] row : squares) {
            if (row[0].getPiece().equals(row[1].getPiece())
             && row[0].getPiece().equals(row[2].getPiece())) {
                piece = row[0].getPiece();
                break;
            }
        }
        return piece;
    }

    private Piece checkColumns(Square[][] squares) {
        Piece piece = Piece.selectPiece(3);
        for (int i = 0; i < 3; i++) {
            if (squares[0][i].getPiece().equals(squares[1][i].getPiece())
             && squares[0][i].getPiece().equals(squares[2][i].getPiece())) {
                piece = squares[0][i].getPiece();
                break;
            }
        }
        return piece;
    }

    private Piece checkDiagonals(Square[][] squares) {
        Piece piece = Piece.selectPiece(3);
        if ((squares[0][0].getPiece().equals(squares[1][1].getPiece())
          && squares[0][0].getPiece().equals(squares[2][2].getPiece()))
          || squares[0][2].getPiece().equals(squares[1][1].getPiece())
          && squares[0][2].getPiece().equals(squares[2][0].getPiece()))
            piece = squares[1][1].getPiece();
        return piece;
    }

    public void setTicTacToeRound(TicTacToeRound ticTacToeRound) {
        this.ticTacToeRound = ticTacToeRound;
    }
}

