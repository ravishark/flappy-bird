package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture[] birds;
	int flapState=0;
	int birdY=0;
	int velocity=0;
	int gameState=0;
	float gravity=1.5f;
	Texture[] tubes;
	float gap=600f;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        background=new Texture("bg.png");
        birds=new Texture[2];
        birds[0]=new Texture("bird.png");
        birds[1]=new Texture("bird2.png");
        birdY=Gdx.graphics.getHeight()/2-birds[0].getHeight()/2;
        tubes=new Texture[2];
        tubes[0]=new Texture("bottomtube.png");
        tubes[1]=new Texture("toptube.png");
	}

	@Override
	public void render () {

		batch.begin();
		batch.draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		if(gameState!=0){
			batch.draw(tubes[0],Gdx.graphics.getWidth()/2-tubes[0].getWidth()/2,Gdx.graphics.getHeight()/2-gap-tubes[0].getHeight()/2);
			batch.draw(tubes[1],Gdx.graphics.getWidth()/2-tubes[1].getWidth()/2,Gdx.graphics.getHeight()/2+gap/2);
			if(Gdx.input.justTouched()) {

				velocity=-30;
			}
			if (birdY>0||velocity<0){
			velocity+=gravity;
			birdY-=velocity;}
		}else{
			if(Gdx.input.justTouched()) {
				gameState=1;
			}
		}
		if (flapState == 0) {
			flapState = 1;
		} else {
			flapState = 0;
		}

        batch.draw(birds[flapState],Gdx.graphics.getWidth()/2-birds[flapState].getWidth()/2,birdY);
		batch.end();
	}

}
