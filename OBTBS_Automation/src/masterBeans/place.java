package masterBeans;

public class place {
	String placeCode,placeName,placeType,state,district,pickup;

	public place(String placeCode, String placeName, String placeType, String state, String district, String pickup) {
		super();
		this.placeCode = placeCode;
		this.placeName = placeName;
		this.placeType = placeType;
		this.state = state;
		this.district = district;
		this.pickup = pickup;
	}

	public String getPlaceCode() {
		return placeCode;
	}

	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	
}
