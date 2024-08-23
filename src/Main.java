import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        ArrayList<String> colors = new ArrayList<>();
//        colors.add("Red");
//        colors.add("Green");
//        colors.add("Blue");
//
//        // Truy cập phần tử tại vị trí chỉ định
//        System.out.println(colors.get(1));
//
//        //Thay đổi phần tử tại vị trí chỉ định
//        colors.set(1, "Yellow");
//
//        // Xóa phần tử theo giá trị
//        colors.remove("Red");
//        System.out.println(colors);
//
//        //Xóa phần tử theo chỉ số
//        colors.remove(1);
//        System.out.println(colors);
//
//        for (String color : colors) {
//            System.out.println(color);
//        }
//
//        //Tạo một mảng
//        String[] colorsArray = {"Red", "Green", "Blue"};
//
//        //Tạo ArryList tử mảng
//        ArrayList<String> colorsList = new ArrayList<>(Arrays.asList(colorsArray));
//
//        //Sắp xếp mảng: cách thường
//        Collections.sort(colorsList);
//
//        //Sử dụng biểu thức lambda để sắp xếp danh sách theo thứ tự tăng dần
//        Collections.sort(colorsList, (s1, s2) -> s1.compareTo(s2));
//        System.out.println(colorsList); // output: [Red, Green, Blue]
//
//        ArrayList<Point> points = new ArrayList<>();
//        points.add(new Point(3,7));
//        points.add(new Point(3,6));
//        points.add(new Point(5,2));
//        Comparator<Point> x_y_compare = new Comparator<Point>(){
//            @Override
//            public int compare(Point o1, Point o2) {
//                return Integer.compare(o1.getX(), o2.getX());
//            }
//
////            public int compare(Point p1, Point p2) {
////                int tmp= Integer.compare(p1.getX(), p2.getX());
////                if(tmp==0) {
////                    return Integer.compare(p1.getY(), p2.getY());
////                }
////                return tmp;
////            }
////
////            public int compare(Point p1, Point p2){
////                return Integer.compare(p1.getX()+p1.getY(), p2.getX()+p2.getY());
////            }
//        };
//        Collections.sort(points, x_y_compare);
//        for (Point p: points) {
//            System.out.println(p);
//        }


//        System.out.println("LAMBDA");
//        System.out.println("####################");
//        ArrayList<Point> points= new ArrayList<>();
//        points.add(new Point(3,5));
//        points.add(new Point(2,6));
//        points.add(new Point(5,2));
//        points.add(new Point(6,0));
//
//        System.out.println("#############");
//        Predicate<Point> SumPoint= point -> point.getX() + point.getY() > 7;
//        Predicate<Point> SumPoint2 = point -> {
//            if (point.getX() > 5) {
//                return point.getX() + point.getY() > 7;
//            } else {
//                return point.getX() + point.getY() > 6;
//            }
//        };
//        for (Point point : points) {
//            if (SumPoint2.test(point)) {
//                System.out.println(point.toString());
//            }
//        }
//        Function<Point, Integer> sumPoint3 = p -> p.getY() + p.getX();
//        Function<Point, Integer> sumPoint4 = p -> {
//            return p.getX() > p.getY() ? p.getY() - p.getX() : p.getY() + p.getX();
//        };
//        for (Point point: points){
//            System.out.println(sumPoint4.apply(point));
//        }
//        Consumer<Point> printMessage = p -> {
//            if (p.getX() > p.getY()) {
//                System.out.println(p.getY() - p.getX());
//            }
//        };
//
//        System.out.println("##############");
//        points.forEach(printMessage);
//        System.out.println("################");
//        for (Point point:points) {
//            printMessage.accept(point);
//        }
//
//        System.out.println("##############");
//        points.stream()
//                .filter(p -> p.getX() >3)
//                .forEach(System.out::println);
//        System.out.println("###############");
//        for (Point a:points) {
//            if (a.getX()>3){
//                System.out.println(a.toString());
//            }
//        }
//
//        System.out.println("###############");
//        Consumer<Point> consum_x = p -> {
//            if (p.getX() >3) {
//                System.out.println(p.toString());
//            }
//        };
//        points.forEach(consum_x);


        System.out.println("#############################################################");
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Anna");

//      // Lọc các tên bắt đầu bằng 'A'
        names.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println); //output Alice, Anna

        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());


        System.out.println(filteredNames); //Output: [ALICE, ANNA]

        //Ánh xạ các tên thành chữ hoa
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println); // Output: JOHN, ALICE, BOB

        names.stream()
                .sorted()
                .forEach(System.out::println); //Output: Alice, Bob, John

        //Sắp xếp thep thứ tự giảm dần
        names.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println); //Output: John, Bob, Alice

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        //Tính tổng
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum: "+sum); //output Sum: 15


        //stream<Interger> => int
        // Tính trung bình
        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        System.out.println("Average: "+average); //output: Average: 3.0

        // Tìm giá trị lớn nhất
        OptionalInt max = numbers.stream()
                .mapToInt(Integer::intValue)
                .max();
        System.out.println("max: "+ (max.isPresent() ? max.getAsInt() : "Not present"));  // Output: Max: 5

        // Tìm giá trị nhỏ nhất
        OptionalInt min = numbers.stream()
                .mapToInt(Integer::intValue)
                .min();
        System.out.println("Min: "+ (min.isPresent() ? min.getAsInt() : "Not present"));  // Output: Min: 1

        // Sử dụng reduce để tính tổng
        int sum1 = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum using reduce: "+ sum1); //Output: Sum using reduce: 15

        // Sử dụng reduce để tìm tích
        int product = numbers.stream()
                .reduce(1, (kq, item) -> kq=kq*item);
        System.out.println("Product using reduce: "+ product); //Output: Product using reduce: 120


        //Bài tập: tính tổng total1 = 1+ 1/2 + 1/3 + 1/4 + 1/5
        double total1 = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .reduce(0, (kq, item) -> kq+1/item);
        System.out.println("Total1 using reduce: "+ total1);



        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e", "f"),
                Arrays.asList("g", "h", "i")
        );

        // Sử dụng flatMap để kết hợp các danh sách con thành một danh sách
        List<String> combinedList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(combinedList); //Output: [a, b, c, d, e, f, g, h, i]





        List<Point> points= new ArrayList<>();
        points.add(new Point(7,2));
        points.add(new Point(3,4));
        points.add(new Point(2,6));
        points.add(new Point(7,1));

        // tổng tất cả x, y
        int totalSum= points.stream()
                .flatMapToInt(point -> Arrays.stream(new int[]{point.getX(), point.getY()}))
                .sum();

        // cach 2
        int totalSum2 = points.stream()
                .mapToInt(point -> {
                    return point.getX()+point.getY();
                })
                .sum();
        System.out.println("totalSum2: "+totalSum2);

        // Tính tổng các hoành độ
        int sumX = points.stream()
                .mapToInt(Point::getX) //Chuyển đổi thành Instream dựa trên giá trị x
                .sum(); // Tính tổng

        // Tính tổng các hoành độ >5
        int sumX2 = points.stream()
                .filter(p -> p.getX()>5)
                .mapToInt(Point::getX) // Chuyển đổi thành IntStream dựa trên giá trị x
                .sum();

        // Tính tổng toàn bộ x^2 +1 -y đôi với các hoành độ >5
        int sumX3 = points.stream()
                .filter(p->p.getX()>5)
                .mapToInt(p->{
                    return p.getX()*p.getX()+1-p.getY();
                }) // Chuyển đổi thaành IntStream dựa trên giá trị x
                .sum();
        // In ra từng kết quả x^2 +1 -y đối với x>4
        points.stream()
                .filter(p->p.getX()>4)
                .mapToInt(p->{
                    return p.getX()*p.getX()+1-p.getY();
                }) // Chuyển đổi thaành IntStream dựa trên giá trị x
                .forEach(res -> System.out.println(res));
        //kq 48, kq 49

        // Tính tích toàn bộ x^2+1 -y đôi với các hoành độ >1
        long total5 = points.stream()
                .filter(p->p.getX()>1)
                .mapToLong(p->{
                    return p.getX()*p.getX()+1-p.getY();
                })
                .reduce(1L,(kq,item)->kq*item);
        System.out.println("toltal5: "+total5);

        //Tính tích  các giá trị của 1/(x^2 + y) cho tất cả các Point
        double totalProduct = points.stream()
                .mapToDouble(point -> {
                    int x = point.getX();
                    int y = point.getY();
                    double tmp = x*x + y;
                    return 1.0 / tmp;
                })
                .reduce(1.0, (res,item) -> res * item); // tính tích toàn bộ các gia trị

        //In kết quả
        System.out.println("Tích toàn bộ giá trị 1/(x^2 + y): "+ totalProduct);

        // in ra danh sách x+y >7
        points.stream()
                .filter(p->(p.getX()+p.getY()>7))
                .forEach(System.out::println);

        System.out.println("#######################");

        //in ra danh sách x>5 và y>1
        points.stream()
                .filter(p->(p.getX()>5 && p.getY()>1))
                .forEach(System.out::println);

        //In kết quả
        System.out.println("Tổng tất cả các giá trị: "+ totalSum);
        System.out.println("Tổng tất cả các giá trị x: "+ sumX);
        System.out.println("Tổng tất cả các giá trị x2: "+ sumX2);

    }


}