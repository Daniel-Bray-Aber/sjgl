package com.SJGL.Engine;

import org.lwjgl.opengl.GL33;

import com.SJGL.debug.Logger;

public class Shader {
	
	private int shaderProgram;
	
	private String vertShader 
	= "#version 330\n layout(location=0) in vec3 aPos;\nvoid main()\n{\ngl_Position = vec4(aPos.x, aPos.y, aPos.z, 1.0f);\n}";

	private String fragShader
	= "#version 330\n out vec4 FragColor;\nvoid main()\n{\nFragColor=vec4(1.0f, 0.5f, 0.2f, 1.0f);\n}";
	
	
	public Shader()
	{
		int frag = GL33.glCreateShader(GL33.GL_FRAGMENT_SHADER);
		GL33.glShaderSource(frag, fragShader);
		GL33.glCompileShader(frag);
		int vert = GL33.glCreateShader(GL33.GL_VERTEX_SHADER);
		GL33.glShaderSource(vert, vertShader);
		GL33.glCompileShader(vert);
		shaderProgram = GL33.glCreateProgram();
		GL33.glAttachShader(shaderProgram, vert);
		GL33.glAttachShader(shaderProgram, frag);
		GL33.glLinkProgram(shaderProgram);
		int linkStatus = GL33.glGetProgrami(shaderProgram, GL33.GL_LINK_STATUS);
		if(linkStatus != GL33.GL_TRUE)
		{
			String error = GL33.glGetProgramInfoLog(shaderProgram);
			Logger.getLogger().logError(error);
		}
	}
	
	public void Use()
	{
		GL33.glUseProgram(shaderProgram);
	}
	
}
