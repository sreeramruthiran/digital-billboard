package com.threecdc.billboard.manager;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.threecdc.billboard.dto.Billboard;

public class BillboardManagerTest {

	@Test
	public void testAddBillboard() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveBillboard() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBillboard() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteBillboard() {
		fail("Not yet implemented");
	}

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
	public void testGetAllBillboards() {
		BillboardManager bm = new BillboardManager();
		List<Billboard> lbillboard = bm.getAllBillboards();
		assertTrue("List not empty", lbillboard.size()>0);
	}

}
