package application;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMath;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ChessMath chessMath = new ChessMath();
		List<ChessPiece> captured = new ArrayList<>();
		

		while (!chessMath.getCheckMate()) {
			try {
				UI.clearScreen();                  // chamando função para limpar tela do 'gitBash'
				UI.printMatch(chessMath, captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean [][] possibleMoves = chessMath.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMath.getPieces(), possibleMoves);
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);

				ChessPiece capturedPiece = chessMath.performChessMove(source, target);
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
				if(chessMath.getPromoted() != null) {
					System.out.print("Enter piece for promotion (B/N/R/Q): ");
					String type = sc.nextLine().toUpperCase();
					while(!type.equals("B") && !type.equals("N") && !type.equals("R")  && !type.equals("Q")) {
						System.out.print("Invalid value. Enter piece for promotion (B/N/R/Q): ");
						type = sc.nextLine().toUpperCase();
					}
					chessMath.replacePromotedPiece(type);
				}
		} 
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} 
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}//final do while
		UI.clearScreen();
		UI.printMatch(chessMath, captured);
	}
}
