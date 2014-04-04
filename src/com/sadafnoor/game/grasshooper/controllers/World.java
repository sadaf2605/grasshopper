package com.sadafnoor.game.grasshooper.controllers;

import com.badlogic.gdx.math.Vector2;
import com.sadafnoor.game.grasshooper.models.*;

/*
 * This class is dedicated to maintain singleton grasshooper class and many plants accessible.
 */
public class World {
	GrassHooper grasshooper=new GrassHooper(new Vector2(70f,100f), new Vector2(1f,1f));
	
	Plant redPlant1=new Plant(new Vector2(1f,0f), new Vector2(2f,5f), Plant.PlantColor.RED);
	Plant redPlant2=new Plant(new Vector2(3f,0f), new Vector2(2f,5f), Plant.PlantColor.RED);
	
	
	/*
	 * returns grasshooper
	 */
	public GrassHooper getGrassHooper(){
		return grasshooper;
	}
	
	/*
	 * returns an array of plants
	 */
	public Plant[] getPlants(){
		Plant [] plants =new Plant[]{redPlant1,redPlant2};
		return plants;
	}
	
}
