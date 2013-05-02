
public class tablet extends base {
	float screenSize;
	String oem;
	String os;
public tablet(float screenSize,String oem, String os){
	this.screenSize=screenSize;
	this.oem=oem;
	this.os=os;
}
public float getScreenSize() {
	return screenSize;
}
public String getOem() {
	return oem;
}
public String getOs() {
	return os;
}

}

