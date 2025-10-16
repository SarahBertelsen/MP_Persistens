package model;

public class MusicProduct extends Product {
	String format;
	String artist;
	
	public MusicProduct(int productId, String name, String productType, double salePrice, String format, String artist) {
		super(productId, name, productType, salePrice);
		this.format = format;
		this.artist = artist;
	}
	
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
}
