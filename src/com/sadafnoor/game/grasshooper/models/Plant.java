package com.sadafnoor.game.grasshooper.models;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/*
 * This is a model class where the basic property of things will be kept, 
 * like  all the texture of different type of plants, patels and the position of all the patels,
 * bud strength and so on.
 */

public class Plant {
	public enum PlantColor{RED}
	
	PlantColor color;
	Vector2 rootPosition;
	Rectangle bounds=new Rectangle();
	public Plant(Vector2 root_position, Vector2 size,PlantColor _color){
		rootPosition=root_position;
		bounds.width=size.x;
		bounds.height=size.y;
		color=_color;
	}
	
	public PlantColor getColor(){
		return color;
	}
	/*
	 * returns root position of the plant on x axis
	 */
	public float getX(){
		return rootPosition.x;
	}
	/*
	 * returns root position of the plant on y axis
	 */
	public float getY(){
		return rootPosition.y;
	}
	
	/*
	 * returns the height of the plant on y axis
	 */
	public float getHeight(){
		return bounds.height;
	}
	
	/*
	 * returns the height of the plant on y axis
	 */
	public float getWidth(){
		return bounds.width;
	}
}
