package com.sadafnoor.game.grasshooper.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.sadafnoor.game.grasshooper.projectile.ProjectileEquation;

/*
 * This is a singleton model class where the basic property of things will be kept, 
 * like  texture, position, current score.  
 * 
 */
public class GrassHooper {
	Texture grasshooperTexture=new Texture(Gdx.files.internal("data/ghooper.gif"));
	 
	Vector2  position = new Vector2();
	Vector2  velocity = new Vector2();
	Rectangle  bounds = new Rectangle();
	
	/*
	 *Constructor takes the position vector2 as a parameter 
	 */
	public GrassHooper(Vector2 position, Vector2 size){
		this.position = position;
		bounds.width=size.x;
		bounds.height=size.y; 
		ghProj =new ProjectileEquation(velocity,position);
	}
	
	/*
	 * returns the positon of grasshooper on x axis
	 */
	public float getX(){
		return position.x;
	}
	/*
	 * returns the positon of grasshooper on y axis
	 */
	public float getY(){
		return position.y;
	}
	/*
	 * returns the height of grasshooper calculated on y axis
	 */
	public float getHeight(){
		return bounds.height;
	}
	/*
	 * returns the width of grasshooper calculated on x axis
	 */
	public float getWidth(){
		return bounds.width;
	}
	
	/*
	 * set x ordinate
	 */
	public void setX(float x){
		position.x=x;
	}

	public void setY(float y) {
		position.y=y;
		
	}

	ProjectileEquation ghProj;
	public void setVelocityAndFire(float Fx,float Fy){
		velocity.x=Fx;
		velocity.y=Fy;
		ghProj =new ProjectileEquation(velocity,position);
	}
	
	float t=0;
	
	public void update(float delta) {
		
		if(velocity.x !=0 || velocity.y !=0){
			t+=delta;
		}
		setX(ghProj.getX(t));
		setY(ghProj.getY(t));
		
	}

	

}
