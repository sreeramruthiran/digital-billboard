package com.threecdc.billboard.manager;

import static org.junit.Assert.*;
import org.junit.Test;
import com.threecdc.billboard.dto.TickerText;

public class TickerTextManagerTest {

	@Test
	public void testAddTicker() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveTicker() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTicker() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteTicker() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNextTicker() {
		
		TickerTextManager tm = new TickerTextManager();
		TickerText tt = tm.getNextTicker();
		assertTrue("Ticker Found", tt.getId()>0);
	}

}
