package com.example.hivewithaiproject;

import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

import java.lang.reflect.Field;

import java.lang.Object;
class HiveWithAI {
    static final int widthBoard = 4, heightBoard = 8;
//    Piece[][] currentBoard = new Piece[heightBoard][widthBoard];
//    Stack<Coordinate> stackPossibleMoves = new Stack<Coordinate>();
//    Stack<AIPiece> ListPossibleMoves = new Stack<AIPiece>();
    Stack possibleMoves;
    int turnColor;
    boolean Check;

    public HiveWithAI() {
//        InitPieceBoard();
        this.setTurnColor(Color.WHITE);
        this.setCheck(false);
    }

//    public Stack<Coordinate> getStackPossibleMoves() {
//        return stackPossibleMoves;
//    }
//
//    public void setStackPossibleMoves(Stack<Coordinate> stackPossibleMoves) {
//        this.stackPossibleMoves = stackPossibleMoves;
//    }

    /*public Stack<AIPiece> getListPossibleMoves() {
        return ListPossibleMoves;
    }

    public void setListPossibleMoves(Stack<AIPiece> stackPossibleMoves) {
        this.ListPossibleMoves = stackPossibleMoves;
    }*/

//    public HalfChess(Context context) {
//        this.context = context.getApplicationContext();
//    }

    public static int getWidthBoard() {
        return widthBoard;
    }

    public static int getHeightBoard() {
        return heightBoard;
    }

//    public Piece[][] getCurrentBoard() {
//        return currentBoard;
//    }
//
//    public void setCurrentBoard(Piece[][] currentBoard) {
//        this.currentBoard = currentBoard;
//    }

    public int getTurnColor() {
        return turnColor;
    }

    public void setTurnColor(int turnColor) {
        this.turnColor = turnColor;
    }

    public boolean isCheck() {
        return Check;
    }

    public void setCheck(boolean check) {
        Check = check;
    }

    public Stack getPossibleMoves() {
        return possibleMoves;
    }

    public void setPossibleMoves(Stack possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

//    public int WeightPiece(Piece piece, int color) {
//        if (piece instanceof King)
//            return color == Color.WHITE ? 1000 : -1000;
//        else if (piece instanceof Queen)
//            return color == Color.WHITE ? 200 : -200;
//        else if (piece instanceof Knight)
//            return color == Color.WHITE ? 80 : -80;
//        else if (piece instanceof Bishop)
//            return color == Color.WHITE ? 80 : -80;
//        else if (piece instanceof Pawn)
//            return color == Color.WHITE ? 20 : -20;
//        else return 0;
//    }


//    public void minimaxRoot (int depth, boolean isMaximisingPlayer) {
//
//        var newGameMoves = game.ugly_moves();
//        var bestMove = -9999;
//        var bestMoveFound;
//
//        for(var i = 0; i < newGameMoves.length; i++) {
//            var newGameMove = newGameMoves[i]
//            game.ugly_move(newGameMove);
//            var value = minimax(depth - 1, game, -10000, 10000, !isMaximisingPlayer);
//            game.undo();
//            if(value >= bestMove) {
//                bestMove = value;
//                bestMoveFound = newGameMove;
//            }
//        }
//        return bestMoveFound;
//    };

//    var minimax = function (depth, game, alpha, beta, isMaximisingPlayer) {
//        positionCount++;
//        if (depth === 0) {
//            return -evaluateBoard(game.board());
//        }
//
//        var newGameMoves = game.ugly_moves();
//
//        if (isMaximisingPlayer) {
//            var bestMove = -9999;
//            for (var i = 0; i < newGameMoves.length; i++) {
//                game.ugly_move(newGameMoves[i]);
//                bestMove = Math.max(bestMove, minimax(depth - 1, game, alpha, beta, !isMaximisingPlayer));
//                game.undo();
//                alpha = Math.max(alpha, bestMove);
//                if (beta <= alpha) {
//                    return bestMove;
//                }
//            }
//            return bestMove;
//        } else {
//            var bestMove = 9999;
//            for (var i = 0; i < newGameMoves.length; i++) {
//                game.ugly_move(newGameMoves[i]);
//                bestMove = Math.min(bestMove, minimax(depth - 1, game, alpha, beta, !isMaximisingPlayer));
//                game.undo();
//                beta = Math.min(beta, bestMove);
//                if (beta <= alpha) {
//                    return bestMove;
//                }
//            }
//            return bestMove;
//        }
//    };
//
//    var evaluateBoard = function (board) {
//        var totalEvaluation = 0;
//        for (var i = 0; i < 8; i++) {
//            for (var j = 0; j < 8; j++) {
//                totalEvaluation = totalEvaluation + getPieceValue(board[i][j], i ,j);
//            }
//        }
//        return totalEvaluation;
//    };

    /*private void InitPieceBoard() {
        Integer PieceColor = 0;
        Piece PieceType;
        Integer[][] SquarePosition;
        for (int i = 0; i < this.getHeightBoard(); i++) {
            for (int j = 0; j < this.getWidthBoard(); j++) {
                //Context context;
                //Toast.makeText(HalfChess.this.context,"ihc = "+i, Toast.LENGTH_SHORT).show();
                //Toast.makeText(HalfChess.this.context,"jhc = "+j, Toast.LENGTH_SHORT).show();
                if (i <= 1) PieceColor = Color.BLACK;
                else if (i >= 6) PieceColor = Color.WHITE;
                if (i == 0 || i == 7) {
                    if (j == 0) PieceType = new King(PieceColor, j, i);
                    else if (j == 1) PieceType = new Queen(PieceColor, j, i);
                    else if (j == 2) PieceType = new Knight(PieceColor, j, i);
                    else PieceType = new Bishop(PieceColor, j, i);
                }
                else if (i == 1 || i == 6) {
                    PieceType = new Pawn(PieceColor, j, i);
                }
                else PieceType = null;
                currentBoard[i][j] = PieceType;
                //currentBoard.put(PieceType.getTeamColor(), PieceType);
//                if (i < 2 || i > 5)
//                if (i == 1 || i == 6) currentBoard.put(PieceType.getTeamColor(), PieceType);

                //SquarePosition[i][j]=i;
//                coordinate.Position_X.setPosition(j);
//                coordinate.Position_Y.setPosition(i);
//                currentBoard.put(coordinate, PieceType);
                //currentBoard.put(PieceType.getTeamColor(), PieceType);
            }
        }
    }

    Integer CountLegalMove(HalfChess halfchess, Integer From_Position_X, Integer From_Position_Y) {
        Integer Count_Legal_Move = 0;
        for (Integer Position_Y = 0; Position_Y < getWidthBoard(); Position_Y++) {
            for (Integer Position_X = 0; Position_X < getHeightBoard(); Position_X++) {
                if (halfchess.getCurrentBoard()[From_Position_X][From_Position_Y] instanceof King && ((King)halfchess.getCurrentBoard()[From_Position_X][From_Position_Y]).Rule(halfchess.getTurnColor(), halfchess.getCurrentBoard(), halfchess.getCurrentBoard()[From_Position_X][From_Position_Y], From_Position_X, From_Position_Y, Position_X, Position_Y) ||
                    halfchess.getCurrentBoard()[From_Position_X][From_Position_Y] instanceof Queen && ((Queen)halfchess.getCurrentBoard()[From_Position_X][From_Position_Y]).Rule(halfchess.getTurnColor(), halfchess.getCurrentBoard(), halfchess.getCurrentBoard()[From_Position_X][From_Position_Y], From_Position_X, From_Position_Y, Position_X, Position_Y) ||
                    halfchess.getCurrentBoard()[From_Position_X][From_Position_Y] instanceof Knight && ((Knight)halfchess.getCurrentBoard()[From_Position_X][From_Position_Y]).Rule(halfchess.getTurnColor(), halfchess.getCurrentBoard(), halfchess.getCurrentBoard()[From_Position_X][From_Position_Y], From_Position_X, From_Position_Y, Position_X, Position_Y) ||
                    halfchess.getCurrentBoard()[From_Position_X][From_Position_Y] instanceof Bishop && ((Bishop)halfchess.getCurrentBoard()[From_Position_X][From_Position_Y]).Rule(halfchess.getTurnColor(), halfchess.getCurrentBoard(), halfchess.getCurrentBoard()[From_Position_X][From_Position_Y], From_Position_X, From_Position_Y, Position_X, Position_Y) ||
                    halfchess.getCurrentBoard()[From_Position_X][From_Position_Y] instanceof Pawn && ((Pawn)halfchess.getCurrentBoard()[From_Position_X][From_Position_Y]).Rule(halfchess.getTurnColor(), halfchess.getCurrentBoard(), halfchess.getCurrentBoard()[From_Position_X][From_Position_Y], From_Position_X, From_Position_Y, Position_X, Position_Y)) {
                    ++Count_Legal_Move;
                }
            }
        }
        return Count_Legal_Move;
    }*/

}

//class Coordinate {
//    public int Coordinate_X;
//    public int Coordinate_Y;
//    Coordinate(int Coordinate_X, int Coordinate_Y) {
//        this.Coordinate_X = Coordinate_X;
//        this.Coordinate_Y = Coordinate_Y;
//    }
//}
//
//class AIPiece {
//    public Piece pieceType;
//    public Integer teamColor;
//    public int Current_Coordinate_X;
//    public int Current_Coordinate_Y;
//    public int Next_Coordinate_X;
//    public int Next_Coordinate_Y;
//    AIPiece(Piece pieceType, Integer color, Integer Current_Coordinate_X, Integer Current_Coordinate_Y, Integer Next_Coordinate_X, Integer Next_Coordinate_Y) {
//        this.pieceType = pieceType;
//        this.teamColor = color;
//        this.Current_Coordinate_X = Current_Coordinate_X;
//        this.Current_Coordinate_Y = Current_Coordinate_Y;
//        this.Next_Coordinate_X = Next_Coordinate_X;
//        this.Next_Coordinate_Y = Next_Coordinate_Y;
//    }
//}
//
//class Piece {
//    protected Integer teamColor;
////    protected char symbolPiece;
//    protected boolean allowMove;
//    Coordinate coordinatePiece;
//    protected Integer Weight;
//    protected Integer ValueP;
//
//    Piece(Integer color, Integer Coordinate_X, Integer Coordinate_Y) {
//        this.setTeamColor(color);
//        this.allowMove = true;
//        this.setCoordinatePiece(new Coordinate(Coordinate_X, Coordinate_Y));
//    }
//
//    public Integer getTeamColor() {
//        return teamColor;
//    }
//
//    public void setTeamColor(Integer teamColor) {
//        this.teamColor = teamColor;
//    }
//
//    public boolean isAllowMove() {
//        return allowMove;
//    }
//
//    public void setAllowMove(boolean allowMove) {
//        this.allowMove = allowMove;
//    }
//
//    public Coordinate getCoordinatePiece() {
//        return coordinatePiece;
//    }
//
//    public void setCoordinatePiece(Coordinate coordinatePiece) {
//        this.coordinatePiece = coordinatePiece;
//    }
//
//    //    public char getSymbolPiece() {
////        return symbolPiece;
////    }
////
////    public void setSymbolPiece(char symbolPiece) {
////        this.symbolPiece = symbolPiece;
////    }
//
//}
//
//class King extends Piece {
//    King(Integer color, Integer Coordinate_X, Integer Coordinate_Y) {
//        super(color, Coordinate_X, Coordinate_Y);
//        //this.setSymbolPiece('k');
////        this.teamColor = getTeamColor();
//    }
//
//    boolean Rule(int turn, Piece[][] board, Piece myPiece, int From_Position_X, int From_Position_Y, int To_Position_X, int To_Position_Y) {
//        if (Math.abs(To_Position_X - From_Position_X) == 1 && Math.abs(To_Position_Y - From_Position_Y) <= 1 || Math.abs(To_Position_Y - From_Position_Y) == 1 && Math.abs(To_Position_X - From_Position_X) <= 1) {
//            if (myPiece.getTeamColor() == Color.WHITE && turn == Color.WHITE && (board[To_Position_X][To_Position_Y] == null || board[To_Position_X][To_Position_Y] != null && board[To_Position_X][To_Position_Y].getTeamColor() != Color.WHITE)) {
//                // Check Mobility Enemy Piece
//                for (Integer Position_Y = 0; Position_Y < HalfChess.getWidthBoard(); Position_Y++) {
//                    for (Integer Position_X = 0; Position_X < HalfChess.getHeightBoard(); Position_X++) {
//                        if (board[Position_X][Position_Y] != null && board[Position_X][Position_Y].getTeamColor() != Color.WHITE) {
//                            if (board[Position_X][Position_Y] instanceof Pawn && ((Pawn) board[Position_X][Position_Y]).Rule(Color.BLACK, board, board[Position_X][Position_Y], Position_X, Position_Y, To_Position_X, To_Position_Y) ||
//                                    board[Position_X][Position_Y] instanceof King && ((King) board[Position_X][Position_Y]).Rule(Color.BLACK, board, board[Position_X][Position_Y], Position_X, Position_Y, To_Position_X, To_Position_Y) ||
//                                    board[Position_X][Position_Y] instanceof Knight && ((Knight) board[Position_X][Position_Y]).Rule(Color.BLACK, board, board[Position_X][Position_Y], Position_X, Position_Y, To_Position_X, To_Position_Y) ||
//                                    board[Position_X][Position_Y] instanceof Bishop && ((Bishop) board[Position_X][Position_Y]).Rule(Color.BLACK, board, board[Position_X][Position_Y], Position_X, Position_Y, To_Position_X, To_Position_Y) ||
//                                    board[Position_X][Position_Y] instanceof Queen && ((Queen) board[Position_X][Position_Y]).Rule(Color.BLACK, board, board[Position_X][Position_Y], Position_X, Position_Y, To_Position_X, To_Position_Y)) {
//                                return false;
//                            }
//                        }
//                    }
//                }
//                return true;
//            } else if (myPiece.getTeamColor() == Color.BLACK && turn == Color.BLACK && (board[To_Position_X][To_Position_Y] == null || board[To_Position_X][To_Position_Y] != null && board[To_Position_X][To_Position_Y].getTeamColor() != Color.BLACK)) {
//                // Check Mobility Enemy Piece
//                for (Integer Position_Y = 0; Position_Y < HalfChess.getWidthBoard(); Position_Y++) {
//                    for (Integer Position_X = 0; Position_X < HalfChess.getHeightBoard(); Position_X++) {
//                        if (board[Position_X][Position_Y] != null && board[Position_X][Position_Y].getTeamColor() != Color.BLACK) {
//                            if (board[Position_X][Position_Y] instanceof Pawn && ((Pawn) board[Position_X][Position_Y]).Rule(Color.WHITE, board, board[Position_X][Position_Y], Position_X, Position_Y, To_Position_X, To_Position_Y) ||
//                                    board[Position_X][Position_Y] instanceof King && ((King) board[Position_X][Position_Y]).Rule(Color.WHITE, board, board[Position_X][Position_Y], Position_X, Position_Y, To_Position_X, To_Position_Y) ||
//                                    board[Position_X][Position_Y] instanceof Knight && ((Knight) board[Position_X][Position_Y]).Rule(Color.WHITE, board, board[Position_X][Position_Y], Position_X, Position_Y, To_Position_X, To_Position_Y) ||
//                                    board[Position_X][Position_Y] instanceof Bishop && ((Bishop) board[Position_X][Position_Y]).Rule(Color.WHITE, board, board[Position_X][Position_Y], Position_X, Position_Y, To_Position_X, To_Position_Y) ||
//                                    board[Position_X][Position_Y] instanceof Queen && ((Queen) board[Position_X][Position_Y]).Rule(Color.WHITE, board, board[Position_X][Position_Y], Position_X, Position_Y, To_Position_X, To_Position_Y)) {
//                                return false;
//                            }
//                        }
//                    }
//                }
//                return true;
//            }
//        }
//        return false;
//    }
//}
//
//class Queen extends Piece {
//    Queen(Integer color, Integer Coordinate_X, Integer Coordinate_Y) {
//        super(color, Coordinate_X, Coordinate_Y);
//    }
//
//    boolean Rule(int turn, Piece[][] board, Piece myPiece, int From_Position_X, int From_Position_Y, int To_Position_X, int To_Position_Y) {
//        if (myPiece.isAllowMove() && CrossDiagonalSquare(board, From_Position_X, From_Position_Y, From_Position_X, From_Position_Y, To_Position_X, To_Position_Y) && (Math.abs(To_Position_Y - From_Position_Y) == Math.abs(To_Position_X - From_Position_X) && Math.abs(To_Position_Y - From_Position_Y) > 0 && Math.abs(To_Position_X - From_Position_X) > 0 || To_Position_Y - From_Position_Y == 0 && Math.abs(To_Position_X - From_Position_X) > 0 || Math.abs(To_Position_Y - From_Position_Y) > 0 && To_Position_X - From_Position_X == 0)) {
//            if (myPiece.getTeamColor() == Color.WHITE && turn == Color.WHITE && (board[To_Position_X][To_Position_Y] == null || board[To_Position_X][To_Position_Y] != null && board[To_Position_X][To_Position_Y].getTeamColor() != Color.WHITE)) {
//                return true;
//            } else if (myPiece.getTeamColor() == Color.BLACK && turn == Color.BLACK && (board[To_Position_X][To_Position_Y] == null || board[To_Position_X][To_Position_Y] != null && board[To_Position_X][To_Position_Y].getTeamColor() != Color.BLACK)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    boolean RuleInCheck() {
//        return false;
//    }
//
//    boolean CrossDiagonalSquare(Piece[][] board, int From_Position_X, int From_Position_Y, int Current_Position_X, int Current_Position_Y, int To_Position_X, int To_Position_Y) {
//        if (To_Position_X != Current_Position_X || To_Position_Y != Current_Position_Y) {
//            if (Current_Position_X != From_Position_X || Current_Position_Y != From_Position_Y) {
//                if (board[Current_Position_X][Current_Position_Y] != null && (!(board[Current_Position_X][Current_Position_Y] instanceof King) || board[Current_Position_X][Current_Position_Y] instanceof King && board[Current_Position_X][Current_Position_Y].getTeamColor() == board[From_Position_X][From_Position_Y].getTeamColor())) {
//                    return false;
//                }
//            }
//            if (To_Position_X < Current_Position_X && To_Position_Y > Current_Position_Y)
//                return CrossDiagonalSquare(board, From_Position_X, From_Position_Y, Current_Position_X - 1, Current_Position_Y + 1, To_Position_X, To_Position_Y);
//            else if (To_Position_X > Current_Position_X && To_Position_Y > Current_Position_Y)
//                return CrossDiagonalSquare(board, From_Position_X, From_Position_Y, Current_Position_X + 1, Current_Position_Y + 1, To_Position_X, To_Position_Y);
//            else if (To_Position_X > Current_Position_X && To_Position_Y < Current_Position_Y)
//                return CrossDiagonalSquare(board, From_Position_X, From_Position_Y, Current_Position_X + 1, Current_Position_Y - 1, To_Position_X, To_Position_Y);
//            else if (To_Position_X < Current_Position_X && To_Position_Y < Current_Position_Y)
//                return CrossDiagonalSquare(board, From_Position_X, From_Position_Y, Current_Position_X - 1, Current_Position_Y - 1, To_Position_X, To_Position_Y);
//            else if (To_Position_X == Current_Position_X && To_Position_Y < Current_Position_Y)
//                return CrossDiagonalSquare(board, From_Position_X, From_Position_Y, Current_Position_X, Current_Position_Y - 1, To_Position_X, To_Position_Y);
//            else if (To_Position_X == Current_Position_X && To_Position_Y > Current_Position_Y)
//                return CrossDiagonalSquare(board, From_Position_X, From_Position_Y, Current_Position_X, Current_Position_Y + 1, To_Position_X, To_Position_Y);
//            else if (To_Position_X < Current_Position_X && To_Position_Y == Current_Position_Y)
//                return CrossDiagonalSquare(board, From_Position_X, From_Position_Y, Current_Position_X - 1, Current_Position_Y, To_Position_X, To_Position_Y);
//            else if (To_Position_X > Current_Position_X && To_Position_Y == Current_Position_Y)
//                return CrossDiagonalSquare(board, From_Position_X, From_Position_Y, Current_Position_X + 1, Current_Position_Y, To_Position_X, To_Position_Y);
//        }
//        return true;
//    }
//}
//
//class Knight extends Piece {
//    Knight(Integer color, Integer Coordinate_X, Integer Coordinate_Y) {
//        super(color, Coordinate_X, Coordinate_Y);
//    }
//
//    boolean Rule(int turn, Piece[][] board, Piece myPiece, int From_Position_X, int From_Position_Y, int To_Position_X, int To_Position_Y) {
//        if (myPiece.isAllowMove() && Math.abs(To_Position_Y - From_Position_Y) == 1 && Math.abs(To_Position_X - From_Position_X) == 2 || Math.abs(To_Position_Y - From_Position_Y) == 2 && Math.abs(To_Position_X - From_Position_X) == 1) {
//            if (myPiece.getTeamColor() == Color.WHITE && turn == Color.WHITE && (board[To_Position_X][To_Position_Y] == null || board[To_Position_X][To_Position_Y] != null && board[To_Position_X][To_Position_Y].getTeamColor() != Color.WHITE)) {
//                return true;
//            } else if (myPiece.getTeamColor() == Color.BLACK && turn == Color.BLACK && (board[To_Position_X][To_Position_Y] == null || board[To_Position_X][To_Position_Y] != null && board[To_Position_X][To_Position_Y].getTeamColor() != Color.BLACK)) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
//
//class Bishop extends Piece {
//    Bishop(Integer color, Integer Coordinate_X, Integer Coordinate_Y) {
//        super(color, Coordinate_X, Coordinate_Y);
//    }
//
//    boolean Rule(int turn, Piece[][] board, Piece myPiece, int From_Position_X, int From_Position_Y, int To_Position_X, int To_Position_Y) {
//        if (myPiece.isAllowMove() && DiagonalSquare(board, From_Position_X, From_Position_Y, From_Position_X, From_Position_Y, To_Position_X, To_Position_Y) && Math.abs(To_Position_Y - From_Position_Y) == Math.abs(To_Position_X - From_Position_X) && Math.abs(To_Position_Y - From_Position_Y) > 0 && Math.abs(To_Position_X - From_Position_X) > 0) {
//            if (myPiece.getTeamColor() == Color.WHITE && turn == Color.WHITE && (board[To_Position_X][To_Position_Y] == null || board[To_Position_X][To_Position_Y] != null && board[To_Position_X][To_Position_Y].getTeamColor() != Color.WHITE)) {
//                return true;
//            } else if (myPiece.getTeamColor() == Color.BLACK && turn == Color.BLACK && (board[To_Position_X][To_Position_Y] == null || board[To_Position_X][To_Position_Y] != null && board[To_Position_X][To_Position_Y].getTeamColor() != Color.BLACK)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    boolean DiagonalSquare(Piece[][] board, int From_Position_X, int From_Position_Y, int Current_Position_X, int Current_Position_Y, int To_Position_X, int To_Position_Y) {
//        if (To_Position_X != Current_Position_X && To_Position_Y != Current_Position_Y) {
//            if (Current_Position_X != From_Position_X && Current_Position_Y != From_Position_Y) {
//                if (board[Current_Position_X][Current_Position_Y] != null && (!(board[Current_Position_X][Current_Position_Y] instanceof King) || board[Current_Position_X][Current_Position_Y] instanceof King && board[Current_Position_X][Current_Position_Y].getTeamColor() == board[From_Position_X][From_Position_Y].getTeamColor())) {
//                    return false;
//                }
//            }
//            if (To_Position_X < Current_Position_X && To_Position_Y > Current_Position_Y)
//                return DiagonalSquare(board, From_Position_X, From_Position_Y, Current_Position_X - 1, Current_Position_Y + 1, To_Position_X, To_Position_Y);
//            else if (To_Position_X > Current_Position_X && To_Position_Y > Current_Position_Y)
//                return DiagonalSquare(board, From_Position_X, From_Position_Y, Current_Position_X + 1, Current_Position_Y + 1, To_Position_X, To_Position_Y);
//            else if (To_Position_X > Current_Position_X && To_Position_Y < Current_Position_Y)
//                return DiagonalSquare(board, From_Position_X, From_Position_Y, Current_Position_X + 1, Current_Position_Y - 1, To_Position_X, To_Position_Y);
//            else
//                return DiagonalSquare(board, From_Position_X, From_Position_Y, Current_Position_X - 1, Current_Position_Y - 1, To_Position_X, To_Position_Y);
//        }
//        return true;
//    }
//}
//
//class Pawn extends Piece {
//    boolean enPassant;
//    Pawn(Integer color, Integer Coordinate_X, Integer Coordinate_Y) {
//        super(color, Coordinate_X, Coordinate_Y);
//        this.setEnPassant(false);
//    }
//
//    public boolean isEnPassant() {
//        return enPassant;
//    }
//
//    public void setEnPassant(boolean enPassant) {
//        this.enPassant = enPassant;
//    }
//
//    boolean Rule(int turn, Piece[][] board, Piece myPiece, int From_Position_X, int From_Position_Y, int To_Position_X, int To_Position_Y) {
//        if (myPiece.isAllowMove() && myPiece.getTeamColor() == Color.WHITE && turn == Color.WHITE && From_Position_X >= 0) {
//            // Eat Piece Rule
//            if (board[To_Position_X][To_Position_Y] != null && board[To_Position_X][To_Position_Y].getTeamColor() != Color.WHITE && To_Position_X == From_Position_X - 1 && Math.abs(To_Position_Y - From_Position_Y) == 1) {
//                return true;
//            }
//
//            // En Passant Rule
//            if (From_Position_X == 3 && board[From_Position_X][To_Position_Y] != null && board[From_Position_X][To_Position_Y] instanceof Pawn && board[From_Position_X][To_Position_Y].getTeamColor() != Color.WHITE && ((Pawn) board[From_Position_X][To_Position_Y]).isEnPassant() && Math.abs(To_Position_Y - From_Position_Y) == 1 && To_Position_X - From_Position_X == -1) {
//                return true;
//            }
//
//            // Move Rule
//            if ((From_Position_X == 6 && To_Position_X - From_Position_X == -2 || To_Position_X - From_Position_X == -1) && To_Position_Y - From_Position_Y == 0 && DoubleSquare(board, myPiece, From_Position_X - 1, From_Position_Y, To_Position_X)) {
//                return true;
//            }
//        }
//        else if (myPiece.isAllowMove() && myPiece.getTeamColor() == Color.BLACK && turn == Color.BLACK /*&& From_Position_X > 0*/ && From_Position_X <= HalfChess.getHeightBoard() - 1) {
//            // Eat Piece Rule
//            if (board[To_Position_X][To_Position_Y] != null && board[To_Position_X][To_Position_Y].getTeamColor() != Color.BLACK && To_Position_X == From_Position_X + 1 && Math.abs(To_Position_Y - From_Position_Y) == 1) {
//                return true;
//            }
//
//            // En Passant Rule
//            if (From_Position_X == 4 && board[From_Position_X][To_Position_Y] != null && board[From_Position_X][To_Position_Y] instanceof Pawn && board[From_Position_X][To_Position_Y].getTeamColor() != Color.BLACK && ((Pawn) board[From_Position_X][To_Position_Y]).isEnPassant() && Math.abs(To_Position_Y - From_Position_Y) == 1 && To_Position_X - From_Position_X == 1) {
//                return true;
//            }
//
//            // Move Rule
//            if ((From_Position_X == 1 && To_Position_X - From_Position_X == 2 || To_Position_X == From_Position_X + 1) && To_Position_Y - From_Position_Y == 0 && DoubleSquare(board, myPiece, From_Position_X + 1, From_Position_Y, To_Position_X)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    boolean DoubleSquare(Piece[][] board, Piece myPiece, int From_Position_X, int From_Position_Y, int To_Position_X) {
//        if (board[From_Position_X][From_Position_Y] != null) return false;
//        if (From_Position_X == To_Position_X) return true;
//        return DoubleSquare(board, myPiece, myPiece.getTeamColor() == Color.WHITE ? From_Position_X - 1 : From_Position_X + 1, From_Position_Y, To_Position_X);
//    }
//
//    private void PawnPromotion() {
//
//    }
//
//}


