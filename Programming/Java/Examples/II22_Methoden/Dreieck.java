public class Dreieck {
  double x, y, z;
  static void setze (Dreieck d, double x, double y, double z){
        d.x = x; d.y = y; d.z = z;
    }
  
  double flaeche (){
      double p = (x*x - y*y + z*z)/(2*x);
      double y = Math.sqrt(z*z - p*p);
      return x*y/2;
  }
  
  public String toString() {
      return "x: " + x +
             ", y: " + y +
             ", z: " + z +
             ", Flaeche: " + flaeche();
  }
}
