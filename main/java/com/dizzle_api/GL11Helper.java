package com.dizzle_api;

import org.lwjgl.opengl.GL11;

public class GL11Helper {

	public static void scale(float scale) {
		GL11.glScalef(scale, scale, scale);
	}
}
