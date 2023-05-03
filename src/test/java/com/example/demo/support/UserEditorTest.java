package com.example.demo.support;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserEditorTest {

	@Test
	void testGetAsText() {
		UserEditor editor = new UserEditor();
		editor.setAsText("test");
		assertEquals("test", editor.getAsText());
	}

}
