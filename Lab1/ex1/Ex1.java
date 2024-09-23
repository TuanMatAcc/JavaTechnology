class Ex1 {
    public static void main(String[] args) {
        try {
            if(args.length > 3) {
                System.out.println("Invalid Expression");
                return;
            }
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[2]);
            switch(args[1]) {
                default:
                    System.out.println("Unsupported Operator");
                    break;
                case "+":
                    System.out.println(a+b);
                    break;
                case "-":
                    System.out.println(a-b);
                    break;
                case "/":
                    System.out.println(a/b);
                    break;
                case "x":
                    System.out.println(a*b);
                    break;
                case "^":
                    System.out.println(Math.pow(a, b));
            }
        }
        catch(Exception ex) {
            System.out.println("Invalid Expression");
        }
    }
}
