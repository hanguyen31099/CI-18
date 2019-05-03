public class Vector2D {
    public double x;
    public double y;

    public Vector2D(){
        this(0,0);
    }
    public Vector2D(double x,double y){
        this.x = x;
        this.y = y;
    }
    public void add(double x,double y){
        this.x += x;
        this.y += y;
    }
    public void subtract(double x,double y){
        this.x -= x;
        this.y -= y;
    }
    public void scale(double rate){
        this.x *=rate;
        this.y *=rate;
    }
    public void set(double x,double y){
        this.x = x;
        this.y = y;
    }
    public Vector2D clone() {
        return new Vector2D(this.x,this.y);
    }
    public double getlength(){
        return (Math.sqrt(x*x+y*y));
    }
    public void setLength(double length){
        double oldlength = this.getlength();
        if(oldlength!=0){
            this.x = this.x * length / oldlength;
            this.y = this.y * length / oldlength;
        }
    }
    public double getAngle(){
        return Math.atan(y/x);
    }
    public void setAngle(double angle){
        double length = this.getlength();
        if(length!=0){
            this.x = length * Math.cos(angle);
            this.y = length * Math.sin(angle);
        }
    }

}
