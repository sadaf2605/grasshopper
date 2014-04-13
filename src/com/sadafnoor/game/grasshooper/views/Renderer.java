package com.sadafnoor.game.grasshooper.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sadafnoor.game.grasshooper.controllers.World;
import com.sadafnoor.game.grasshooper.models.GrassHooper;
import com.sadafnoor.game.grasshooper.models.Plant;
import com.sadafnoor.game.grasshooper.projectile.ProjectileActor;
import com.sadafnoor.game.honeybee.honeybee.Controller;

/*
 * This class is being accessed via GameScreen
 */

public class Renderer {
	World world; //all the elements/models are being accessed via world
	
	
	ShapeRenderer debugRenderer = new ShapeRenderer();




	private Texture ghoopertexture;




	private Texture redPlantTexture;


	private GrassHooper grassHooper;


	private Stage stage;
	
	/*
	 * We have only one world to live in, so we create one and pass it to others
	 */
	public Renderer(World _world){
		world=_world; 
		grassHooper=world.getGrassHooper();
		ghoopertexture = new Texture(Gdx.files.internal("data/ghooper.gif"));
		ghoopertexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		redPlantTexture = new Texture(Gdx.files.internal("data/plant1.gif"));
		redPlantTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		
		
	}
	
    private int width;
    private int height;
    private float ppuX;     // pixels per unit on the X axis
    private float ppuY;     // pixels per unit on the Y axis
    private static final float CAMERA_WIDTH = 10f;
    private static final float CAMERA_HEIGHT = 7f;
    
	public void setSize (int w, int h) {
        this.width = w;
        this.height = h;
        ppuX =2560f/10f; //(float)width / CAMERA_WIDTH;
        ppuY = 1600f/7f;//(float)height / CAMERA_HEIGHT;
   }
	
	public void renderBackground() {
		// TODO add background image
	}
	
	/*
	 * It would access all the plants via world and render them accordingly
	 */
	public void renderGrassHooper(SpriteBatch batch) {

		batch.draw(ghoopertexture, grassHooper.getX()*10f/Gdx.graphics.getWidth(), (grassHooper.getY())*7f/Gdx.graphics.getHeight(), grassHooper.getWidth()*10f/Gdx.graphics.getWidth(),grassHooper.getHeight()*7f/Gdx.graphics.getHeight());
		
	}
	
	public void renderPlants(SpriteBatch batch){
		Plant[]plants=world.getPlants();
		Texture colorPlantTexture;
		for(Plant p:plants){
			switch(p.getColor()){
				case RED: colorPlantTexture=redPlantTexture; break;
				default: colorPlantTexture=null;
			}	
			batch.draw(colorPlantTexture, 
							p.getX()*10f/Gdx.graphics.getWidth(), 
							p.getY()*7f/Gdx.graphics.getHeight()*7f/Gdx.graphics.getHeight(), 
							p.getWidth()*10f/Gdx.graphics.getWidth() ,
							p.getHeight()*7f/Gdx.graphics.getHeight()
					);
		}
		
	}

	 public void render() {
		  
		}

	public void renderDebugLine(SpriteBatch batch) {
		
		ShapeRenderer shapeRenderer = new ShapeRenderer();
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(255, 0, 0, 1);
		shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
		shapeRenderer.line(grassHooper.getX()*10f/Gdx.graphics.getWidth(), grassHooper.getY(),Gdx.input.getX()*10f/Gdx.graphics.getWidth(), (Gdx.graphics.getHeight()-Gdx.input.getY())*7f/Gdx.graphics.getHeight());
		shapeRenderer.end();
		
	}

	public boolean collisionDetected() {
		return ((world.getGrassHooper().getY()<=180f && world.getGrassHooper().getY()>=120f) && (world.getGrassHooper().getX() > world.getPlants()[1].getX() && world.getGrassHooper().getX() < world.getPlants()[1].getX()+ world.getPlants()[1].getWidth()));
	}
	
}
