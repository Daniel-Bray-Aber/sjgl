package com.SJGL.Engine;

import org.lwjgl.opengl.*;

import com.SJGL.debug.Logger;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.opengl.GL11.*;

public class sWindow {
	
	// Window Information
	private int width, height;
	private String title;
	
	//Window Handle
	private long window;
	
	// Creates the window object. Please call init() after.
	public sWindow(int width, int height, String title)
	{
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	// Creates window. If it is successful it returns true;
	// otherwise it returns false;
	public boolean init()
	{
		if(!glfwInit())
		{
			Logger.getLogger().logError("Failed to inilise glfw");
			return false;
		}

		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
		
		window = glfwCreateWindow(width, height, title, NULL, NULL);
		if(window == NULL)
		{
			Logger.getLogger().logError("Failed to create window");
			return false;
		}
		
		//Make sure GL is ready for use.		
		glfwMakeContextCurrent(window);
		// No v-sync.
		glfwSwapInterval(0);
		GL.createCapabilities();
		glClearColor(0.3f, 0.3f, 0.3f, 1.0f);
		
		return true;
	}
	
	public void clear()
	{
		glClear(GL_DEPTH_BUFFER_BIT | GL_COLOR_BUFFER_BIT);
	}
	
	public void pollEvents()
	{
		glfwPollEvents();
	}
	
	public void swapBuffers()
	{
		glfwSwapBuffers(window);
	}
	
	public boolean shouldClose()
	{
		return glfwWindowShouldClose(window);
	}
	
	public void show()
	{
		System.out.println(GL33.glGetString(GL33.GL_VERSION));
		glfwShowWindow(window);
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void destoy()
	{
		glfwTerminate();
	}
	
	public void test()
	{
		System.out.println("TEst");
	}

}
