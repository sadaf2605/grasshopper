package com.sadafnoor.game.honeybee;

import java.util.LinkedList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sadafnoor.game.grasshooper.projectile.ProjectileActor;

public class GScreen implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture1;
	private Texture texture2;
	private Texture texture3;
	private Sprite sprite;
	Stage stage;
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture1 = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture1.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		//texture2 = new Texture(Gdx.files.internal("data/flower1.gif"));
		//texture2.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		texture3 = new Texture(Gdx.files.internal("data/ghooper.gif"));
		texture3.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		//TextureRegion region1 = new TextureRegion(texture1, 0, 0, 512, 275);
		
		//TextureRegion region2 = new TextureRegion(texture2, 0, 0, 2560, 1600);
		TextureRegion region3 = new TextureRegion(texture3, 0, 0, 2560, 1600);
		
		

		//sprite = new Sprite(region1);
		//sprite = new Sprite(region2);
		sprite = new Sprite(region3);
		
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		//sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
		stage = new Stage(sprite.getWidth(),sprite.getHeight(),true);
		
		ProjectileActor t=new ProjectileActor(texture3,12f,1f);
        t.setVelocity(10f, 10f);
		stage.addActor(t);
        
        
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture1.dispose();
	}
	int rot=0;
	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		



		ShapeRenderer shapeRenderer =new ShapeRenderer();
		shapeRenderer.begin(ShapeType.Line);
		 shapeRenderer.setColor(255, 0, 0, 1);
		
//		 shapeRenderer.rect(x, y, width, height);
//		 shapeRenderer.circle(x, y, radius);
		 
		batch.end();
		
		if (Gdx.input.isTouched()){
					
			shapeRenderer.line(0, 0,Gdx.input.getX(), 323-Gdx.input.getY());
			
		    stage.act(Gdx.graphics.getDeltaTime());
		    stage.draw();
		    
		}else{

		}
		shapeRenderer.end();
		
		
		/*	if(Gdx.input.getX()>46 && Gdx.input.getX()<111){
				if(Gdx.input.getY()>124 && Gdx.input.getY()<174){
					System.out.println(Gdx.input.getY());
					sprite.rotate(1);
					rot+=1;
				}
			}*/
		}
		
		
		//sprite.rotate(60);
		
	

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
	
	
	
	