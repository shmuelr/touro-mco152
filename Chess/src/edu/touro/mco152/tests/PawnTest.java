package edu.touro.mco152.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.touro.mco152.pieces.ChessPiece;

import edu.touro.mco152.pieces.ChessPiece.PieceColor;

public class PawnTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		ChessPiece p = ChessPiece.getWhitePawn();
		assertEquals(PieceColor.WHITE,p.getColor());
	}
	
	@Test
	public void testBlackConstruct() {
		ChessPiece p = ChessPiece.getBlackPawn();
		assertEquals(PieceColor.BLACK, p.getColor());
	}
	



}
