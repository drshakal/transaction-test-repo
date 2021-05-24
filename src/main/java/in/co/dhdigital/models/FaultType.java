package in.co.dhdigital.models;

public class FaultType {

	protected String type;
	protected int number;
	protected String description;
	protected String retryAfter;
	protected String system;
	protected String nativeError;
	protected String nativeDescription;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRetryAfter() {
		return retryAfter;
	}

	public void setRetryAfter(String retryAfter) {
		this.retryAfter = retryAfter;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getNativeError() {
		return nativeError;
	}

	public void setNativeError(String nativeError) {
		this.nativeError = nativeError;
	}

	public String getNativeDescription() {
		return nativeDescription;
	}

	public void setNativeDescription(String nativeDescription) {
		this.nativeDescription = nativeDescription;
	}

}
