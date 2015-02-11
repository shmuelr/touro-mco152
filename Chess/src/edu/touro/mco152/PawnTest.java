package edu.touro.mco152;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.touro.mco152.ChessPiece.PieceColor;

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
		Pawn p= new Pawn();
		assertEquals(PieceColor.WHITE,p.getColor());
	}
	
	@Test
	public void testBlackConstruct() {
		Pawn blackPawn = new Pawn(PieceColor.BLACK);
		assertEquals(PieceColor.BLACK, blackPawn.getColor());
	}

}
