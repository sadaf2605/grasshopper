package com.sadafnoor.game.grasshooper.projectile;

import com.badlogic.gdx.math.Vector2;

public class ProjectileEquation {
	public ProjectileEquation(Vector2 velocity,Vector2 point){
		System.out.println(velocity.y);
		startVelocity=velocity;
		startPoint=point;
	}
    public float gravity=-9.8f;  
    public Vector2 startVelocity;  
    public Vector2 startPoint;  
  
    public float getX(float t) {
    	//System.out.println(startVelocity.x);
        return startVelocity.x * t + startPoint.x;  
    }
  
    public float getY(float t) {  
        return 0.5f * gravity * t * t + startVelocity.y * t + startPoint.y;  
    }  
  
}