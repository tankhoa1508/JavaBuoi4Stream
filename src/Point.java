public class Point {
    private int x;
    private int y;

    // Constructor
    public Point(int x, int y){
        this.x =x;
        this.y = y;
    }

    public Point(){

    }

    public Point(Point b){
        this.x= b.x;
        this.y= b.y;
    }

    //Getter cho tọa độ x
    public int getX() {
        return x;
    }

    //Getter cho tọa độ y
    public int getY() {
        return y;
    }

    //Override phương thức toString để dễ dàng in đối tượng
    @Override
    public String toString(){
        return "("+ x +","+ y +")";
    }
}
