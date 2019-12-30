package com.SJGL.Engine;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL33;

public class Model {
	
	private int VBO;
	private int VAO;
	
	float vertices[] =
		{
				-0.5f, -0.5f, 0.0f,
				0.0f, 0.5f, 0.0f,
				0.5f, -0.5f, 0.0f,
		};
	
	public Model()
	{ 
		VAO = GL33.glGenVertexArrays();
		GL33.glBindVertexArray(VAO);		
		
		VBO = GL33.glGenBuffers();
		GL33.glBindBuffer(GL33.GL_ARRAY_BUFFER, VBO);
		FloatBuffer buff = BufferUtils.createFloatBuffer(vertices.length);
		for (int i = 0; i < vertices.length; i++) 
		{
			buff.put(vertices[i]);
		}
		buff.rewind();
		GL33.glBufferData(GL33.GL_ARRAY_BUFFER, buff, GL33.GL_STATIC_DRAW);
		GL33.glVertexAttribPointer(0, 3, GL33.GL_FLOAT, false, 3 * 4, 0l);
		GL33.glEnableVertexAttribArray(0);
		
		GL33.glBindVertexArray(0);
	}
	
	public void Render()
	{
		GL33.glBindVertexArray(VAO);
		GL33.glDrawArrays(GL33.GL_TRIANGLES, 0, 3);
	}
}
