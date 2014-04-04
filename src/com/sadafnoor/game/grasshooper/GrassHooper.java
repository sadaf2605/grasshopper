package com.sadafnoor.game.grasshooper;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.sadafnoor.game.grasshooper.projectile.ProjectileActor;

public class GrassHooper implements ApplicationListener {
    private Stage stage;
    
    @Override
    public void create() {        
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        Texture texture = new Texture(Gdx.files.internal("data/ghooper.gif"));
        
        
        ProjectileActor myActor = new ProjectileActor(texture,0,0);
        myActor.setVelocity(70f, 45f);
        
        myActor.setTouchable(Touchable.enabled);
        stage.addActor(myActor);
    }

    @Override
    public void dispose() {
    }

    @Override
public void render() {    
 //   Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    stage.act(Gdx.graphics.getDeltaTime());
    stage.draw();
}

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