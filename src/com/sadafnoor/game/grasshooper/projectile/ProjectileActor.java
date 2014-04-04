package com.sadafnoor.game.grasshooper.projectile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ProjectileActor extends Actor{
	
	Texture texture;
	ProjectileEquation projectileEquation;
	/*
	 * 
	 */
	public ProjectileActor(Texture texture,float actorX,float actorY){
		this.texture=texture;
		
		projectileEquation=new ProjectileEquation();
        setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
	}
	
	float vx,vy,rotation;
	/*
	 * It sets the initial velocity of the projectile
	 */
	public void setVelocity(float velocity,float rotation){
		vx=(float) (velocity * Math.cos(rotation));
		vy=(float) (velocity * Math.sin(rotation));
	}
	
	
	
	
    private float timeSeparation =1f;  
    void setTimeSeparation(float t){
    	timeSeparation=t;
    }
    
    private float trajectoryPointCount=1000;
    void setTrajectoryPointCount(int c){
    	trajectoryPointCount=c;
    }
	/*
	 * By default it draws the projectile for every second but you can improve the projectile 
	 * drawing by minimizing the setTimeSeparation(...) and it counts for limited number of 
	 * points, by default it is 1000 but can be increased using setProjectilePointCount(...).
	 * 
	 * @see com.badlogic.gdx.scenes.scene2d.Actor#draw(com.badlogic.gdx.graphics.g2d.Batch, float)
	 */
    @Override
    public void draw(Batch batch, float alpha){
    	float t = 1f;
    	
        for (int i = 0; i < trajectoryPointCount; i++) {  
            
            float x = this.getX() + projectileEquation.getX(t);  
            float y = -this.getY() + projectileEquation.getY(t);  
           
            batch.setColor(this.getColor());  
            batch.draw(texture, x, y,Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10); //width, height); 
          
            
            t += timeSeparation;  
        }
    }
	
  @Override
  public void act(float delta){

      	super.act(delta);  
      	projectileEquation.startVelocity.set(vx,vy);  
        projectileEquation.startPoint.set(this.getX(),this.getY()); 

  }
  
  

}
