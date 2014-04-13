package com.sadafnoor.game.grasshooper.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sadafnoor.game.grasshooper.controllers.World;
import com.sadafnoor.game.grasshooper.controllers.WorldInputController;

/*
 * This is the class where the actual game begins
 * It sets its input controller to WorldController when it shows()  
 */
public class GameScreen implements Screen{
	World world=new World();//everything is a part of world class so to access everything we need it
	WorldInputController inputcontroller = new WorldInputController(world);
	Renderer renderer=new Renderer(world);//Everything renders in gamescreen so to render everything we would need it
	private SpriteBatch batch;
	private OrthographicCamera camera;
	
	public GameScreen(){
		camera = new OrthographicCamera(10, 7);
		camera.position .set(5, 3.5f, 0);
		camera.update();

		batch=new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
		
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



if (!renderer.collisionDetected())
{	
	System.out.println(Gdx.input.getY());
	System.out.println("Plant: ( "+world.getPlants()[1].getX()+", "+world.getPlants()[1].getY());
	System.out.println("Grasshooper: ("+world.getGrassHooper().getX()+", "+world.getGrassHooper().getY()+")");
	
	world.getGrassHooper().update(delta);
}else{
	System.out.println("collision detected"); 
}
		batch.begin();
		renderer.renderPlants(batch);
		renderer.renderGrassHooper(batch);
	
		
		//renderer.renderDebugLine(batch);
		//renderer.renderBackground();		
		
		
		batch.end();
	}

	

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		Gdx. input .setInputProcessor(inputcontroller);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
