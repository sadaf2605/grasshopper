package com.sadafnoor.game.grasshooper.controllers;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

/*
 * It updates the screen characters when screen is being rendered from GameScreen.
 * 
 * Input controller is set to this class from GameScreen()
 */
public class WorldInputController implements InputProcessor{

	private World world;
/*
 * It takes world as argument, one singleton class of world is being passed through it.
 */
	public WorldInputController(World _world) {
		world=_world;
	}
	

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
//		System.out.print(screenX+" "+screenY);
//		world.getGrassHooper().setX(screenX);
//		world.getGrassHooper().setY(screenY);
		
		world.getGrassHooper().setVelocityAndFire(1f,1f);
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}

















