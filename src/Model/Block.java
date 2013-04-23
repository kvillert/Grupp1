package model;

public class Block {
	private float posX;
	private float posY;
	private float width;
	private float height;

	
	public Block(final float posX, final float posY, final float width, final float height) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
	}


	public float getPosX() {
		return posX;
	}


	public float getPosY() {
		return posY;
	}


	public float getWidth() {
		return width;
	}


	public float getHeight() {
		return height;
	}

}
