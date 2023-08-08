package com.met.cdac.model;

import jakarta.persistence.*;






@Entity //Simple POJO Class
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; //Primary key
    private String carName;
   
	public Car(long id, String carName, String carModel, String carColor, int carPrice) {
		super();
		this.id = id;
		this.carName = carName;
		this.carModel = carModel;
		this.carColor = carColor;
		this.carPrice = carPrice;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	private String carModel;
    private String carColor;
    private int carPrice;
   
    //Getters and Setters
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * @return the carName
     */
    public String getCarName() {
        return carName;
    }
    /**
     * @param carName the carName to set
     */
    public void setCarName(String carName) {
        this.carName = carName;
    }
    /**
     * @return the carModel
     */
    public String getCarModel() {
        return carModel;
    }
    /**
     * @param carModel the carModel to set
     */
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    /**
     * @return the carColor
     */
    public String getCarColor() {
        return carColor;
    }
    /**
     * @param carColor the carColor to set
     */
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
	@Override
	public String toString() {
		return "Car [id=" + id + ", carName=" + carName + ", carModel=" + carModel + ", carColor=" + carColor + "]";
	}
	public Car() {
		super();
	}
    

}
