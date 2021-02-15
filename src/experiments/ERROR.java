public class ERROR {
    public static void main(String[] args) throws Exception{
        try{
            int num = 37/0;
        }catch(ArithmeticException ae){
            System.out.println("Don't divide by zero dingus");

            throw ae;
        }

        // throw new Exception("Get out of my code!!!");
    }
}
